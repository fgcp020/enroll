package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.Country;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: CountryMapper
* @Description: country表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface CountryMapper {
    /**
    * @Title CountryMapper.countByExample
    * @Description: 根据查询条件，计算country个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title CountryMapper.deleteByExample
    * @Description: 根据查询条件，删除country
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title CountryMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除country
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title CountryMapper.insert
    * @Description: 插入一个country
    * @param record country的bean对象
    * @return int  插入个数
     */
    int insert(Country record);

    /**
    * @Title CountryMapper.insertSelective
    * @Description: 插入一个只有部分字段的country
    * @param record 只含部分字段的country的bean对象
    * @return int  插入个数
     */
    int insertSelective(Country record);

    /**
    * @Title CountryMapper.selectByExample
    * @Description: 根据查询条件类，返回country结果集
    * @param example 通用查询条件类
    * @return List<Country>country结果集
     */
    List<Country> selectByExample(Criteria example);

    /**
    * @Title CountryMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回country
    * @param id id
    * @return Country bean对象
     */
    Country selectByPrimaryKey(Integer id);

    /**
    * @Title CountryMapper.updateByExampleSelective
    * @Description: 根据查询条件更新country部分字段
    * @param record 要更新成为的Country对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") Country record, @Param("example") Criteria criteria);

    /**
    * @Title CountryMapper.updateByExample
    * @Description: 根据查询条件更新country全表字段
    * @param record 要更新成为的Country对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") Country record, @Param("example") Criteria criteria);

    /**
    * @Title CountryMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新country部分字段
    * @param record 要更新成为的Country对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(Country record);

    /**
    * @Title CountryMapper.updateByPrimaryKey
    * @Description: 根据主键更新country全部字段
    * @param record 要更新成为的Country对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(Country record);
}