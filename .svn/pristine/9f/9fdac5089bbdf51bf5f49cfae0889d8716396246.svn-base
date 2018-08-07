package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.UserHouseInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: UserHouseInfoMapper
* @Description: user_house_info表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface UserHouseInfoMapper {
    /**
    * @Title UserHouseInfoMapper.countByExample
    * @Description: 根据查询条件，计算user_house_info个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title UserHouseInfoMapper.deleteByExample
    * @Description: 根据查询条件，删除user_house_info
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title UserHouseInfoMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除user_house_info
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title UserHouseInfoMapper.insert
    * @Description: 插入一个user_house_info
    * @param record user_house_info的bean对象
    * @return int  插入个数
     */
    int insert(UserHouseInfo record);

    /**
    * @Title UserHouseInfoMapper.insertSelective
    * @Description: 插入一个只有部分字段的user_house_info
    * @param record 只含部分字段的user_house_info的bean对象
    * @return int  插入个数
     */
    int insertSelective(UserHouseInfo record);

    /**
    * @Title UserHouseInfoMapper.selectByExample
    * @Description: 根据查询条件类，返回user_house_info结果集
    * @param example 通用查询条件类
    * @return List<UserHouseInfo>user_house_info结果集
     */
    List<UserHouseInfo> selectByExample(Criteria example);

    /**
    * @Title UserHouseInfoMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回user_house_info
    * @param id id
    * @return UserHouseInfo bean对象
     */
    UserHouseInfo selectByPrimaryKey(Integer id);

    /**
    * @Title UserHouseInfoMapper.updateByExampleSelective
    * @Description: 根据查询条件更新user_house_info部分字段
    * @param record 要更新成为的UserHouseInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") UserHouseInfo record, @Param("example") Criteria criteria);

    /**
    * @Title UserHouseInfoMapper.updateByExample
    * @Description: 根据查询条件更新user_house_info全表字段
    * @param record 要更新成为的UserHouseInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") UserHouseInfo record, @Param("example") Criteria criteria);

    /**
    * @Title UserHouseInfoMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新user_house_info部分字段
    * @param record 要更新成为的UserHouseInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(UserHouseInfo record);

    /**
    * @Title UserHouseInfoMapper.updateByPrimaryKey
    * @Description: 根据主键更新user_house_info全部字段
    * @param record 要更新成为的UserHouseInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(UserHouseInfo record);
}