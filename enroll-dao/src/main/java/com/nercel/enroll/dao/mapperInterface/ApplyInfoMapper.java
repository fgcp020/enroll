package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.ApplyInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: ApplyInfoMapper
* @Description: apply_info表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface ApplyInfoMapper {
    /**
    * @Title ApplyInfoMapper.countByExample
    * @Description: 根据查询条件，计算apply_info个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title ApplyInfoMapper.deleteByExample
    * @Description: 根据查询条件，删除apply_info
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title ApplyInfoMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除apply_info
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title ApplyInfoMapper.insert
    * @Description: 插入一个apply_info
    * @param record apply_info的bean对象
    * @return int  插入个数
     */
    int insert(ApplyInfo record);

    /**
    * @Title ApplyInfoMapper.insertSelective
    * @Description: 插入一个只有部分字段的apply_info
    * @param record 只含部分字段的apply_info的bean对象
    * @return int  插入个数
     */
    int insertSelective(ApplyInfo record);

    /**
    * @Title ApplyInfoMapper.selectByExample
    * @Description: 根据查询条件类，返回apply_info结果集
    * @param example 通用查询条件类
    * @return List<ApplyInfo>apply_info结果集
     */
    List<ApplyInfo> selectByExample(Criteria example);

    /**
    * @Title ApplyInfoMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回apply_info
    * @param id id
    * @return ApplyInfo bean对象
     */
    ApplyInfo selectByPrimaryKey(Integer id);

    /**
    * @Title ApplyInfoMapper.updateByExampleSelective
    * @Description: 根据查询条件更新apply_info部分字段
    * @param record 要更新成为的ApplyInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") ApplyInfo record, @Param("example") Criteria criteria);

    /**
    * @Title ApplyInfoMapper.updateByExample
    * @Description: 根据查询条件更新apply_info全表字段
    * @param record 要更新成为的ApplyInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") ApplyInfo record, @Param("example") Criteria criteria);

    /**
    * @Title ApplyInfoMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新apply_info部分字段
    * @param record 要更新成为的ApplyInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(ApplyInfo record);

    /**
    * @Title ApplyInfoMapper.updateByPrimaryKey
    * @Description: 根据主键更新apply_info全部字段
    * @param record 要更新成为的ApplyInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(ApplyInfo record);
}