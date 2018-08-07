package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.UserPhotoTypeMapper;
import com.nercel.enroll.domain.model.beans.UserPhotoType;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserPhotoTypeDao
* @Description: user_photo_type表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class UserPhotoTypeDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserPhotoTypeDao.class);

    /**
     * @Fields UserPhotoType表的Mybatis Mapper操作映射类
     */
    @Resource
    private UserPhotoTypeMapper userPhotoTypeMapper;

    /**
    * @Title UserPhotoTypeDao.countByExample
    * @Description: 根据查询条件，计算user_photo_type个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    private int countByExample(Criteria example) {
        int count = this.userPhotoTypeMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title UserPhotoTypeDao.selectByPrimaryKey
    * @Description: 根据主键类，返回user_photo_type
    * @param id id
    * @return UserPhotoType bean对象
     */
    private UserPhotoType selectByPrimaryKey(Integer id) {
        return this.userPhotoTypeMapper.selectByPrimaryKey(id);
    }

    /**
    * @Title UserPhotoTypeDao.selectByExample
    * @Description: 根据查询条件类，返回user_photo_type结果集
    * @param example 通用查询条件类
    * @return List<UserPhotoType>user_photo_type结果集
     */
    private List<UserPhotoType> selectByExample(Criteria example) {
        return this.userPhotoTypeMapper.selectByExample(example);
    }

    /**
    * @Title UserPhotoTypeDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除user_photo_type
    * @param id id
    * @return int  删除个数
     */
    private int deleteByPrimaryKey(Integer id) {
        return this.userPhotoTypeMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Title UserPhotoTypeDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新user_photo_type部分字段
    * @param record 要更新成为的UserPhotoType对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKeySelective(UserPhotoType record) {
        return this.userPhotoTypeMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title UserPhotoTypeDao.updateByPrimaryKey
    * @Description: 根据主键更新user_photo_type全部字段
    * @param record 要更新成为的UserPhotoType对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKey(UserPhotoType record) {
        return this.userPhotoTypeMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title UserPhotoTypeDao.deleteByExample
    * @Description: 根据查询条件，删除user_photo_type
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    private int deleteByExample(Criteria example) {
        return this.userPhotoTypeMapper.deleteByExample(example);
    }

    /**
    * @Title UserPhotoTypeDao.updateByExampleSelective
    * @Description: 根据查询条件更新user_photo_type部分字段
    * @param record 要更新成为的UserPhotoType对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExampleSelective(UserPhotoType record, Criteria example) {
        return this.userPhotoTypeMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title UserPhotoTypeDao.updateByExample
    * @Description: 根据查询条件更新user_photo_type全表字段
    * @param record 要更新成为的UserPhotoType对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExample(UserPhotoType record, Criteria example) {
        return this.userPhotoTypeMapper.updateByExample(record, example);
    }

    /**
    * @Title UserPhotoTypeDao.insert
    * @Description: 插入一个user_photo_type
    * @param record user_photo_type的bean对象
    * @return int  插入个数
     */
    private int insert(UserPhotoType record) {
        return this.userPhotoTypeMapper.insert(record);
    }

    /**
    * @Title UserPhotoTypeDao.insertSelective
    * @Description: 插入一个只有部分字段的user_photo_type
    * @param record 只含部分字段的user_photo_type的bean对象
    * @return int  插入个数
     */
    private int insertSelective(UserPhotoType record) {
        return this.userPhotoTypeMapper.insertSelective(record);
    }
}