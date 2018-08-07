package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.School;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: SchoolMapper
* @Description: school表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface SchoolMapper {
    /**
    * @Title SchoolMapper.countByExample
    * @Description: 根据查询条件，计算school个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title SchoolMapper.deleteByExample
    * @Description: 根据查询条件，删除school
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title SchoolMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除school
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title SchoolMapper.insert
    * @Description: 插入一个school
    * @param record school的bean对象
    * @return int  插入个数
     */
    int insert(School record);

    /**
    * @Title SchoolMapper.insertSelective
    * @Description: 插入一个只有部分字段的school
    * @param record 只含部分字段的school的bean对象
    * @return int  插入个数
     */
    int insertSelective(School record);

    /**
    * @Title SchoolMapper.selectByExample
    * @Description: 根据查询条件类，返回school结果集
    * @param example 通用查询条件类
    * @return List<School>school结果集
     */
    List<School> selectByExample(Criteria example);

    /**
    * @Title SchoolMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回school
    * @param id id
    * @return School bean对象
     */
    School selectByPrimaryKey(Integer id);

    /**
    * @Title SchoolMapper.updateByExampleSelective
    * @Description: 根据查询条件更新school部分字段
    * @param record 要更新成为的School对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") School record, @Param("example") Criteria criteria);

    /**
    * @Title SchoolMapper.updateByExample
    * @Description: 根据查询条件更新school全表字段
    * @param record 要更新成为的School对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") School record, @Param("example") Criteria criteria);

    /**
    * @Title SchoolMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新school部分字段
    * @param record 要更新成为的School对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(School record);

    /**
    * @Title SchoolMapper.updateByPrimaryKey
    * @Description: 根据主键更新school全部字段
    * @param record 要更新成为的School对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(School record);
}