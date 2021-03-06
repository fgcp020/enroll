package com.nercel.enroll.core.service;

import java.util.List;

import com.nercel.enroll.domain.model.beans.CertificatesType;
import com.nercel.enroll.domain.model.beans.Country;
import com.nercel.enroll.domain.model.beans.Nation;
import com.nercel.enroll.domain.model.beans.Relational;
import com.nercel.enroll.domain.model.beans.School;
import com.nercel.enroll.domain.model.beans.StreetSchool;
import com.nercel.enroll.domain.model.beans.StudentInfo;

/**
 * 基础数据获取接口
 * 
 * @author yishui
 * @date 2018年6月13日
 * @version 0.0.1
 */
public interface BasicDataService {
	/**
	 * 查询出所有的民族信息
	 * 
	 * @return
	 */
	public List<Nation> queryAllNation();

	/**
	 * 查询出所有的国家信息
	 * 
	 * @return
	 */
	public List<Country> queryAllCountry();

	/**
	 * 查询出所有的证件类型信息
	 * 
	 * @return
	 */
	public List<CertificatesType> queryAllCertificatesType();

	/**
	 * 查询出所有的与学生的关系
	 * 
	 * @return
	 */
	public List<Relational> queryAllRelational();

	/**
	 * 查询出所有的学校
	 * 
	 * @return
	 */
	public List<School> queryAllSchool();

	/**
	 * 查询出学校招收的街道
	 * 
	 * @return
	 */
	public List<StreetSchool> queryAllStreetSchool();

	/**
	 * 查询出2018年小学毕业生学籍信息
	 * 
	 * @return
	 */
	public List<StudentInfo> queryAllStudentInfo();

	/**
	 * 根据id查询出2018年小学毕业生学籍信息
	 * 
	 * @return
	 */
	public List<StudentInfo> queryStudentInfo(String studentNumber);

	/**
	 * 根据学校类型查询学校
	 * 
	 * @return
	 */
	public List<School> querySchoolByType(Integer schoolType);

	
}
