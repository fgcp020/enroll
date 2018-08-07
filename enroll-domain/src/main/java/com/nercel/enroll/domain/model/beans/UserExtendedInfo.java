package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: UserExtendedInfo
* @Description: user_extended_info表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class UserExtendedInfo extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields user_extended_info.Id :
     */
    private Integer id;

    /**
     * @Fields user_extended_info.homeplace :出生地
     */
    private String homeplace;

    /**
     * @Fields user_extended_info.native_place :籍贯
     */
    private String nativePlace;

    /**
     * @Fields user_extended_info.nation :民族（对应民族表的Id）
     */
    private Integer nation;

    /**
     * @Fields user_extended_info.no_mainland :是否为港澳台侨外
     */
    private Boolean noMainland;

    /**
     * @Fields user_extended_info.country :国家、地区
     */
    private Integer country;

    /**
     * @Fields user_extended_info.id_type :证件类型
     */
    private Integer idType;

    /**
     * @Fields user_extended_info.health_condition :健康状况
     */
    private Integer healthCondition;

    /**
     * @Fields user_extended_info.one_child :是否为独生子女
     */
    private Boolean oneChild;

    /**
     * @Fields user_extended_info.graduated :是否上过幼儿园(是否小学毕业)
     */
    private Boolean graduated;

    /**
     * @Fields user_extended_info.former_school :前一阶段的学校
     */
    private String formerSchool;

    /**
     * @Fields user_extended_info.school_number :学籍号
     */
    private String schoolNumber;

    /**
     * @Fields user_extended_info.left_behind_children :是否为留守儿童
     */
    private Boolean leftBehindChildren;

    /**
     * @Fields user_extended_info.work_to_city :是否为进城务工子女
     */
    private Boolean workToCity;

    /**
     * @Fields user_extended_info.orphan :是否为孤儿
     */
    private Boolean orphan;

    /**
     * @Fields user_extended_info.disability_type :残疾类型
     */
    private Integer disabilityType;

    /**
     * @Fields user_extended_info.user_id :所属用户
     */
    private Integer userId;

    /**
     * @Fields user_extended_info.create_time :创建时间
     */
    private Long createTime;

    /**
     * @Fields user_extended_info.update_time :更新时间
     */
    private Long updateTime;

    /**
     * @Fields user_extended_info.id_number :证件号码
     */
    private String idNumber;

    /**
     * @return user_extended_info.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of user_extended_info : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_extended_info.homeplace : 返回 出生地
     */
    public String getHomeplace() {
        return homeplace;
    }

    /**
     * @param homeplace of user_extended_info : 设置 出生地
     */
    public void setHomeplace(String homeplace) {
        this.homeplace = homeplace;
    }

    /**
     * @return user_extended_info.native_place : 返回 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * @param nativePlace of user_extended_info : 设置 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * @return user_extended_info.nation : 返回 民族（对应民族表的Id）
     */
    public Integer getNation() {
        return nation;
    }

    /**
     * @param nation of user_extended_info : 设置 民族（对应民族表的Id）
     */
    public void setNation(Integer nation) {
        this.nation = nation;
    }

    /**
     * @return user_extended_info.no_mainland : 返回 是否为港澳台侨外
     */
    public Boolean getNoMainland() {
        return noMainland;
    }

    /**
     * @param noMainland of user_extended_info : 设置 是否为港澳台侨外
     */
    public void setNoMainland(Boolean noMainland) {
        this.noMainland = noMainland;
    }

    /**
     * @return user_extended_info.country : 返回 国家、地区
     */
    public Integer getCountry() {
        return country;
    }

    /**
     * @param country of user_extended_info : 设置 国家、地区
     */
    public void setCountry(Integer country) {
        this.country = country;
    }

    /**
     * @return user_extended_info.id_type : 返回 证件类型
     */
    public Integer getIdType() {
        return idType;
    }

    /**
     * @param idType of user_extended_info : 设置 证件类型
     */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    /**
     * @return user_extended_info.health_condition : 返回 健康状况
     */
    public Integer getHealthCondition() {
        return healthCondition;
    }

    /**
     * @param healthCondition of user_extended_info : 设置 健康状况
     */
    public void setHealthCondition(Integer healthCondition) {
        this.healthCondition = healthCondition;
    }

    /**
     * @return user_extended_info.one_child : 返回 是否为独生子女
     */
    public Boolean getOneChild() {
        return oneChild;
    }

    /**
     * @param oneChild of user_extended_info : 设置 是否为独生子女
     */
    public void setOneChild(Boolean oneChild) {
        this.oneChild = oneChild;
    }

    /**
     * @return user_extended_info.graduated : 返回 是否上过幼儿园(是否小学毕业)
     */
    public Boolean getGraduated() {
        return graduated;
    }

    /**
     * @param graduated of user_extended_info : 设置 是否上过幼儿园(是否小学毕业)
     */
    public void setGraduated(Boolean graduated) {
        this.graduated = graduated;
    }

    /**
     * @return user_extended_info.former_school : 返回 前一阶段的学校
     */
    public String getFormerSchool() {
        return formerSchool;
    }

    /**
     * @param formerSchool of user_extended_info : 设置 前一阶段的学校
     */
    public void setFormerSchool(String formerSchool) {
        this.formerSchool = formerSchool;
    }

    /**
     * @return user_extended_info.school_number : 返回 学籍号
     */
    public String getSchoolNumber() {
        return schoolNumber;
    }

    /**
     * @param schoolNumber of user_extended_info : 设置 学籍号
     */
    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    /**
     * @return user_extended_info.left_behind_children : 返回 是否为留守儿童
     */
    public Boolean getLeftBehindChildren() {
        return leftBehindChildren;
    }

    /**
     * @param leftBehindChildren of user_extended_info : 设置 是否为留守儿童
     */
    public void setLeftBehindChildren(Boolean leftBehindChildren) {
        this.leftBehindChildren = leftBehindChildren;
    }

    /**
     * @return user_extended_info.work_to_city : 返回 是否为进城务工子女
     */
    public Boolean getWorkToCity() {
        return workToCity;
    }

    /**
     * @param workToCity of user_extended_info : 设置 是否为进城务工子女
     */
    public void setWorkToCity(Boolean workToCity) {
        this.workToCity = workToCity;
    }

    /**
     * @return user_extended_info.orphan : 返回 是否为孤儿
     */
    public Boolean getOrphan() {
        return orphan;
    }

    /**
     * @param orphan of user_extended_info : 设置 是否为孤儿
     */
    public void setOrphan(Boolean orphan) {
        this.orphan = orphan;
    }

    /**
     * @return user_extended_info.disability_type : 返回 残疾类型
     */
    public Integer getDisabilityType() {
        return disabilityType;
    }

    /**
     * @param disabilityType of user_extended_info : 设置 残疾类型
     */
    public void setDisabilityType(Integer disabilityType) {
        this.disabilityType = disabilityType;
    }

    /**
     * @return user_extended_info.user_id : 返回 所属用户
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId of user_extended_info : 设置 所属用户
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_extended_info.create_time : 返回 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime of user_extended_info : 设置 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * @return user_extended_info.update_time : 返回 更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of user_extended_info : 设置 更新时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return user_extended_info.id_number : 返回 证件号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber of user_extended_info : 设置 证件号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

	@Override
	public String toString() {
		return "UserExtendedInfo [id=" + id + ", homeplace=" + homeplace + ", nativePlace=" + nativePlace + ", nation="
				+ nation + ", noMainland=" + noMainland + ", country=" + country + ", idType=" + idType
				+ ", healthCondition=" + healthCondition + ", oneChild=" + oneChild + ", graduated=" + graduated
				+ ", formerSchool=" + formerSchool + ", schoolNumber=" + schoolNumber + ", leftBehindChildren="
				+ leftBehindChildren + ", workToCity=" + workToCity + ", orphan=" + orphan + ", disabilityType="
				+ disabilityType + ", userId=" + userId + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", idNumber=" + idNumber + "]";
	}

	public UserExtendedInfo() {
	
	}

	public UserExtendedInfo(String homeplace, String nativePlace, Integer nation, Boolean noMainland, Integer country,
			Integer idType, Integer healthCondition, Boolean oneChild, Boolean graduated, String formerSchool,
			String schoolNumber, Boolean leftBehindChildren, Boolean workToCity, Boolean orphan, Integer disabilityType,
			Integer userId, Long createTime, String idNumber) {
		this.homeplace = homeplace;
		this.nativePlace = nativePlace;
		this.nation = nation;
		this.noMainland = noMainland;
		this.country = country;
		this.idType = idType;
		this.healthCondition = healthCondition;
		this.oneChild = oneChild;
		this.graduated = graduated;
		this.formerSchool = formerSchool;
		this.schoolNumber = schoolNumber;
		this.leftBehindChildren = leftBehindChildren;
		this.workToCity = workToCity;
		this.orphan = orphan;
		this.disabilityType = disabilityType;
		this.userId = userId;
		this.createTime = createTime;
		this.idNumber = idNumber;
	}

	public UserExtendedInfo(String homeplace, String nativePlace, Integer nation, Boolean noMainland, Integer country,
			Integer idType, Integer healthCondition, Boolean oneChild, Boolean graduated, String formerSchool,
			String schoolNumber, Boolean leftBehindChildren, Boolean workToCity, Boolean orphan, Integer disabilityType,
			Integer userId, String idNumber) {
	
		this.homeplace = homeplace;
		this.nativePlace = nativePlace;
		this.nation = nation;
		this.noMainland = noMainland;
		this.country = country;
		this.idType = idType;
		this.healthCondition = healthCondition;
		this.oneChild = oneChild;
		this.graduated = graduated;
		this.formerSchool = formerSchool;
		this.schoolNumber = schoolNumber;
		this.leftBehindChildren = leftBehindChildren;
		this.workToCity = workToCity;
		this.orphan = orphan;
		this.disabilityType = disabilityType;
		this.userId = userId;
		this.idNumber = idNumber;
	}
    
    
}