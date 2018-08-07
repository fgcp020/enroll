package com.nercel.enroll.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.nercel.enroll.dao.mapperInterface.StreetSchoolMapper;
import com.nercel.enroll.domain.model.beans.StreetSchool;
import com.nercel.enroll.domain.model.constants.TStreetSchool;
import com.nercel.enroll.domain.mybatis.Criteria;
import com.nercel.enroll.domain.mybatis.Criteria.Condition;

/**
 * @ClassName: StreetSchoolDao
 * @Description: street_school表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class StreetSchoolDao {
	/**
	 * @Fields LOGGER : 日志操作类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(StreetSchoolDao.class);

	/**
	 * @Fields StreetSchool表的Mybatis Mapper操作映射类
	 */
	@Resource
	private StreetSchoolMapper streetSchoolMapper;

	/**
	 * @Title StreetSchoolDao.countByExample
	 * @Description: 根据查询条件，计算street_school个数
	 * @param example
	 *            通用查询条件类
	 * @return int 结果个数
	 */
	private int countByExample(Criteria example) {
		int count = this.streetSchoolMapper.countByExample(example);
		LOGGER.debug("count: {}", count);
		return count;
	}

	/**
	 * @Title StreetSchoolDao.selectByPrimaryKey
	 * @Description: 根据主键类，返回street_school
	 * @param id
	 *            id
	 * @return StreetSchool bean对象
	 */
	private StreetSchool selectByPrimaryKey(Integer id) {
		return this.streetSchoolMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Title StreetSchoolDao.selectByExample
	 * @Description: 根据查询条件类，返回street_school结果集
	 * @param example
	 *            通用查询条件类
	 * @return List<StreetSchool>street_school结果集
	 */
	private List<StreetSchool> selectByExample(Criteria example) {
		return this.streetSchoolMapper.selectByExample(example);
	}

	/**
	 * @Title StreetSchoolDao.deleteByPrimaryKey
	 * @Description: 根据属性名称，删除street_school
	 * @param id
	 *            id
	 * @return int 删除个数
	 */
	private int deleteByPrimaryKey(Integer id) {
		return this.streetSchoolMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title StreetSchoolDao.updateByPrimaryKeySelective
	 * @Description: 根据主键更新street_school部分字段
	 * @param record
	 *            要更新成为的StreetSchool对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKeySelective(StreetSchool record) {
		return this.streetSchoolMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title StreetSchoolDao.updateByPrimaryKey
	 * @Description: 根据主键更新street_school全部字段
	 * @param record
	 *            要更新成为的StreetSchool对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKey(StreetSchool record) {
		return this.streetSchoolMapper.updateByPrimaryKey(record);
	}

	/**
	 * @Title StreetSchoolDao.deleteByExample
	 * @Description: 根据查询条件，删除street_school
	 * @param example
	 *            通用查询条件类
	 * @return int 删除个数
	 */
	private int deleteByExample(Criteria example) {
		return this.streetSchoolMapper.deleteByExample(example);
	}

	/**
	 * @Title StreetSchoolDao.updateByExampleSelective
	 * @Description: 根据查询条件更新street_school部分字段
	 * @param record
	 *            要更新成为的StreetSchool对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExampleSelective(StreetSchool record, Criteria example) {
		return this.streetSchoolMapper.updateByExampleSelective(record, example);
	}

	/**
	 * @Title StreetSchoolDao.updateByExample
	 * @Description: 根据查询条件更新street_school全表字段
	 * @param record
	 *            要更新成为的StreetSchool对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExample(StreetSchool record, Criteria example) {
		return this.streetSchoolMapper.updateByExample(record, example);
	}

	/**
	 * @Title StreetSchoolDao.insert
	 * @Description: 插入一个street_school
	 * @param record
	 *            street_school的bean对象
	 * @return int 插入个数
	 */
	private int insert(StreetSchool record) {
		return this.streetSchoolMapper.insert(record);
	}

	/**
	 * @Title StreetSchoolDao.insertSelective
	 * @Description: 插入一个只有部分字段的street_school
	 * @param record
	 *            只含部分字段的street_school的bean对象
	 * @return int 插入个数
	 */
	private int insertSelective(StreetSchool record) {
		return this.streetSchoolMapper.insertSelective(record);
	}

	/**
	 * 查询出学校招收的街道
	 * 
	 * @return
	 */
	public List<StreetSchool> queryAllStreetSchool() {
		return this.selectByExample(null);
	}

	/**
	 * 根据地址模糊查询出匹配的学校
	 * 
	 * @param street
	 *            地址
	 * @return
	 */
	public List<StreetSchool> queryStreetSchoolByStreet(String street) {

		Criteria example = new Criteria();
		Condition condition = example.createConditon();
		condition.andLike(TStreetSchool.STREET, street);
		return this.selectByExample(example);
	}

	/**
	 * 根据地址和学生类型查询出匹配的学校
	 * 
	 * @param street
	 *            地址信息
	 * @param type
	 *            学生类型1小学，2中学
	 * @return
	 */
	public List<StreetSchool> queryStreetSchoolByStreetAndType(String street, Integer type) {
		Criteria example = new Criteria();
		Condition condition = example.createConditon();
		condition.andEqualTo(TStreetSchool.SCHOOL_TYPE, type).andLike(TStreetSchool.STREET, street);
		return this.selectByExample(example);
	}
}