package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.CertificatesType;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: CertificatesTypeMapper
* @Description: certificates_type表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface CertificatesTypeMapper {
    /**
    * @Title CertificatesTypeMapper.countByExample
    * @Description: 根据查询条件，计算certificates_type个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title CertificatesTypeMapper.deleteByExample
    * @Description: 根据查询条件，删除certificates_type
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title CertificatesTypeMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除certificates_type
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title CertificatesTypeMapper.insert
    * @Description: 插入一个certificates_type
    * @param record certificates_type的bean对象
    * @return int  插入个数
     */
    int insert(CertificatesType record);

    /**
    * @Title CertificatesTypeMapper.insertSelective
    * @Description: 插入一个只有部分字段的certificates_type
    * @param record 只含部分字段的certificates_type的bean对象
    * @return int  插入个数
     */
    int insertSelective(CertificatesType record);

    /**
    * @Title CertificatesTypeMapper.selectByExample
    * @Description: 根据查询条件类，返回certificates_type结果集
    * @param example 通用查询条件类
    * @return List<CertificatesType>certificates_type结果集
     */
    List<CertificatesType> selectByExample(Criteria example);

    /**
    * @Title CertificatesTypeMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回certificates_type
    * @param id id
    * @return CertificatesType bean对象
     */
    CertificatesType selectByPrimaryKey(Integer id);

    /**
    * @Title CertificatesTypeMapper.updateByExampleSelective
    * @Description: 根据查询条件更新certificates_type部分字段
    * @param record 要更新成为的CertificatesType对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") CertificatesType record, @Param("example") Criteria criteria);

    /**
    * @Title CertificatesTypeMapper.updateByExample
    * @Description: 根据查询条件更新certificates_type全表字段
    * @param record 要更新成为的CertificatesType对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") CertificatesType record, @Param("example") Criteria criteria);

    /**
    * @Title CertificatesTypeMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新certificates_type部分字段
    * @param record 要更新成为的CertificatesType对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(CertificatesType record);

    /**
    * @Title CertificatesTypeMapper.updateByPrimaryKey
    * @Description: 根据主键更新certificates_type全部字段
    * @param record 要更新成为的CertificatesType对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(CertificatesType record);
}