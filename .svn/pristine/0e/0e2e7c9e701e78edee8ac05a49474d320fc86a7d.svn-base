package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.SmsCode;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: SmsCodeMapper
* @Description: sms_code表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface SmsCodeMapper {
    /**
    * @Title SmsCodeMapper.countByExample
    * @Description: 根据查询条件，计算sms_code个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title SmsCodeMapper.deleteByExample
    * @Description: 根据查询条件，删除sms_code
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title SmsCodeMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除sms_code
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title SmsCodeMapper.insert
    * @Description: 插入一个sms_code
    * @param record sms_code的bean对象
    * @return int  插入个数
     */
    int insert(SmsCode record);

    /**
    * @Title SmsCodeMapper.insertSelective
    * @Description: 插入一个只有部分字段的sms_code
    * @param record 只含部分字段的sms_code的bean对象
    * @return int  插入个数
     */
    int insertSelective(SmsCode record);

    /**
    * @Title SmsCodeMapper.selectByExample
    * @Description: 根据查询条件类，返回sms_code结果集
    * @param example 通用查询条件类
    * @return List<SmsCode>sms_code结果集
     */
    List<SmsCode> selectByExample(Criteria example);

    /**
    * @Title SmsCodeMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回sms_code
    * @param id id
    * @return SmsCode bean对象
     */
    SmsCode selectByPrimaryKey(Integer id);

    /**
    * @Title SmsCodeMapper.updateByExampleSelective
    * @Description: 根据查询条件更新sms_code部分字段
    * @param record 要更新成为的SmsCode对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") SmsCode record, @Param("example") Criteria criteria);

    /**
    * @Title SmsCodeMapper.updateByExample
    * @Description: 根据查询条件更新sms_code全表字段
    * @param record 要更新成为的SmsCode对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") SmsCode record, @Param("example") Criteria criteria);

    /**
    * @Title SmsCodeMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新sms_code部分字段
    * @param record 要更新成为的SmsCode对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(SmsCode record);

    /**
    * @Title SmsCodeMapper.updateByPrimaryKey
    * @Description: 根据主键更新sms_code全部字段
    * @param record 要更新成为的SmsCode对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(SmsCode record);
}