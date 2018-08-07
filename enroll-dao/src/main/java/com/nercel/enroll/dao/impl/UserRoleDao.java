package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.UserRoleMapper;
import com.nercel.enroll.domain.model.beans.UserRole;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserRoleDao
* @Description: user_role表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class UserRoleDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleDao.class);

    /**
     * @Fields UserRole表的Mybatis Mapper操作映射类
     */
    @Resource
    private UserRoleMapper userRoleMapper;

    /**
    * @Title UserRoleDao.countByExample
    * @Description: 根据查询条件，计算user_role个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    private int countByExample(Criteria example) {
        int count = this.userRoleMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title UserRoleDao.selectByPrimaryKey
    * @Description: 根据主键类，返回user_role
    * @param id id
    * @return UserRole bean对象
     */
    private UserRole selectByPrimaryKey(Integer id) {
        return this.userRoleMapper.selectByPrimaryKey(id);
    }

    /**
    * @Title UserRoleDao.selectByExample
    * @Description: 根据查询条件类，返回user_role结果集
    * @param example 通用查询条件类
    * @return List<UserRole>user_role结果集
     */
    private List<UserRole> selectByExample(Criteria example) {
        return this.userRoleMapper.selectByExample(example);
    }

    /**
    * @Title UserRoleDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除user_role
    * @param id id
    * @return int  删除个数
     */
    private int deleteByPrimaryKey(Integer id) {
        return this.userRoleMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Title UserRoleDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新user_role部分字段
    * @param record 要更新成为的UserRole对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKeySelective(UserRole record) {
        return this.userRoleMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title UserRoleDao.updateByPrimaryKey
    * @Description: 根据主键更新user_role全部字段
    * @param record 要更新成为的UserRole对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKey(UserRole record) {
        return this.userRoleMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title UserRoleDao.deleteByExample
    * @Description: 根据查询条件，删除user_role
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    private int deleteByExample(Criteria example) {
        return this.userRoleMapper.deleteByExample(example);
    }

    /**
    * @Title UserRoleDao.updateByExampleSelective
    * @Description: 根据查询条件更新user_role部分字段
    * @param record 要更新成为的UserRole对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExampleSelective(UserRole record, Criteria example) {
        return this.userRoleMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title UserRoleDao.updateByExample
    * @Description: 根据查询条件更新user_role全表字段
    * @param record 要更新成为的UserRole对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExample(UserRole record, Criteria example) {
        return this.userRoleMapper.updateByExample(record, example);
    }

    /**
    * @Title UserRoleDao.insert
    * @Description: 插入一个user_role
    * @param record user_role的bean对象
    * @return int  插入个数
     */
    private int insert(UserRole record) {
        return this.userRoleMapper.insert(record);
    }

    /**
    * @Title UserRoleDao.insertSelective
    * @Description: 插入一个只有部分字段的user_role
    * @param record 只含部分字段的user_role的bean对象
    * @return int  插入个数
     */
    private int insertSelective(UserRole record) {
        return this.userRoleMapper.insertSelective(record);
    }
}