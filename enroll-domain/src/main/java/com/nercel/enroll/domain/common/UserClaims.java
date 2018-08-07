package com.nercel.enroll.domain.common;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.RequiredTypeException;
import io.jsonwebtoken.impl.JwtMap;

/**
 * 权限信息对象
 * 
 * @author Tony
 *
 */
public class UserClaims extends JwtMap implements Claims {
	private String[] scope;
	private String grantType = "password";
	private String userName; // 用户名
	private String IdCard;// 身份证号
	private Integer recordId;// 记录的Id

	public UserClaims(String userName, String idCard) {
		this.userName = userName;
		IdCard = idCard;
	}

	public UserClaims(Integer recordId) {
		this.recordId = recordId;
		setValue("recordId", this.recordId);
	}

	public UserClaims() {

	}

	public UserClaims(String idCard) {
		IdCard = idCard;
	}

	public String getIdCard() {
		return IdCard;
	}

	public void setIdCard(String idCard) {
		this.IdCard = idCard;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
		setValue("recordId", this.recordId);
	}

	public String[] getScope() {
		return scope;
	}

	public void setScope(String[] scope) {
		this.scope = scope;
		setValue("scope", this.scope);
	}

	public String getGrantType() {
		return grantType;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
		setValue("grantType", this.grantType);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		setValue("userName", this.userName);
	}

	public String getIssuer() {
		return getString(ISSUER);
	}

	public Claims setIssuer(String iss) {
		setValue(ISSUER, iss);
		return this;
	}

	public String getSubject() {
		return getString(SUBJECT);
	}

	public Claims setSubject(String sub) {
		setValue(SUBJECT, sub);
		return this;
	}

	public String getAudience() {
		return getString(AUDIENCE);
	}

	public Claims setAudience(String aud) {
		setValue(AUDIENCE, aud);
		return this;
	}

	public Date getExpiration() {
		return get(Claims.EXPIRATION, Date.class);
	}

	public Claims setExpiration(Date exp) {
		setDate(Claims.EXPIRATION, exp);
		return this;
	}

	public Date getNotBefore() {
		return get(Claims.NOT_BEFORE, Date.class);
	}

	public Claims setNotBefore(Date nbf) {
		setDate(Claims.NOT_BEFORE, nbf);
		return this;
	}

	public Date getIssuedAt() {
		return get(Claims.ISSUED_AT, Date.class);
	}

	public Claims setIssuedAt(Date iat) {
		setDate(Claims.ISSUED_AT, iat);
		return this;
	}

	public String getId() {
		return getString(ID);
	}

	public Claims setId(String jti) {
		setValue(Claims.ID, jti);
		return this;
	}

	public <T> T get(String claimName, Class<T> requiredType) {
		Object value = get(claimName);
		if (value == null) {
			return null;
		}

		if (Claims.EXPIRATION.equals(claimName) || Claims.ISSUED_AT.equals(claimName)
				|| Claims.NOT_BEFORE.equals(claimName)) {
			value = getDate(claimName);
		}

		if (requiredType == Date.class && value instanceof Long) {
			value = new Date((Long) value);
		}

		if (!requiredType.isInstance(value)) {
			throw new RequiredTypeException(
					"Expected value to be of type: " + requiredType + ", but was " + value.getClass());
		}

		return requiredType.cast(value);
	}

}