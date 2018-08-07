package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.SchoolRelationship;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: SchoolRelationshipMapper
* @Description: school_relationship表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface SchoolRelationshipMapper {
    /**
    * @Title SchoolRelationshipMapper.countByExample
    * @Description: 根据查询条件，计算school_relationship个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title SchoolRelationshipMapper.deleteByExample
    * @Description: 根据查询条件，删除school_relationship
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title SchoolRelationshipMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除school_relationship
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title SchoolRelationshipMapper.insert
    * @Description: 插入一个school_relationship
    * @param record school_relationship的bean对象
    * @return int  插入个数
     */
    int insert(SchoolRelationship record);

    /**
    * @Title SchoolRelationshipMapper.insertSelective
    * @Description: 插入一个只有部分字段的school_relationship
    * @param record 只含部分字段的school_relationship的bean对象
    * @return int  插入个数
     */
    int insertSelective(SchoolRelationship record);

    /**
    * @Title SchoolRelationshipMapper.selectByExample
    * @Description: 根据查询条件类，返回school_relationship结果集
    * @param example 通用查询条件类
    * @return List<SchoolRelationship>school_relationship结果集
     */
    List<SchoolRelationship> selectByExample(Criteria example);

    /**
    * @Title SchoolRelationshipMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回school_relationship
    * @param id id
    * @return SchoolRelationship bean对象
     */
    SchoolRelationship selectByPrimaryKey(Integer id);

    /**
    * @Title SchoolRelationshipMapper.updateByExampleSelective
    * @Description: 根据查询条件更新school_relationship部分字段
    * @param record 要更新成为的SchoolRelationship对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") SchoolRelationship record, @Param("example") Criteria criteria);

    /**
    * @Title SchoolRelationshipMapper.updateByExample
    * @Description: 根据查询条件更新school_relationship全表字段
    * @param record 要更新成为的SchoolRelationship对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") SchoolRelationship record, @Param("example") Criteria criteria);

    /**
    * @Title SchoolRelationshipMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新school_relationship部分字段
    * @param record 要更新成为的SchoolRelationship对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(SchoolRelationship record);

    /**
    * @Title SchoolRelationshipMapper.updateByPrimaryKey
    * @Description: 根据主键更新school_relationship全部字段
    * @param record 要更新成为的SchoolRelationship对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(SchoolRelationship record);
}