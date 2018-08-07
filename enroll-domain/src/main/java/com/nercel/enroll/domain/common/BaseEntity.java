package com.nercel.enroll.domain.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 通用父级接口
 * @author yishui
 * @date 2018年7月2日
 * @version 0.0.1
 */
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * @Fields id :ID
	 */
	@JsonIgnore
	private transient Integer id;
	/**
	 * 扩展的属性
	 */
	@JsonIgnore
	private String extendProperty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExtendProperty() {
		return extendProperty;
	}

	public void setExtendProperty(String extendProperty) {
		this.extendProperty = extendProperty;
	}
}