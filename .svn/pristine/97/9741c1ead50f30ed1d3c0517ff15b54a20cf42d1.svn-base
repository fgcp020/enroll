package com.nercel.enroll.common;

import java.io.IOException;

import org.junit.Test;

import com.nercel.enroll.common.sms.SmsesResult;
import com.nercel.enroll.common.sms.YunpianSimpleApi;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	
	
	public static void main(String[] args) throws IOException {
		String content = "【智慧招生平台】您的注册验证码为：" + 123456 + "，验证码有效期为10分钟。";
		String phone = "13035141689";
		SmsesResult result = YunpianSimpleApi.sendSmSes(phone, content);
		System.out.println(result);

	}
}
