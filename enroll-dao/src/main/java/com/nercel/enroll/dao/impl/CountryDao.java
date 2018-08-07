package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.CountryMapper;
import com.nercel.enroll.domain.model.beans.Country;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: CountryDao
* @Description: country表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class CountryDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryDao.class);

    /**
     * @Fields Country表的Mybatis Mapper操作映射类
     */
    @Resource
    private CountryMapper countryMapper;

    /**
    * @Title CountryDao.countByExample
    * @Description: 根据查询条件，计算country个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    private int countByExample(Criteria example) {
        int count = this.countryMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title CountryDao.selectByPrimaryKey
    * @Description: 根据主键类，返回country
    * @param id id
    * @return Country bean对象
     */
    private Country selectByPrimaryKey(Integer id) {
        return this.countryMapper.selectByPrimaryKey(id);
    }

    /**
    * @Title CountryDao.selectByExample
    * @Description: 根据查询条件类，返回country结果集
    * @param example 通用查询条件类
    * @return List<Country>country结果集
     */
    private List<Country> selectByExample(Criteria example) {
        return this.countryMapper.selectByExample(example);
    }

    /**
    * @Title CountryDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除country
    * @param id id
    * @return int  删除个数
     */
    private int deleteByPrimaryKey(Integer id) {
        return this.countryMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Title CountryDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新country部分字段
    * @param record 要更新成为的Country对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKeySelective(Country record) {
        return this.countryMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title CountryDao.updateByPrimaryKey
    * @Description: 根据主键更新country全部字段
    * @param record 要更新成为的Country对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKey(Country record) {
        return this.countryMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title CountryDao.deleteByExample
    * @Description: 根据查询条件，删除country
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    private int deleteByExample(Criteria example) {
        return this.countryMapper.deleteByExample(example);
    }

    /**
    * @Title CountryDao.updateByExampleSelective
    * @Description: 根据查询条件更新country部分字段
    * @param record 要更新成为的Country对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExampleSelective(Country record, Criteria example) {
        return this.countryMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title CountryDao.updateByExample
    * @Description: 根据查询条件更新country全表字段
    * @param record 要更新成为的Country对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExample(Country record, Criteria example) {
        return this.countryMapper.updateByExample(record, example);
    }

    /**
    * @Title CountryDao.insert
    * @Description: 插入一个country
    * @param record country的bean对象
    * @return int  插入个数
     */
    private int insert(Country record) {
        return this.countryMapper.insert(record);
    }

    /**
    * @Title CountryDao.insertSelective
    * @Description: 插入一个只有部分字段的country
    * @param record 只含部分字段的country的bean对象
    * @return int  插入个数
     */
    private int insertSelective(Country record) {
        return this.countryMapper.insertSelective(record);
    }
    
    /**
     * 查询出所有的国家信息
     * 
     * @return
     */
    public List<Country> queryAllCountry() {
        return this.selectByExample(null); 
    }
    
    public Country queryCountryById(Integer id){
    	return this.selectByPrimaryKey(id);
    }
}