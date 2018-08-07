package com.nercel.enroll.dao.mapperInterface;

import com.nercel.enroll.domain.model.beans.StudentInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: StudentInfoMapper
* @Description: student_info表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface StudentInfoMapper {
    /**
    * @Title StudentInfoMapper.countByExample
    * @Description: 根据查询条件，计算student_info个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
    * @Title StudentInfoMapper.deleteByExample
    * @Description: 根据查询条件，删除student_info
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
    * @Title StudentInfoMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除student_info
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer id);

    /**
    * @Title StudentInfoMapper.insert
    * @Description: 插入一个student_info
    * @param record student_info的bean对象
    * @return int  插入个数
     */
    int insert(StudentInfo record);

    /**
    * @Title StudentInfoMapper.insertSelective
    * @Description: 插入一个只有部分字段的student_info
    * @param record 只含部分字段的student_info的bean对象
    * @return int  插入个数
     */
    int insertSelective(StudentInfo record);

    /**
    * @Title StudentInfoMapper.selectByExample
    * @Description: 根据查询条件类，返回student_info结果集
    * @param example 通用查询条件类
    * @return List<StudentInfo>student_info结果集
     */
    List<StudentInfo> selectByExample(Criteria example);

    /**
    * @Title StudentInfoMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回student_info
    * @param id id
    * @return StudentInfo bean对象
     */
    StudentInfo selectByPrimaryKey(Integer id);

    /**
    * @Title StudentInfoMapper.updateByExampleSelective
    * @Description: 根据查询条件更新student_info部分字段
    * @param record 要更新成为的StudentInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") Criteria criteria);

    /**
    * @Title StudentInfoMapper.updateByExample
    * @Description: 根据查询条件更新student_info全表字段
    * @param record 要更新成为的StudentInfo对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") StudentInfo record, @Param("example") Criteria criteria);

    /**
    * @Title StudentInfoMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新student_info部分字段
    * @param record 要更新成为的StudentInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(StudentInfo record);

    /**
    * @Title StudentInfoMapper.updateByPrimaryKey
    * @Description: 根据主键更新student_info全部字段
    * @param record 要更新成为的StudentInfo对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(StudentInfo record);
}