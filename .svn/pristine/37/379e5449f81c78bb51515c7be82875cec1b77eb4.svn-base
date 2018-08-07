package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.PlanTime;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
 
/**
 * @ClassName: PlanTimeMapper
* @Description: plan_time表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface PlanTimeMapper {
    /**
    * @Title PlanTimeMapper.countByExample
    * @Description: 根据查询条件，计算plan_time个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title PlanTimeMapper.deleteByExample
    * @Description: 根据查询条件，删除plan_time
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title PlanTimeMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除plan_time
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title PlanTimeMapper.insert
    * @Description: 插入一个plan_time
    * @param record plan_time的bean对象
    * @return int  插入个数
     */
    int insert(PlanTime record);

    /**
    * @Title PlanTimeMapper.insertSelective
    * @Description: 插入一个只有部分字段的plan_time
    * @param record 只含部分字段的plan_time的bean对象
    * @return int  插入个数
     */
    int insertSelective(PlanTime record);

    /**
    * @Title PlanTimeMapper.selectByExample
    * @Description: 根据查询条件类，返回plan_time结果集
    * @param example 通用查询条件类
    * @return List<PlanTime>plan_time结果集
     */
    List<PlanTime> selectByExample(Criteria example);

    /**
    * @Title PlanTimeMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回plan_time
    * @param id id
    * @return PlanTime bean对象
     */
    PlanTime selectByPrimaryKey(Integer id);

    /**
    * @Title PlanTimeMapper.updateByExampleSelective
    * @Description: 根据查询条件更新plan_time部分字段
    * @param record 要更新成为的PlanTime对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") PlanTime record, @Param("example") Criteria criteria);

    /**
    * @Title PlanTimeMapper.updateByExample
    * @Description: 根据查询条件更新plan_time全表字段
    * @param record 要更新成为的PlanTime对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") PlanTime record, @Param("example") Criteria criteria);

    /**
    * @Title PlanTimeMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新plan_time部分字段
    * @param record 要更新成为的PlanTime对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(PlanTime record);

    /**
    * @Title PlanTimeMapper.updateByPrimaryKey
    * @Description: 根据主键更新plan_time全部字段
    * @param record 要更新成为的PlanTime对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(PlanTime record);
}