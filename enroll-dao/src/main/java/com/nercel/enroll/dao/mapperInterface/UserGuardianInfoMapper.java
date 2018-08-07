package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.UserGuardianInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserGuardianInfoMapper
* @Description: user_guardian_info表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface UserGuardianInfoMapper {
    /**
    * @Title UserGuardianInfoMapper.countByExample
    * @Description: 根据查询条件，计算user_guardian_info个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title UserGuardianInfoMapper.deleteByExample
    * @Description: 根据查询条件，删除user_guardian_info
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title UserGuardianInfoMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除user_guardian_info
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title UserGuardianInfoMapper.insert
    * @Description: 插入一个user_guardian_info
    * @param record user_guardian_info的bean对象
    * @return int  插入个数
     */
    int insert(UserGuardianInfo record);

    /**
    * @Title UserGuardianInfoMapper.insertSelective
    * @Description: 插入一个只有部分字段的user_guardian_info
    * @param record 只含部分字段的user_guardian_info的bean对象
    * @return int  插入个数
     */
    int insertSelective(UserGuardianInfo record);

    /**
    * @Title UserGuardianInfoMapper.selectByExample
    * @Description: 根据查询条件类，返回user_guardian_info结果集
    * @param example 通用查询条件类
    * @return List<UserGuardianInfo>user_guardian_info结果集
     */
    List<UserGuardianInfo> selectByExample(Criteria example);

    /**
    * @Title UserGuardianInfoMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回user_guardian_info
    * @param id id
    * @return UserGuardianInfo bean对象
     */
    UserGuardianInfo selectByPrimaryKey(Integer id);

    /**
    * @Title UserGuardianInfoMapper.updateByExampleSelective
    * @Description: 根据查询条件更新user_guardian_info部分字段
    * @param record 要更新成为的UserGuardianInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") UserGuardianInfo record, @Param("example") Criteria criteria);

    /**
    * @Title UserGuardianInfoMapper.updateByExample
    * @Description: 根据查询条件更新user_guardian_info全表字段
    * @param record 要更新成为的UserGuardianInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") UserGuardianInfo record, @Param("example") Criteria criteria);

    /**
    * @Title UserGuardianInfoMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新user_guardian_info部分字段
    * @param record 要更新成为的UserGuardianInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(UserGuardianInfo record);

    /**
    * @Title UserGuardianInfoMapper.updateByPrimaryKey
    * @Description: 根据主键更新user_guardian_info全部字段
    * @param record 要更新成为的UserGuardianInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(UserGuardianInfo record);
}