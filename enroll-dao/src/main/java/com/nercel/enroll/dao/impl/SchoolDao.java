package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.SchoolMapper;
import com.nercel.enroll.domain.model.beans.School;
import com.nercel.enroll.domain.model.constants.TSchool;
import com.nercel.enroll.domain.mybatis.Criteria;
import com.nercel.enroll.domain.mybatis.Criteria.Condition;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: SchoolDao
 * @Description: school表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class SchoolDao {
	/**
	 * @Fields LOGGER : 日志操作类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolDao.class);

	/**
	 * @Fields School表的Mybatis Mapper操作映射类
	 */
	@Resource
	private SchoolMapper schoolMapper;

	/**
	 * @Title SchoolDao.countByExample
	 * @Description: 根据查询条件，计算school个数
	 * @param example
	 *            通用查询条件类
	 * @return int 结果个数
	 */
	private int countByExample(Criteria example) {
		int count = this.schoolMapper.countByExample(example);
		LOGGER.debug("count: {}", count);
		return count;
	}

	/**
	 * @Title SchoolDao.selectByPrimaryKey
	 * @Description: 根据主键类，返回school
	 * @param id
	 *            id
	 * @return School bean对象
	 */
	private School selectByPrimaryKey(Integer id) {
		return this.schoolMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Title SchoolDao.selectByExample
	 * @Description: 根据查询条件类，返回school结果集
	 * @param example
	 *            通用查询条件类
	 * @return List<School>school结果集
	 */
	private List<School> selectByExample(Criteria example) {
		return this.schoolMapper.selectByExample(example);
	}

	/**
	 * @Title SchoolDao.deleteByPrimaryKey
	 * @Description: 根据属性名称，删除school
	 * @param id
	 *            id
	 * @return int 删除个数
	 */
	private int deleteByPrimaryKey(Integer id) {
		return this.schoolMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title SchoolDao.updateByPrimaryKeySelective
	 * @Description: 根据主键更新school部分字段
	 * @param record
	 *            要更新成为的School对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKeySelective(School record) {
		return this.schoolMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title SchoolDao.updateByPrimaryKey
	 * @Description: 根据主键更新school全部字段
	 * @param record
	 *            要更新成为的School对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKey(School record) {
		return this.schoolMapper.updateByPrimaryKey(record);
	}

	/**
	 * @Title SchoolDao.deleteByExample
	 * @Description: 根据查询条件，删除school
	 * @param example
	 *            通用查询条件类
	 * @return int 删除个数
	 */
	private int deleteByExample(Criteria example) {
		return this.schoolMapper.deleteByExample(example);
	}

	/**
	 * @Title SchoolDao.updateByExampleSelective
	 * @Description: 根据查询条件更新school部分字段
	 * @param record
	 *            要更新成为的School对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExampleSelective(School record, Criteria example) {
		return this.schoolMapper.updateByExampleSelective(record, example);
	}

	/**
	 * @Title SchoolDao.updateByExample
	 * @Description: 根据查询条件更新school全表字段
	 * @param record
	 *            要更新成为的School对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExample(School record, Criteria example) {
		return this.schoolMapper.updateByExample(record, example);
	}

	/**
	 * @Title SchoolDao.insert
	 * @Description: 插入一个school
	 * @param record
	 *            school的bean对象
	 * @return int 插入个数
	 */
	private int insert(School record) {
		return this.schoolMapper.insert(record);
	}

	/**
	 * @Title SchoolDao.insertSelective
	 * @Description: 插入一个只有部分字段的school
	 * @param record
	 *            只含部分字段的school的bean对象
	 * @return int 插入个数
	 */
	private int insertSelective(School record) {
		return this.schoolMapper.insertSelective(record);
	}

	/**
	 * 查询出所有的学校
	 * 
	 * @return
	 */
	public List<School> queryAllSchool() {
		return this.selectByExample(null);
	}

	/**
	 * 根据id查询出学校
	 * 
	 * @param id
	 *            学校id
	 * @return
	 */
	public School querySchoolById(Integer id) {
		return this.selectByPrimaryKey(id);
	}
    
    /**
     * 根据学校类型查询学校
     * @param schoolType
     * @return
     */
    public List<School> querySchoolByType(Integer schoolType) {
        Criteria example = new Criteria();
        Condition condition = example.createConditon();
        condition.andEqualTo(TSchool.SCHOOL_TYPE, schoolType);
        return this.selectByExample(example);
    }
    /**
     * 根据学校的名字查询出学校的信息
     * @param name 学校的名字
     * @return
     */
    public List<School> querySchoolByName(String name){
        Criteria example = new Criteria();
        Condition condition = example.createConditon();
        condition.andEqualTo(TSchool.NAME, name);
        return this.selectByExample(example);
    
    }
}