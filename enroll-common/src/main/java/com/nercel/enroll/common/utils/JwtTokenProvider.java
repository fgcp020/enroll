package com.nercel.enroll.common.utils;

import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 生成token的工具类
 * 
 * @author yishui
 * @date 2018年6月13日
 * @version 0.0.1
 */
public class JwtTokenProvider {
	
	private final static Logger LOG=LoggerFactory.getLogger(JwtTokenProvider.class);
	
	/**
	 * 默认的加密秘钥 yishui
	 */
	public final static String DEFAULT_KEY = "yishui";
	SecretKeySpec key;
	/**
	 * @param key
	 *            密钥(例如：12345678)
	 */
	public JwtTokenProvider(String key) {
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), SignatureAlgorithm.HS512.getJcaName());
		this.key = secretKeySpec;
	}

	/**
	 * 生成token
	 * 
	 * @return
	 */
	public String createToken(Claims claims) {
		String compactJws = Jwts.builder().setPayload(JSONObject.toJSONString(claims))
				.compressWith(CompressionCodecs.DEFLATE).signWith(SignatureAlgorithm.HS512, key).compact();
		return compactJws;
	}

	/** token转换为 */
	public Claims parseToken(String token) {
		try {
			return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return null;
	}

}