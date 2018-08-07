/**
 * 
 */
package com.nercel.enroll.common.utils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.nercel.enroll.common.entity.SmsException;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;

/**
 * 发送短信的工具类
 * 
 * @author yishui
 * @date 2018年7月2日
 * @version 0.0.1
 */
@Component
public class SmsService implements InitializingBean, DisposableBean {
	/**
	 * 用户的秘钥
	 */
	public static final String APIKEY = "ac06d24cd6917c4faf79064e213d5a81";
	/**
	 * 审核通过的消息
	 */
	private static final String SUC_MSG = "【当阳市智慧招生】您提交的申请已通过,请登录招生平台查询详细信息.";
	/**
	 * 审核失败的消息
	 */
	private static final String FAIL_MSG = "【当阳市智慧招生】您提交的申请已被驳回,请登录招生平台查询详细信息.";
	/**
	 * 短信发送工具
	 */
	private YunpianClient clnt;

	/**
	 * 像指定手机号发送指定内容的信息
	 * 
	 * @param phone
	 *            手机号
	 * @param content
	 *            短信内容
	 * @return code = 0: 正确返回。可以从api返回的对应字段中取数据。
	 * 
	 *         code > 0: 调用API时发生错误，需要开发者进行相应的处理。
	 * 
	 *         -50 < code < 0: 权限验证失败，需要开发者进行相应的处理。
	 * 
	 *         code = -50: 系统内部错误，请联系技术支持，调查问题原因并获得解决方案
	 * @throws CustomeException
	 */
	public synchronized Result<SmsSingleSend> sendSms(String phone, String content) throws SmsException {

		// 发送短信API
		Map<String, String> param = clnt.newParam(2);
		param.put(YunpianClient.MOBILE, phone);
		param.put(YunpianClient.TEXT, content);
		Result<SmsSingleSend> result = clnt.sms().single_send(param);
		// 获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable()

		// 账户:clnt.user().* 签名:clnt.sign().* 模版:clnt.tpl().* 短信:clnt.sms().*
		// 语音:clnt.voice().* 流量:clnt.flow().* 隐私通话:clnt.call().*

		// 释放clnt

		if (!(result != null && result.getCode() == 0)) {
			throw new SmsException("短信平台信息提示:"+result.getMsg());
		}
		return result;
	}

	/**
	 * 向指定手机发送短信验证码
	 * 
	 * @param phone
	 *            手机号码
	 * @param code
	 *            短信验证码
	 * @return
	 * @throws CustomeException
	 */
	public synchronized Boolean sendValidateCode(String phone, String code) throws SmsException {
		if (StringUtils.isBlank(phone)) {
			throw new SmsException("手机号码不能为空");
		}
		Result<SmsSingleSend> result = this.sendSms(phone, "【当阳市智慧招生】您的验证码是" + code);
		return result.getCode() == 0;
	}

	/**
	 * 向指定手机号发送驳回信息
	 * 
	 * @param phone
	 *            手机号码
	 * @return
	 * @throws SmsException
	 */
	public synchronized Boolean sendFailMessage(String phone) throws SmsException {
		Result<SmsSingleSend> result = this.sendSms(phone, FAIL_MSG);
		return result.getCode() == 0;
	}

	/**
	 * 向指定手机号发送成功信息
	 * 
	 * @param phone
	 *            手机号码
	 * @return
	 * @throws SmsException
	 */
	public synchronized Boolean sendSucMessage(String phone) throws SmsException {
		Result<SmsSingleSend> result = this.sendSms(phone, SUC_MSG);
		return result.getCode() == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		if (clnt != null) {
			clnt.close();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		// 初始化clnt,使用单例方式
		clnt = new YunpianClient(APIKEY).init();

	}

}
