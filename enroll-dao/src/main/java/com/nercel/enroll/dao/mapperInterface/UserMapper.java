package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.User;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserMapper
* @Description: user表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface UserMapper {
    /**
    * @Title UserMapper.countByExample
    * @Description: 根据查询条件，计算user个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title UserMapper.deleteByExample
    * @Description: 根据查询条件，删除user
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title UserMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除user
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title UserMapper.insert
    * @Description: 插入一个user
    * @param record user的bean对象
    * @return int  插入个数
     */
    int insert(User record);

    /**
    * @Title UserMapper.insertSelective
    * @Description: 插入一个只有部分字段的user
    * @param record 只含部分字段的user的bean对象
    * @return int  插入个数
     */
    int insertSelective(User record);

    /**
    * @Title UserMapper.selectByExample
    * @Description: 根据查询条件类，返回user结果集
    * @param example 通用查询条件类
    * @return List<User>user结果集
     */
    List<User> selectByExample(Criteria example);

    /**
    * @Title UserMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回user
    * @param id id
    * @return User bean对象
     */
    User selectByPrimaryKey(Integer id);

    /**
    * @Title UserMapper.updateByExampleSelective
    * @Description: 根据查询条件更新user部分字段
    * @param record 要更新成为的User对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") Criteria criteria);

    /**
    * @Title UserMapper.updateByExample
    * @Description: 根据查询条件更新user全表字段
    * @param record 要更新成为的User对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") User record, @Param("example") Criteria criteria);

    /**
    * @Title UserMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新user部分字段
    * @param record 要更新成为的User对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(User record);

    /**
    * @Title UserMapper.updateByPrimaryKey
    * @Description: 根据主键更新user全部字段
    * @param record 要更新成为的User对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(User record);
}