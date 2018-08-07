package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.UserPhotoType;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserPhotoTypeMapper
* @Description: user_photo_type表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface UserPhotoTypeMapper {
    /**
    * @Title UserPhotoTypeMapper.countByExample
    * @Description: 根据查询条件，计算user_photo_type个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title UserPhotoTypeMapper.deleteByExample
    * @Description: 根据查询条件，删除user_photo_type
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title UserPhotoTypeMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除user_photo_type
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title UserPhotoTypeMapper.insert
    * @Description: 插入一个user_photo_type
    * @param record user_photo_type的bean对象
    * @return int  插入个数
     */
    int insert(UserPhotoType record);

    /**
    * @Title UserPhotoTypeMapper.insertSelective
    * @Description: 插入一个只有部分字段的user_photo_type
    * @param record 只含部分字段的user_photo_type的bean对象
    * @return int  插入个数
     */
    int insertSelective(UserPhotoType record);

    /**
    * @Title UserPhotoTypeMapper.selectByExample
    * @Description: 根据查询条件类，返回user_photo_type结果集
    * @param example 通用查询条件类
    * @return List<UserPhotoType>user_photo_type结果集
     */
    List<UserPhotoType> selectByExample(Criteria example);

    /**
    * @Title UserPhotoTypeMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回user_photo_type
    * @param id id
    * @return UserPhotoType bean对象
     */
    UserPhotoType selectByPrimaryKey(Integer id);

    /**
    * @Title UserPhotoTypeMapper.updateByExampleSelective
    * @Description: 根据查询条件更新user_photo_type部分字段
    * @param record 要更新成为的UserPhotoType对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") UserPhotoType record, @Param("example") Criteria criteria);

    /**
    * @Title UserPhotoTypeMapper.updateByExample
    * @Description: 根据查询条件更新user_photo_type全表字段
    * @param record 要更新成为的UserPhotoType对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") UserPhotoType record, @Param("example") Criteria criteria);

    /**
    * @Title UserPhotoTypeMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新user_photo_type部分字段
    * @param record 要更新成为的UserPhotoType对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(UserPhotoType record);

    /**
    * @Title UserPhotoTypeMapper.updateByPrimaryKey
    * @Description: 根据主键更新user_photo_type全部字段
    * @param record 要更新成为的UserPhotoType对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(UserPhotoType record);
}