package com.nercel.enroll.common.sms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

/**
 * 短信http接口的java代码调用示例 基于Apache HttpClient 4.3
 *
 * @author songchao
 * @since 2015-04-03
 */

public class YunpianSimpleApi {

	private static String api_key = "21fa4787df51950acafb2e4cb4a2c837";

	// 智能匹配模板发送接口的http地址
	private static String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

	// 批量发送接口的http地址
	private static String URI_SEND_SMSES = "https://sms.yunpian.com/v2/sms/batch_send.json";

	// 编码格式。发送编码格式统一用UTF-8
	private static String ENCODING = "UTF-8";

	public static SmsResult sendSmS(String mobile, String content) throws IOException {
		String result = YunpianSimpleApi.sendSms(api_key, content, mobile);
		SmsResult resultobj = JSON.parseObject(result, SmsResult.class);
		if (resultobj.getCode() == 0) {
			System.out.println("发送调用成功，Result:" + result);
		} else {
			System.err.println("发送调用失败，Result:" + result);
		}
		return resultobj;
	}

	public static SmsesResult sendSmSes(String mobile, String content) throws IOException {
		String result = YunpianSimpleApi.sendSmses(api_key, content, mobile);
		SmsesResult resultobj = JSON.parseObject(result, SmsesResult.class);
		if (resultobj != null && resultobj.getTotal_count() > 0) {
			System.out.println(new Date() + "--->发送调用成功，Result:" + result);
		} else {
			System.err.println(new Date() + "--->发送调用失败，Result:" + result + ",短信内容:" + content);

		}
		return resultobj;
	}

	/**
	 * 智能匹配模板接口发短信
	 *
	 * @param apikey
	 *            apikey
	 * @param text
	 *            短信内容
	 * @param mobile
	 *            接受的手机号
	 * @return json格式字符串
	 * @throws IOException
	 */
	public static String sendSms(String apikey, String text, String mobile) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", apikey);
		params.put("text", text);
		params.put("mobile", mobile);
		return post(URI_SEND_SMS, params);
	}

	public static String sendSmses(String apikey, String text, String mobile) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put("apikey", apikey);
		params.put("text", text);
		params.put("mobile", mobile);
		return post(URI_SEND_SMSES, params);
	}

	/**
	 * 基于HttpClient 4.3的通用POST方法
	 *
	 * @param url
	 *            提交的URL
	 * @param paramsMap
	 *            提交<参数，值>Map
	 * @return 提交响应
	 */
	public static String post(String url, Map<String, String> paramsMap) {
		CloseableHttpClient client = HttpClients.createDefault();
		String responseText = "";
		CloseableHttpResponse response = null;
		try {
			HttpPost method = new HttpPost(url);
			if (paramsMap != null) {
				List<NameValuePair> paramList = new ArrayList<NameValuePair>();
				for (Map.Entry<String, String> param : paramsMap.entrySet()) {
					NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
					paramList.add(pair);
				}
				method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
			}
			response = client.execute(method);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				responseText = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return responseText;
	}

}
