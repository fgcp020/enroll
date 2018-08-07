package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.Relational;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: RelationalMapper
* @Description: relational表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface RelationalMapper {
    /**
    * @Title RelationalMapper.countByExample
    * @Description: 根据查询条件，计算relational个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title RelationalMapper.deleteByExample
    * @Description: 根据查询条件，删除relational
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title RelationalMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除relational
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title RelationalMapper.insert
    * @Description: 插入一个relational
    * @param record relational的bean对象
    * @return int  插入个数
     */
    int insert(Relational record);

    /**
    * @Title RelationalMapper.insertSelective
    * @Description: 插入一个只有部分字段的relational
    * @param record 只含部分字段的relational的bean对象
    * @return int  插入个数
     */
    int insertSelective(Relational record);

    /**
    * @Title RelationalMapper.selectByExample
    * @Description: 根据查询条件类，返回relational结果集
    * @param example 通用查询条件类
    * @return List<Relational>relational结果集
     */
    List<Relational> selectByExample(Criteria example);

    /**
    * @Title RelationalMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回relational
    * @param id id
    * @return Relational bean对象
     */
    Relational selectByPrimaryKey(Integer id);

    /**
    * @Title RelationalMapper.updateByExampleSelective
    * @Description: 根据查询条件更新relational部分字段
    * @param record 要更新成为的Relational对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") Relational record, @Param("example") Criteria criteria);

    /**
    * @Title RelationalMapper.updateByExample
    * @Description: 根据查询条件更新relational全表字段
    * @param record 要更新成为的Relational对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") Relational record, @Param("example") Criteria criteria);

    /**
    * @Title RelationalMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新relational部分字段
    * @param record 要更新成为的Relational对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(Relational record);

    /**
    * @Title RelationalMapper.updateByPrimaryKey
    * @Description: 根据主键更新relational全部字段
    * @param record 要更新成为的Relational对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(Relational record);
}