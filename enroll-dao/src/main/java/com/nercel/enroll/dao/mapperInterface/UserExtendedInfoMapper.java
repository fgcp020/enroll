package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.UserExtendedInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserExtendedInfoMapper
* @Description: user_extended_info表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface UserExtendedInfoMapper {
    /**
    * @Title UserExtendedInfoMapper.countByExample
    * @Description: 根据查询条件，计算user_extended_info个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title UserExtendedInfoMapper.deleteByExample
    * @Description: 根据查询条件，删除user_extended_info
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title UserExtendedInfoMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除user_extended_info
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title UserExtendedInfoMapper.insert
    * @Description: 插入一个user_extended_info
    * @param record user_extended_info的bean对象
    * @return int  插入个数
     */
    int insert(UserExtendedInfo record);

    /**
    * @Title UserExtendedInfoMapper.insertSelective
    * @Description: 插入一个只有部分字段的user_extended_info
    * @param record 只含部分字段的user_extended_info的bean对象
    * @return int  插入个数
     */
    int insertSelective(UserExtendedInfo record);

    /**
    * @Title UserExtendedInfoMapper.selectByExample
    * @Description: 根据查询条件类，返回user_extended_info结果集
    * @param example 通用查询条件类
    * @return List<UserExtendedInfo>user_extended_info结果集
     */
    List<UserExtendedInfo> selectByExample(Criteria example);

    /**
    * @Title UserExtendedInfoMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回user_extended_info
    * @param id id
    * @return UserExtendedInfo bean对象
     */
    UserExtendedInfo selectByPrimaryKey(Integer id);

    /**
    * @Title UserExtendedInfoMapper.updateByExampleSelective
    * @Description: 根据查询条件更新user_extended_info部分字段
    * @param record 要更新成为的UserExtendedInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") UserExtendedInfo record, @Param("example") Criteria criteria);

    /**
    * @Title UserExtendedInfoMapper.updateByExample
    * @Description: 根据查询条件更新user_extended_info全表字段
    * @param record 要更新成为的UserExtendedInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") UserExtendedInfo record, @Param("example") Criteria criteria);

    /**
    * @Title UserExtendedInfoMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新user_extended_info部分字段
    * @param record 要更新成为的UserExtendedInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(UserExtendedInfo record);

    /**
    * @Title UserExtendedInfoMapper.updateByPrimaryKey
    * @Description: 根据主键更新user_extended_info全部字段
    * @param record 要更新成为的UserExtendedInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(UserExtendedInfo record);
}