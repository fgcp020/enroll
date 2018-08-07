package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: UserPhotoInfo
 * @Description: user_photo_info表对应的java bean类
 * @author: linyl linyuliang.85@gmail.com
 */
public class UserPhotoInfo extends BaseEntity implements Serializable {
	/**
	 * @Fields serialVersionUID : 自动生成默认序列化ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @Fields user_photo_info.Id :
	 */
	private Integer id;

	/**
	 * @Fields user_photo_info.photo_path :照片的存储地址
	 */
	private String photoPath;

	/**
	 * @Fields user_photo_info.photo_url :照片的预览地址
	 */
	private String photoUrl;

	/**
	 * @Fields user_photo_info.user_id :上传的用户
	 */
	private Integer userId;

	/**
	 * @Fields user_photo_info.create_time :上传的时间
	 */
	private Long createTime;

	/**
	 * @Fields user_photo_info.photo_type :照片的类型
	 */
	private Integer photoType;

	/**
	 * @Fields user_photo_info.update_time :更新时间
	 */
	private Long updateTime;

	/**
	 * @Fields user_photo_info.base64 :图片的base64编码
	 */
	private String base64;

	/**
	 * @return user_photo_info.Id : 返回
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            of user_photo_info : 设置
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return user_photo_info.photo_path : 返回 照片的存储地址
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * @param photoPath
	 *            of user_photo_info : 设置 照片的存储地址
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	/**
	 * @return user_photo_info.photo_url : 返回 照片的预览地址
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param photoUrl
	 *            of user_photo_info : 设置 照片的预览地址
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	/**
	 * @return user_photo_info.user_id : 返回 上传的用户
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            of user_photo_info : 设置 上传的用户
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return user_photo_info.create_time : 返回 上传的时间
	 */
	public Long getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            of user_photo_info : 设置 上传的时间
	 */
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return user_photo_info.photo_type : 返回 照片的类型
	 */
	public Integer getPhotoType() {
		return photoType;
	}

	/**
	 * @param photoType
	 *            of user_photo_info : 设置 照片的类型
	 */
	public void setPhotoType(Integer photoType) {
		this.photoType = photoType;
	}

	/**
	 * @return user_photo_info.update_time : 返回 更新时间
	 */
	public Long getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            of user_photo_info : 设置 更新时间
	 */
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return user_photo_info.base64 : 返回 图片的base64编码
	 */
	public String getBase64() {
		return base64;
	}

	/**
	 * @param base64
	 *            of user_photo_info : 设置 图片的base64编码
	 */
	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public UserPhotoInfo(String photoPath, String photoUrl, Integer photoType, String base64) {
		this.photoPath = photoPath;
		this.photoUrl = photoUrl;
		this.photoType = photoType;
		this.base64 = base64;
	}

	public UserPhotoInfo(Integer userId, Long createTime, Integer photoType, Long updateTime, String base64) {
		this.userId = userId;
		this.createTime = createTime;
		this.photoType = photoType;
		this.updateTime = updateTime;
		this.base64 = base64;
	}

	public UserPhotoInfo() {

	}

	@Override
	public String toString() {
		return "UserPhotoInfo [id=" + id + ", photoPath=" + photoPath + ", photoUrl=" + photoUrl + ", userId=" + userId
				+ ", createTime=" + createTime + ", photoType=" + photoType + ", updateTime=" + updateTime + ", base64="
				+ base64 + "]";
	}
	
	
	
}