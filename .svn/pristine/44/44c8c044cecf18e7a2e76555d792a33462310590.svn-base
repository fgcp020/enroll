package com.nercel.enroll.domain.vo;

import java.io.Serializable;
import java.util.List;

import com.nercel.enroll.domain.model.beans.User;
import com.nercel.enroll.domain.model.beans.UserExtendedInfo;
import com.nercel.enroll.domain.model.beans.UserGuardianInfo;
import com.nercel.enroll.domain.model.beans.UserHouseInfo;
import com.nercel.enroll.domain.model.beans.UserPhotoInfo;

/**
 * 用户信息集合
 * 
 * @author yishui
 * @date 2018年6月13日
 * @version 0.0.1
 */
public class UserVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7026288804540052994L;
	/**
	 * 用户基本信息
	 */
	private User user;
	/**
	 * 用户扩展信息
	 */
	private UserExtendedInfo userExtendedInfo;
	/**
	 * 用户监护人信息
	 */
	private List<UserGuardianInfo> userGuardianInfos;
	/**
	 * 用户房产信息
	 */
	private UserHouseInfo userHouseInfo;
	/**
	 * 用户照片信息
	 */
	private List<UserPhotoInfo> userPhotoInfos;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserExtendedInfo getUserExtendedInfo() {
		return userExtendedInfo;
	}
	public void setUserExtendedInfo(UserExtendedInfo userExtendedInfo) {
		this.userExtendedInfo = userExtendedInfo;
	}
	public List<UserGuardianInfo> getUserGuardianInfos() {
		return userGuardianInfos;
	}
	public void setUserGuardianInfos(List<UserGuardianInfo> userGuardianInfos) {
		this.userGuardianInfos = userGuardianInfos;
	}
	public UserHouseInfo getUserHouseInfo() {
		return userHouseInfo;
	}
	public void setUserHouseInfo(UserHouseInfo userHouseInfo) {
		this.userHouseInfo = userHouseInfo;
	}
	public List<UserPhotoInfo> getUserPhotoInfos() {
		return userPhotoInfos;
	}
	public void setUserPhotoInfos(List<UserPhotoInfo> userPhotoInfos) {
		this.userPhotoInfos = userPhotoInfos;
	}
	@Override
	public String toString() {
		return "UserVo [user=" + user + ", userExtendedInfo=" + userExtendedInfo + ", userGuardianInfos="
				+ userGuardianInfos + ", userHouseInfo=" + userHouseInfo + ", userPhotoInfos=" + userPhotoInfos + "]";
	}
	public UserVo() {

	}
	public UserVo(User user, UserExtendedInfo userExtendedInfo, List<UserGuardianInfo> userGuardianInfos,
			UserHouseInfo userHouseInfo, List<UserPhotoInfo> userPhotoInfos) {
		this.user = user;
		this.userExtendedInfo = userExtendedInfo;
		this.userGuardianInfos = userGuardianInfos;
		this.userHouseInfo = userHouseInfo;
		this.userPhotoInfos = userPhotoInfos;
	}



}
