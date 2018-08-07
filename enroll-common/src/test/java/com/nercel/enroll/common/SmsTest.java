package com.nercel.enroll.common;

import java.util.Map;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;

public class SmsTest {

	public static void main(String[] args) {
		//初始化clnt,使用单例方式
		YunpianClient clnt = new YunpianClient("ac06d24cd6917c4faf79064e213d5a81").init();

		//发送短信API
		Map<String, String> param = clnt.newParam(2);
		param.put(YunpianClient.MOBILE, "13035141689");
		param.put(YunpianClient.TEXT, "【当阳市智慧招生】您提交的申请已通过,请登录招生平台查询详细信息.");
		Result<SmsSingleSend> r = clnt.sms().single_send(param);
		//获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable()

		//账户:clnt.user().* 签名:clnt.sign().* 模版:clnt.tpl().* 短信:clnt.sms().* 语音:clnt.voice().* 流量:clnt.flow().* 隐私通话:clnt.call().*

		//释放clnt
		clnt.close() ;
		System.out.println(r.getMsg());

	}

}
