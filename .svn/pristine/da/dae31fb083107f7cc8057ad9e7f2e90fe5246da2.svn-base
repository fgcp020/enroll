package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.StreetSchool;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: StreetSchoolMapper
* @Description: street_school表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface StreetSchoolMapper {
    /**
    * @Title StreetSchoolMapper.countByExample
    * @Description: 根据查询条件，计算street_school个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title StreetSchoolMapper.deleteByExample
    * @Description: 根据查询条件，删除street_school
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title StreetSchoolMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除street_school
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title StreetSchoolMapper.insert
    * @Description: 插入一个street_school
    * @param record street_school的bean对象
    * @return int  插入个数
     */
    int insert(StreetSchool record);

    /**
    * @Title StreetSchoolMapper.insertSelective
    * @Description: 插入一个只有部分字段的street_school
    * @param record 只含部分字段的street_school的bean对象
    * @return int  插入个数
     */
    int insertSelective(StreetSchool record);

    /**
    * @Title StreetSchoolMapper.selectByExample
    * @Description: 根据查询条件类，返回street_school结果集
    * @param example 通用查询条件类
    * @return List<StreetSchool>street_school结果集
     */
    List<StreetSchool> selectByExample(Criteria example);

    /**
    * @Title StreetSchoolMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回street_school
    * @param id id
    * @return StreetSchool bean对象
     */
    StreetSchool selectByPrimaryKey(Integer id);

    /**
    * @Title StreetSchoolMapper.updateByExampleSelective
    * @Description: 根据查询条件更新street_school部分字段
    * @param record 要更新成为的StreetSchool对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") StreetSchool record, @Param("example") Criteria criteria);

    /**
    * @Title StreetSchoolMapper.updateByExample
    * @Description: 根据查询条件更新street_school全表字段
    * @param record 要更新成为的StreetSchool对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") StreetSchool record, @Param("example") Criteria criteria);

    /**
    * @Title StreetSchoolMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新street_school部分字段
    * @param record 要更新成为的StreetSchool对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(StreetSchool record);

    /**
    * @Title StreetSchoolMapper.updateByPrimaryKey
    * @Description: 根据主键更新street_school全部字段
    * @param record 要更新成为的StreetSchool对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(StreetSchool record);
}