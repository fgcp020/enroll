package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.Nation;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: NationMapper
* @Description: nation表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface NationMapper {
    /**
    * @Title NationMapper.countByExample
    * @Description: 根据查询条件，计算nation个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title NationMapper.deleteByExample
    * @Description: 根据查询条件，删除nation
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title NationMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除nation
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title NationMapper.insert
    * @Description: 插入一个nation
    * @param record nation的bean对象
    * @return int  插入个数
     */
    int insert(Nation record);

    /**
    * @Title NationMapper.insertSelective
    * @Description: 插入一个只有部分字段的nation
    * @param record 只含部分字段的nation的bean对象
    * @return int  插入个数
     */
    int insertSelective(Nation record);

    /**
    * @Title NationMapper.selectByExample
    * @Description: 根据查询条件类，返回nation结果集
    * @param example 通用查询条件类
    * @return List<Nation>nation结果集
     */
    List<Nation> selectByExample(Criteria example);

    /**
    * @Title NationMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回nation
    * @param id id
    * @return Nation bean对象
     */
    Nation selectByPrimaryKey(Integer id);

    /**
    * @Title NationMapper.updateByExampleSelective
    * @Description: 根据查询条件更新nation部分字段
    * @param record 要更新成为的Nation对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") Nation record, @Param("example") Criteria criteria);

    /**
    * @Title NationMapper.updateByExample
    * @Description: 根据查询条件更新nation全表字段
    * @param record 要更新成为的Nation对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") Nation record, @Param("example") Criteria criteria);

    /**
    * @Title NationMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新nation部分字段
    * @param record 要更新成为的Nation对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(Nation record);

    /**
    * @Title NationMapper.updateByPrimaryKey
    * @Description: 根据主键更新nation全部字段
    * @param record 要更新成为的Nation对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(Nation record);
    
  
}