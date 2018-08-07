package com.nercel.enroll.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nercel.enroll.common.entity.SmsException;
import com.nercel.enroll.common.utils.SmsService;
import com.nercel.enroll.core.service.SchoolDegreeService;
import com.nercel.enroll.dao.impl.ApplyInfoDao;
import com.nercel.enroll.dao.impl.SchoolDao;
import com.nercel.enroll.dao.impl.StreetSchoolDao;
import com.nercel.enroll.dao.impl.UserDao;
import com.nercel.enroll.domain.common.CustomeException;
import com.nercel.enroll.domain.constant.ApplyStatuConstant;
import com.nercel.enroll.domain.constant.ApprovalConstant;
import com.nercel.enroll.domain.constant.RoleConstant;
import com.nercel.enroll.domain.model.beans.ApplyInfo;
import com.nercel.enroll.domain.model.beans.School;
import com.nercel.enroll.domain.model.beans.StreetSchool;
import com.nercel.enroll.domain.model.beans.User;
import com.nercel.enroll.domain.vo.UserVo;

/**
 * 学位分配服务实现类
 * 
 * @author yishui
 * @date 2018年6月14日
 * @version 0.0.1
 */
@Service
public class SchoolDegreeServiceImpl extends BaseService implements SchoolDegreeService {
	private final static Logger LOG = LoggerFactory.getLogger(SchoolDegreeService.class);

	@Autowired
	private StreetSchoolDao streetSchoolDao;
	@Autowired
	private ApplyInfoDao applyInfoDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private SmsService smsService;

	@Override
	public void saveSchoolDegree(User user, UserVo userVo) {
		if (userVo != null && userVo.getUser() != null
				&& StringUtils.isNotBlank(userVo.getUser().getPermanentAddress())) {
			StreetSchool streetSchool = this.querySchoolByCondition(user, userVo);
			LOG.info("==============>用户{} 匹配到的学校为 {}", user, streetSchool);
			// 保存申请信息
			School school = null;
			if (streetSchool != null) {
				List<School> schools = schoolDao.querySchoolByName(streetSchool.getSchoolName());
				if (schools != null && schools.size() > 0) {
					school = schools.get(0);
				}
			}
			applyInfoDao.saveApplyInfo(new ApplyInfo(user.getId(), school != null ? school.getId() : null,
					streetSchool != null ? ApplyStatuConstant.UN_APPROVE : ApplyStatuConstant.INFO_UNCOMPLETE,
					System.currentTimeMillis(), user.getUsername(), user.getIdCard(), user.getRole(), user.getRole(),
					streetSchool != null ? streetSchool.getSchoolName() : null,
					streetSchool != null ? ApprovalConstant.WAIT_MSG : ApprovalConstant.UN_MATCH_SCHOOL));

		}

	}

	@Override
	public void updateSchoolDegree(User user, UserVo userVo) {
		// 根据id获取用户的全部基础信息
		user = userDao.queryUserById(user.getId());
		// 根据学生的id查询出学位申请记录
		List<ApplyInfo> applyInfos = applyInfoDao.queryApplyInfoByUserId(user.getId());
		if (applyInfos != null && applyInfos.size() > 0) {
			ApplyInfo applyInfo = applyInfos.get(0);
			// 查询出分配到学校
			StreetSchool streetSchool = this.querySchoolByCondition(user, userVo);
			LOG.info("=============>用户{} 匹配到的学校为 {}", user, streetSchool);
			if (streetSchool != null) {
				List<School> schools = schoolDao.querySchoolByName(streetSchool.getSchoolName());
				applyInfo.setApplySchool(schools != null && schools.size() > 0 ? schools.get(0).getId() : null);
				applyInfo.setApplySchoolName(streetSchool.getSchoolName());
				applyInfo.setApplyStatus(ApplyStatuConstant.UN_APPROVE);
				applyInfo.setTooltip(ApprovalConstant.WAIT_MSG);
				// 把信息更新到数据库
				applyInfoDao.updateApplyInfoSelectiveById(applyInfo);
			}

		}

	}

	/**
	 * 根据信息划分出学生的对应学校（申请逻辑需要后期优化）
	 * 
	 * @param user
	 * @param userVo
	 * @return
	 */
	private StreetSchool querySchoolByCondition(User user, UserVo userVo) {
		// 根据地址匹配出对应的学校
		List<StreetSchool> streetSchools = streetSchoolDao
				.queryStreetSchoolByStreetAndType(userVo.getUser().getPermanentAddress(), user.getRole());
		if (streetSchools != null && streetSchools.size() > 0) {
			if (streetSchools.size() == 1) {
				// 只查询到一个匹配学校，就选择当前学校
				return streetSchools.get(0);
			} else {
				// 如果查询到多个学校，先查询第一个学校的人数是否满足，不满足就放到第二个学校
				// 这里先查询出第一个学校的信息
				List<School> firstcandidates = schoolDao.querySchoolByName(streetSchools.get(0).getSchoolName());
				if (firstcandidates != null && firstcandidates.size() > 0) {
					// 该学小已经录取的学生的数量
					Integer enrollNum = applyInfoDao.queryCountBySchool(firstcandidates.get(0).getId());
					// 如果学生数量已满，就分配到第二个学校
					if (enrollNum != null && firstcandidates.get(0).getFirstKindNumber() != null) {
						return (enrollNum == firstcandidates.get(0).getFirstKindNumber()) ? streetSchools.get(1)
								: streetSchools.get(0);
					}

				}
				return streetSchools.get(0);
			}

		}
		return null;
	}

	@Override
	public Integer[] sendConfirmSms(String token, List<Integer> studentIds) throws CustomeException {
		// 成功发送短信的数据
		int sucNum = 0;
		// 失败发送短信的数量为
		int failNum = 0;
		// 查询出操作者的信息
		checkToken(token, RoleConstant.SCHOOL_MANAGER);
		if (studentIds != null && studentIds.size() > 0) {
			for (Integer studentId : studentIds) {
				// 查询出当前用户的信息
				User user = userDao.queryUserById(studentId);
				if (user != null && (user.getRole() == RoleConstant.PRIMARY_SCHOOL
						|| user.getRole() == RoleConstant.JUNIOR_SCHOOL)) {
					// 查询出改学生的申请记录
					List<ApplyInfo> applyInfos = applyInfoDao.queryApplyInfoByUserId(studentId);
					if (applyInfos != null && applyInfos.size() > 0 && applyInfos.get(0) != null
							&& applyInfos.get(0).getApplyStatus() == ApplyStatuConstant.APPROVE_SUCCESS) {
						// 为了保险起见，只有审核成功的人才会给他发送成功的短信
						try {
							Boolean result = smsService.sendSucMessage(user.getPhone());
							if (result) {
								sucNum += 1;
								applyInfoDao.updateApplyInfoByStudentId(new ApplyInfo(studentId,
										ApplyStatuConstant.SENT_SMS, ApprovalConstant.APPROVAL_SUCCESS));
							}
						} catch (SmsException e) {
							failNum += 1;
							LOG.info("向手机号{}发送录取短信是出现问题，出现问题的原因为 {}", e.getMessage());
						}
					}

				}
			}
			return new Integer[] { studentIds.size(), sucNum, failNum };

		} else {
			throw new CustomeException("传入的参数不正确");
		}
	}

}
