package com.nercel.enroll.domain.model.beans;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nercel.enroll.domain.common.BaseEntity;

/**
 * @ClassName: User
* @Description: user表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class User extends BaseEntity implements Serializable {

	/**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields user.Id :
     */
    private Integer id;

    /**
     * @Fields user.username :用户名
     */
    private String username;

    /**
     * @Fields user.pwd :密码
     */
    
    private String pwd;

    /**
     * @Fields user.id_card :身份证号
     */
    private String idCard;

    /**
     * @Fields user.phone :手机号
     */
    private String phone;

    /**
     * @Fields user.permanent_address :户籍地址
     */
    private String permanentAddress;

    /**
     * @Fields user.type :学生类别(一类，二类，三类)
     */
    private Integer type;

    /**
     * @Fields user.apply_status :申请状态
     */
    @JsonIgnore
    private Boolean applyStatus;

    /**
     * @Fields user.sex :性别（0女1男）
     */
    private Integer sex;

    /**
     * @Fields user.role :学生的角色(1幼升小、2小升初、3学校、4教育局)
     */
    private Integer role;

    /**
     * @Fields user.create_time :申请时间
     */
    private Long createTime;

    /**
     * @Fields user.school_id :用户所属的学校(对于学生角色而言，该字段为空)
     */
    @JsonIgnore
    private Integer schoolId;

    /**
     * @return user.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of user : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user.username : 返回 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username of user : 设置 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return user.pwd : 返回 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd of user : 设置 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return user.id_card : 返回 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard of user : 设置 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return user.phone : 返回 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone of user : 设置 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return user.permanent_address : 返回 户籍地址
     */
    public String getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * @param permanentAddress of user : 设置 户籍地址
     */
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    /**
     * @return user.type : 返回 学生类别(一类，二类，三类)
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type of user : 设置 学生类别(一类，二类，三类)
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return user.apply_status : 返回 申请状态
     */
    public Boolean getApplyStatus() {
        return applyStatus;
    }

    /**
     * @param applyStatus of user : 设置 申请状态
     */
    public void setApplyStatus(Boolean applyStatus) {
        this.applyStatus = applyStatus;
    }

    /**
     * @return user.sex : 返回 性别（0女1男）
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex of user : 设置 性别（0女1男）
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return user.role : 返回 学生的角色(1幼升小、2小升初、3学校、4教育局)
     */
    public Integer getRole() {
        return role;
    }

    /**
     * @param role of user : 设置 学生的角色(1幼升小、2小升初、3学校、4教育局)
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * @return user.create_time : 返回 申请时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime of user : 设置 申请时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * @return user.school_id : 返回 用户所属的学校(对于学生角色而言，该字段为空)
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * @param schoolId of user : 设置 用户所属的学校(对于学生角色而言，该字段为空)
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", idCard=" + idCard + ", phone=" + phone
				+ ", permanentAddress=" + permanentAddress + ", type=" + type + ", applyStatus=" + applyStatus
				+ ", sex=" + sex + ", role=" + role + ", createTime=" + createTime + ", schoolId=" + schoolId + "]";
	}

	public User() {

	}

	public User(String username, String pwd, String idCard, String phone, String permanentAddress, Integer type,
			Boolean applyStatus, Integer sex, Integer role, Long createTime, Integer schoolId) {

		this.username = username;
		this.pwd = pwd;
		this.idCard = idCard;
		this.phone = phone;
		this.permanentAddress = permanentAddress;
		this.type = type;
		this.applyStatus = applyStatus;
		this.sex = sex;
		this.role = role;
		this.createTime = createTime;
		this.schoolId = schoolId;
	}

	public User(Integer id, String permanentAddress, Integer type) {
		this.id = id;
		this.permanentAddress = permanentAddress;
		this.type = type;
	}

	public User(String pwd, String idCard) {
		this.pwd = pwd;
		this.idCard = idCard;
	}
    
    
}