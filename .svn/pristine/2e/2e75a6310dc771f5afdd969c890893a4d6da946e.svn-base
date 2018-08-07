package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.UserRole;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserRoleMapper
* @Description: user_role表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface UserRoleMapper {
    /**
    * @Title UserRoleMapper.countByExample
    * @Description: 根据查询条件，计算user_role个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title UserRoleMapper.deleteByExample
    * @Description: 根据查询条件，删除user_role
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title UserRoleMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除user_role
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title UserRoleMapper.insert
    * @Description: 插入一个user_role
    * @param record user_role的bean对象
    * @return int  插入个数
     */
    int insert(UserRole record);

    /**
    * @Title UserRoleMapper.insertSelective
    * @Description: 插入一个只有部分字段的user_role
    * @param record 只含部分字段的user_role的bean对象
    * @return int  插入个数
     */
    int insertSelective(UserRole record);

    /**
    * @Title UserRoleMapper.selectByExample
    * @Description: 根据查询条件类，返回user_role结果集
    * @param example 通用查询条件类
    * @return List<UserRole>user_role结果集
     */
    List<UserRole> selectByExample(Criteria example);

    /**
    * @Title UserRoleMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回user_role
    * @param id id
    * @return UserRole bean对象
     */
    UserRole selectByPrimaryKey(Integer id);

    /**
    * @Title UserRoleMapper.updateByExampleSelective
    * @Description: 根据查询条件更新user_role部分字段
    * @param record 要更新成为的UserRole对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") Criteria criteria);

    /**
    * @Title UserRoleMapper.updateByExample
    * @Description: 根据查询条件更新user_role全表字段
    * @param record 要更新成为的UserRole对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") Criteria criteria);

    /**
    * @Title UserRoleMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新user_role部分字段
    * @param record 要更新成为的UserRole对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
    * @Title UserRoleMapper.updateByPrimaryKey
    * @Description: 根据主键更新user_role全部字段
    * @param record 要更新成为的UserRole对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(UserRole record);
}