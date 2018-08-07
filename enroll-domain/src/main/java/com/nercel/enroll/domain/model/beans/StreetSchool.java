package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: StreetSchool
* @Description: street_school表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class StreetSchool extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields street_school.Id :
     */
    private Integer id;

    /**
     * @Fields street_school.street :街道的名字
     */
    private String street;

    /**
     * @Fields street_school.school_id :学校的id
     */
    private Integer schoolId;

    /**
     * @Fields street_school.school_name :学校名称
     */
    private String schoolName;

    /**
     * @Fields street_school.school_type :学校类型(冗余字段，1小学、2中学)
     */
    private Integer schoolType;

    /**
     * @return street_school.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of street_school : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return street_school.street : 返回 街道的名字
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street of street_school : 设置 街道的名字
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return street_school.school_id : 返回 学校的id
     */
    public Integer getSchoolId() {
        return schoolId;
    }

    /**
     * @param schoolId of street_school : 设置 学校的id
     */
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * @return street_school.school_name : 返回 学校名称
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * @param schoolName of street_school : 设置 学校名称
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    /**
     * @return street_school.school_type : 返回 学校类型(冗余字段，1小学、2中学)
     */
    public Integer getSchoolType() {
        return schoolType;
    }

    /**
     * @param schoolType of street_school : 设置 学校类型(冗余字段，1小学、2中学)
     */
    public void setSchoolType(Integer schoolType) {
        this.schoolType = schoolType;
    }

	@Override
	public String toString() {
		return "StreetSchool [id=" + id + ", street=" + street + ", schoolId=" + schoolId + ", schoolName=" + schoolName
				+ ", schoolType=" + schoolType + "]";
	}
    
    
}