package com.nercel.enroll.core.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nercel.enroll.common.entity.DateFormatException;
import com.nercel.enroll.common.utils.SmsService;
import com.nercel.enroll.core.service.BasicOperateService;
import com.nercel.enroll.core.service.utils.DateUtil;
import com.nercel.enroll.dao.impl.PlanTimeDao;
import com.nercel.enroll.dao.impl.SmsCodeDao;
import com.nercel.enroll.dao.impl.UserDao;
import com.nercel.enroll.domain.common.CustomeException;
import com.nercel.enroll.domain.constant.Constant;
import com.nercel.enroll.domain.constant.RoleConstant;
import com.nercel.enroll.domain.dto.PlanTimeDto;
import com.nercel.enroll.domain.model.beans.PlanTime;
import com.nercel.enroll.domain.model.beans.SmsCode;
import com.nercel.enroll.domain.model.beans.User;

/**
 * 基础操作行为接口实现类
 * 
 * @author yishui
 * @date 2018年6月29日
 * @version 0.0.1
 */
@Service
public class BasicOperateServiceImpl extends BaseService implements BasicOperateService {
	private static final Logger LOG = LoggerFactory.getLogger(BasicOperateServiceImpl.class);
	/**
	 * 发送短信的间隔时间
	 */
	@Value("${messageIntervalTime}")
	private Integer messageIntervalTime;
	@Autowired
	private SmsCodeDao smsCodeDao;

	@Autowired
	private PlanTimeDao planTimeDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SmsService smsService;

	/**
	 * 注册的年龄限制时间
	 */
	@Value("${limitTime}")
	private String limitTime;

	@Override
	public Boolean sendSmsCode(String phone) throws IOException, Exception {
		if (StringUtils.isBlank(phone)) {
			return false;
		}
		List<SmsCode> smsCodes = smsCodeDao.querySmsCodeByPhone(phone);
		Boolean flag = false;
		for (SmsCode sms : smsCodes) {
			if (System.currentTimeMillis() - sms
					.getCreateTime() < (messageIntervalTime == null ? Constant.MSG_DEFAULT_TIME : messageIntervalTime)
							* 60 * 1000) {
				flag = true;
				break;
			}
		}
		if (flag) {
			throw new CustomeException(String.format("相同手机号的短信验证码获取时间间隔必须大于 %s分钟",
					(messageIntervalTime == null ? Constant.MSG_DEFAULT_TIME : messageIntervalTime)));
		}

		// 短信验证码
		String code = ((int) ((Math.random() * 9 + 1) * 100000)) + "";
		// 验证码内容
		Boolean result = smsService.sendValidateCode(phone, code);
		if (result) {
			smsCodeDao.saveSmsCode(new SmsCode(phone, code, System.currentTimeMillis()));
		}
		return result;

	}

	@Override
	public Boolean querySmsCode(String phone, String smsCode) {
		if (StringUtils.isBlank(phone) || StringUtils.isBlank(smsCode)) {
			return false;
		}
		List<SmsCode> smsCodes = smsCodeDao.querySmsCodeByPhoneAndCode(phone, smsCode);
		Boolean flag = false;
		// 防止匹配文件里没有配置
		if (messageIntervalTime == null) {
			messageIntervalTime = Constant.MSG_DEFAULT_TIME;
		}
		for (SmsCode sms : smsCodes) {
			if (System.currentTimeMillis() - sms.getCreateTime() < messageIntervalTime * 60 * 1000) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	@Override
	public Boolean savePlanTime(String token, PlanTimeDto planTimeDto) {
		Boolean flag = false;
		if (planTimeDto != null) {
			try {
				Integer result = planTimeDao
						.savePlanTime(new PlanTime(DateUtil.convertDateTime(planTimeDto.getRegisterStartTime()),
								DateUtil.convertDateTime(planTimeDto.getRegisterEndTime()),
								DateUtil.convertDateTime(planTimeDto.getApplyStartTime()),
								DateUtil.convertDateTime(planTimeDto.getApplyEndTime()),
								DateUtil.convertDateTime(planTimeDto.getSchoolCheckStartTime()),
								DateUtil.convertDateTime(planTimeDto.getSchoolCheckEndTime()),
								DateUtil.convertDateTime(planTimeDto.getSchoolInvestStartTime()),
								DateUtil.convertDateTime(planTimeDto.getSchoolInvestEndTime()),
								DateUtil.convertDateTime(planTimeDto.getCityCheckTimeStartTime()),
								DateUtil.convertDateTime(planTimeDto.getCityCheckTimeEndTime()),
								DateUtil.convertDateTime(planTimeDto.getCityPlanStartTime()),
								DateUtil.convertDateTime(planTimeDto.getCityPlanEndTime()),
								DateUtil.convertDateTime(planTimeDto.getPrintNoticeStartTime()),
								DateUtil.convertDateTime(planTimeDto.getPrintNoticeEndTime()),
								DateUtil.convertDateTime(planTimeDto.getDivisionStartTime()),
								DateUtil.convertDateTime(planTimeDto.getDivisionEndTime()),
								DateUtil.convertDateTime(planTimeDto.getDataAbutmentStartTime()),
								DateUtil.convertDateTime(planTimeDto.getDataAbutmentEndTime())));
				flag = (result == 1) ? true : false;
			} catch (DateFormatException e) {
				LOG.error(e.getMessage());
			} catch (ParseException e) {
				LOG.error(e.getMessage());
			}
		}
		return flag;
	}

	@Override
	public Boolean updateAuditStatu(String token, Boolean statu) throws CustomeException {
		checkToken(token, RoleConstant.SYSTEM_USER);
		Constant.AUDIT_SWITCH = (statu ? true : false);
		return true;
	}

	@Override
	public Boolean queryAuditStatu(String token) throws CustomeException {
		checkToken(token, RoleConstant.SYSTEM_USER);
		return Constant.AUDIT_SWITCH;
	}

	@Override
	public PlanTime queryPlanTime() {
		List<PlanTime> planTime = planTimeDao.queryAllPlanTime();
		return planTime == null ? null : planTime.get(0);
	}

	@Override
	public Boolean validateCard(String idCard) throws CustomeException, ParseException {
		// 身份号不能为空
		if (StringUtils.isBlank(idCard)) {
			throw new CustomeException("身份证号不能为空!");
		}
		// 进行年龄校验
		if (!DateUtil.compare(idCard, limitTime)) {
			throw new CustomeException(String.format("出生日期必须在%s之前的才能注册", limitTime));
		}
		// 校验身份证号
		List<User> users = userDao.queryUserByIdCard(idCard);
		if ((users != null && users.size() > 0)) {
			throw new CustomeException("该用户已经注册过，不能重复注册!");
		}
		return true;
	}

}
