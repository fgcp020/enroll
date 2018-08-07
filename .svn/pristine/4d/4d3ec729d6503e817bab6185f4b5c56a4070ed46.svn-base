package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.UserPhotoInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserPhotoInfoMapper
* @Description: user_photo_info表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface UserPhotoInfoMapper {
    /**
    * @Title UserPhotoInfoMapper.countByExample
    * @Description: 根据查询条件，计算user_photo_info个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title UserPhotoInfoMapper.deleteByExample
    * @Description: 根据查询条件，删除user_photo_info
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title UserPhotoInfoMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除user_photo_info
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title UserPhotoInfoMapper.insert
    * @Description: 插入一个user_photo_info
    * @param record user_photo_info的bean对象
    * @return int  插入个数
     */
    int insert(UserPhotoInfo record);

    /**
    * @Title UserPhotoInfoMapper.insertSelective
    * @Description: 插入一个只有部分字段的user_photo_info
    * @param record 只含部分字段的user_photo_info的bean对象
    * @return int  插入个数
     */
    int insertSelective(UserPhotoInfo record);

    /**
    * @Title UserPhotoInfoMapper.selectByExample
    * @Description: 根据查询条件类，返回user_photo_info结果集
    * @param example 通用查询条件类
    * @return List<UserPhotoInfo>user_photo_info结果集
     */
    List<UserPhotoInfo> selectByExample(Criteria example);

    /**
    * @Title UserPhotoInfoMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回user_photo_info
    * @param id id
    * @return UserPhotoInfo bean对象
     */
    UserPhotoInfo selectByPrimaryKey(Integer id);

    /**
    * @Title UserPhotoInfoMapper.updateByExampleSelective
    * @Description: 根据查询条件更新user_photo_info部分字段
    * @param record 要更新成为的UserPhotoInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") UserPhotoInfo record, @Param("example") Criteria criteria);

    /**
    * @Title UserPhotoInfoMapper.updateByExample
    * @Description: 根据查询条件更新user_photo_info全表字段
    * @param record 要更新成为的UserPhotoInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") UserPhotoInfo record, @Param("example") Criteria criteria);

    /**
    * @Title UserPhotoInfoMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新user_photo_info部分字段
    * @param record 要更新成为的UserPhotoInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(UserPhotoInfo record);

    /**
    * @Title UserPhotoInfoMapper.updateByPrimaryKey
    * @Description: 根据主键更新user_photo_info全部字段
    * @param record 要更新成为的UserPhotoInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(UserPhotoInfo record);
}