package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: UserGuardianInfo
* @Description: user_guardian_info表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class UserGuardianInfo extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields user_guardian_info.Id :
     */
    private Integer id;

    /**
     * @Fields user_guardian_info.name :姓名
     */
    private String name;

    /**
     * @Fields user_guardian_info.user_relationship :用户关系
     */
    private Integer userRelationship;

    /**
     * @Fields user_guardian_info.work_unit :工作单位
     */
    private String workUnit;

    /**
     * @Fields user_guardian_info.account_address :监护人户口地址
     */
    private String accountAddress;

    /**
     * @Fields user_guardian_info.phone :联系电话
     */
    private String phone;

    /**
     * @Fields user_guardian_info.guarder :是否为监护人
     */
    private Boolean guarder;

    /**
     * @Fields user_guardian_info.id_type :证件类型
     */
    private Integer idType;

    /**
     * @Fields user_guardian_info.id_number :监护人证件号
     */
    private String idNumber;

    /**
     * @Fields user_guardian_info.duties :职务
     */
    private String duties;

    /**
     * @Fields user_guardian_info.education :监护顺序
     */
    private String education;

    /**
     * @Fields user_guardian_info.monit_order :监护人顺序
     */
    private Integer monitOrder;

    /**
     * @Fields user_guardian_info.user_id :所属的用户
     */
    private Integer userId;

    /**
     * @Fields user_guardian_info.create_time :创建时间
     */
    private Long createTime;

    /**
     * @Fields user_guardian_info.update_time :更新时间
     */
    private Long updateTime;

    /**
     * @return user_guardian_info.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of user_guardian_info : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_guardian_info.name : 返回 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * @param name of user_guardian_info : 设置 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return user_guardian_info.user_relationship : 返回 用户关系
     */
    public Integer getUserRelationship() {
        return userRelationship;
    }

    /**
     * @param userRelationship of user_guardian_info : 设置 用户关系
     */
    public void setUserRelationship(Integer userRelationship) {
        this.userRelationship = userRelationship;
    }

    /**
     * @return user_guardian_info.work_unit : 返回 工作单位
     */
    public String getWorkUnit() {
        return workUnit;
    }

    /**
     * @param workUnit of user_guardian_info : 设置 工作单位
     */
    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    /**
     * @return user_guardian_info.account_address : 返回 监护人户口地址
     */
    public String getAccountAddress() {
        return accountAddress;
    }

    /**
     * @param accountAddress of user_guardian_info : 设置 监护人户口地址
     */
    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    /**
     * @return user_guardian_info.phone : 返回 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone of user_guardian_info : 设置 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return user_guardian_info.guarder : 返回 是否为监护人
     */
    public Boolean getGuarder() {
        return guarder;
    }

    /**
     * @param guarder of user_guardian_info : 设置 是否为监护人
     */
    public void setGuarder(Boolean guarder) {
        this.guarder = guarder;
    }

    /**
     * @return user_guardian_info.id_type : 返回 证件类型
     */
    public Integer getIdType() {
        return idType;
    }

    /**
     * @param idType of user_guardian_info : 设置 证件类型
     */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    /**
     * @return user_guardian_info.id_number : 返回 监护人证件号
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber of user_guardian_info : 设置 监护人证件号
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return user_guardian_info.duties : 返回 职务
     */
    public String getDuties() {
        return duties;
    }

    /**
     * @param duties of user_guardian_info : 设置 职务
     */
    public void setDuties(String duties) {
        this.duties = duties;
    }

    /**
     * @return user_guardian_info.education : 返回 监护顺序
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education of user_guardian_info : 设置 监护顺序
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * @return user_guardian_info.monit_order : 返回 监护人顺序
     */
    public Integer getMonitOrder() {
        return monitOrder;
    }

    /**
     * @param monitOrder of user_guardian_info : 设置 监护人顺序
     */
    public void setMonitOrder(Integer monitOrder) {
        this.monitOrder = monitOrder;
    }

    /**
     * @return user_guardian_info.user_id : 返回 所属的用户
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId of user_guardian_info : 设置 所属的用户
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_guardian_info.create_time : 返回 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime of user_guardian_info : 设置 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * @return user_guardian_info.update_time : 返回 更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime of user_guardian_info : 设置 更新时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

	public UserGuardianInfo(Integer id, String name, Integer userRelationship, String workUnit, String accountAddress,
			String phone, Boolean guarder, Integer idType, String idNumber, String duties, String education,
			Integer monitOrder, Integer userId, Long createTime, Long updateTime) {
		this.id = id;
		this.name = name;
		this.userRelationship = userRelationship;
		this.workUnit = workUnit;
		this.accountAddress = accountAddress;
		this.phone = phone;
		this.guarder = guarder;
		this.idType = idType;
		this.idNumber = idNumber;
		this.duties = duties;
		this.education = education;
		this.monitOrder = monitOrder;
		this.userId = userId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public UserGuardianInfo(String name, Integer userRelationship, String workUnit, String accountAddress, String phone,
			Boolean guarder, Integer idType, String idNumber, String duties, String education, Integer monitOrder) {
		this.name = name;
		this.userRelationship = userRelationship;
		this.workUnit = workUnit;
		this.accountAddress = accountAddress;
		this.phone = phone;
		this.guarder = guarder;
		this.idType = idType;
		this.idNumber = idNumber;
		this.duties = duties;
		this.education = education;
		this.monitOrder = monitOrder;
	}

	public UserGuardianInfo() {
	
	}

	@Override
	public String toString() {
		return "UserGuardianInfo [id=" + id + ", name=" + name + ", userRelationship=" + userRelationship
				+ ", workUnit=" + workUnit + ", accountAddress=" + accountAddress + ", phone=" + phone + ", guarder="
				+ guarder + ", idType=" + idType + ", idNumber=" + idNumber + ", duties=" + duties + ", education="
				+ education + ", monitOrder=" + monitOrder + ", userId=" + userId + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}
    
    
    
    
}