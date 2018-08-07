package com.nercel.enroll.domain.dto;

import java.io.Serializable;

/**
 * 接受登录参数
 * 
 * @author yishui
 * @date 2018年6月19日
 * @version 0.0.1
 */
public class UserDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7047579577232800980L;
	/**
	 * 用户的身份证号
	 */
	private String idCard;
	/**
	 * 用户的密码
	 */
	private String pwd;

	public UserDto() {

	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public UserDto(String idCard, String pwd) {
		this.idCard = idCard;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UserDto [idCard=" + idCard + ", pwd=" + pwd + "]";
	}

}
