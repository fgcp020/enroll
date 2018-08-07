package com.nercel.enroll.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nercel.enroll.common.entity.SmsException;
import com.nercel.enroll.common.utils.SmsService;
import com.nercel.enroll.core.service.DegreeeApplicationService;
import com.nercel.enroll.dao.impl.ApplyInfoDao;
import com.nercel.enroll.dao.impl.SchoolDao;
import com.nercel.enroll.dao.impl.UserDao;
import com.nercel.enroll.domain.common.CustomeException;
import com.nercel.enroll.domain.constant.ApplyStatuConstant;
import com.nercel.enroll.domain.constant.ApprovalConstant;
import com.nercel.enroll.domain.constant.Constant;
import com.nercel.enroll.domain.constant.RoleConstant;
import com.nercel.enroll.domain.model.beans.ApplyInfo;
import com.nercel.enroll.domain.model.beans.School;
import com.nercel.enroll.domain.model.beans.User;
import com.nercel.enroll.domain.vo.ApplyVo;

/**
 * DegreeeApplicationService接口实现类
 * 
 * @author yishui
 * @date 2018年7月2日
 * @version 0.0.1
 */
@Service
public class DegreeeApplicationServiceImpl extends BaseService implements DegreeeApplicationService {

	private final static Logger LOG = LoggerFactory.getLogger(DegreeeApplicationService.class);

	/**
	 * 学位申请记录接口
	 */
	@Autowired
	private ApplyInfoDao applyInfoDao;
	/**
	 * 用户基本信息接口
	 */
	@Autowired
	private UserDao userDao;
	/**
	 * 
	 */
	@Autowired
	private SchoolDao schoolDao;

	@Autowired
	private SmsService smsService;

	@Override
	public ApplyVo queryDegreeApplyInfo(String token) throws CustomeException {

		List<ApplyInfo> applyInfos = applyInfoDao.queryApplyInfoByUserId(checkToken(token));
		if (applyInfos != null && applyInfos.size() > 0) {
			return queryApplyInfo(applyInfos.get(0));
		}

		return null;
	}

	@Override
	public List<ApplyVo> queryDegreeApplyInfomation(String token) throws CustomeException {
		User user = checkToken(token, null);
		if (user != null) {
			return convertApplyInfo(applyInfoDao.queryApplyInfoBySchoolId(user.getSchoolId()));
		}
		return null;
	}

	@Override
	public List<ApplyVo> queryDegreeApplyInfo(String token, Integer schoolId, String studentName, String idCard,
			Integer applyStatu, Integer schoolType) throws CustomeException {

		checkToken(token, RoleConstant.SCHOOL_MANAGER);

		// 查询出所有的申请信息
		List<ApplyInfo> applyInfos = applyInfoDao.queryApplyInfoByUserAndSChoolCondtion(schoolId,
				StringUtils.isBlank(studentName) ? null : studentName, StringUtils.isBlank(idCard) ? null : idCard,
				applyStatu, schoolType);

		return convertApplyInfo(applyInfos);

	}

	@Override
	public Boolean updateApplyStatus(String token, Integer studentId, Integer applyId, Integer applyStatus,
			String approveOpinion) throws CustomeException {
		if (!Constant.AUDIT_SWITCH) {
			throw new CustomeException("不在审核的时间范围内!");
		}
		if (applyId == null || applyStatus == null) {
			throw new CustomeException("参数有误!");
		}
		// 查询出操作者的信息
		User user = checkToken(token, RoleConstant.SCHOOL_MANAGER);
		User student = userDao.queryUserById(studentId);
		//查询出申请信息
		ApplyInfo applyInfo = applyInfoDao.queryApplyInfoById(applyId);
		if (applyInfo != null) {
			if (applyInfo.getApplyStatus() == ApplyStatuConstant.APPROVE_SUCCESS) {
				throw new CustomeException("该学生已经审核通过，不能二次审核");
			}

			applyInfoDao.updateApplyInfoById(new ApplyInfo(applyId, applyStatus, user.getId(),
					System.currentTimeMillis(), approveOpinion, applyStatus == ApplyStatuConstant.APPROVE_SUCCESS
							? ApprovalConstant.APPROVAL_CHECK : ApprovalConstant.APPROVAL_FAIL));
			try {
				if (applyStatus != ApplyStatuConstant.APPROVE_SUCCESS) {
					smsService.sendFailMessage(student.getPhone());
				}

			} catch (SmsException e) {
				LOG.error(e.getMessage());
			}
			return true;

		}

		return false;
	}

	@Override
	public List<ApplyVo> queryUnassignedStudent(String token, Integer schoolType) throws CustomeException {
		// 查询出操作者的信息
		checkToken(token, RoleConstant.SCHOOL_MANAGER);

		return convertApplyInfo(
				applyInfoDao.queryApplyInfoBySchoolTypeAndStatus(schoolType, ApplyStatuConstant.APPROVE_SUCCESS));

	}

	@Override
	public Boolean updateApplySchool(String token, Integer userId, Integer schoolId, Integer applyId)
			throws CustomeException {

		if (!Constant.AUDIT_SWITCH) {
			throw new CustomeException("不在审核的时间范围内!");
		}

		// 查询出操作者的信息
		userDao.queryUserById(checkToken(token));

		School school = schoolDao.querySchoolById(schoolId);
		if (school != null) {
			applyInfoDao.updateApplyInfoById(new ApplyInfo(applyId, userId, schoolId, "分区划片",
					ApplyStatuConstant.APPROVE_SUCCESS, checkToken(token), System.currentTimeMillis(),
					ApprovalConstant.APPROVAL_CHECK, school.getName(), ApprovalConstant.APPROVAL_CHECK));
			return true;
		}

		return false;
	}

	@Override
	public List<ApplyVo> queryUnassignedStudent(String token, Integer schoolType, String studentName, String idCard)
			throws CustomeException {
		// 查询出操作者的信息
		userDao.queryUserById(checkToken(token));
		return convertApplyInfo(applyInfoDao.queryApplyInfoByCondition(schoolType,
				StringUtils.isNotBlank(studentName) ? studentName : null,
				StringUtils.isNotBlank(idCard) ? idCard : null, ApplyStatuConstant.INFO_UNCOMPLETE));
	}

	/**
	 * 转换申请情路到申请记录全信息
	 * 
	 * @param applyInfos
	 * @return
	 */
	private List<ApplyVo> convertApplyInfo(List<ApplyInfo> applyInfos) {
		List<ApplyVo> list = new ArrayList<>();
		if (applyInfos != null) {
			for (ApplyInfo applyInfo : applyInfos) {
				list.add(queryApplyInfo(applyInfo));
			}
		}
		return list;
	}

	/**
	 * 根据申请记录获取全部的申请信息
	 * 
	 * @param applyInfo
	 *            申请记录
	 * @return
	 */
	private ApplyVo queryApplyInfo(ApplyInfo applyInfo) {
		ApplyVo applyVo = null;
		if (applyInfo != null) {
			User approver = null;
			applyVo = new ApplyVo();
			BeanUtils.copyProperties(applyInfo, applyVo);
			// 有返回信息时
			if (applyInfo.getApprover() != null) {
				// 当有人审核时
				// 查询出审批人信息
				approver = userDao.queryUserById(applyInfo.getApprover());
				applyVo.setApproverName(approver != null ? approver.getUsername() : null);
			}
			// ApplyVo = new ApplyVo(applyInfo, approver);
		}
		return applyVo;
	}

}
