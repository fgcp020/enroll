package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.StudentInfoMapper;
import com.nercel.enroll.domain.model.beans.StudentInfo;
import com.nercel.enroll.domain.model.constants.TStudentInfo;
import com.nercel.enroll.domain.model.constants.TUser;
import com.nercel.enroll.domain.mybatis.Criteria;
import com.nercel.enroll.domain.mybatis.Criteria.Condition;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: StudentInfoDao
 * @Description: student_info表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class StudentInfoDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentInfoDao.class);

    /**
     * @Fields StudentInfo表的Mybatis Mapper操作映射类
     */
    @Resource
    private StudentInfoMapper studentInfoMapper;

    /**
     * @Title StudentInfoDao.countByExample
     * @Description: 根据查询条件，计算student_info个数
     * @param example
     *            通用查询条件类
     * @return int 结果个数
     */
    private int countByExample(Criteria example) {
        int count = this.studentInfoMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
     * @Title StudentInfoDao.selectByPrimaryKey
     * @Description: 根据主键类，返回student_info
     * @param id
     *            id
     * @return StudentInfo bean对象
     */
    private StudentInfo selectByPrimaryKey(Integer id) {
        return this.studentInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * @Title StudentInfoDao.selectByExample
     * @Description: 根据查询条件类，返回student_info结果集
     * @param example
     *            通用查询条件类
     * @return List<StudentInfo>  student_info结果集
     */
    private List<StudentInfo> selectByExample(Criteria example) {
        return this.studentInfoMapper.selectByExample(example);
    }

    /**
     * @Title StudentInfoDao.deleteByPrimaryKey
     * @Description: 根据属性名称，删除student_info
     * @param id
     *            id
     * @return int 删除个数
     */
    private int deleteByPrimaryKey(Integer id) {
        return this.studentInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Title StudentInfoDao.updateByPrimaryKeySelective
     * @Description: 根据主键更新student_info部分字段
     * @param record
     *            要更新成为的StudentInfo对象
     * @return int 更新记录数
     */
    private int updateByPrimaryKeySelective(StudentInfo record) {
        return this.studentInfoMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * @Title StudentInfoDao.updateByPrimaryKey
     * @Description: 根据主键更新student_info全部字段
     * @param record
     *            要更新成为的StudentInfo对象
     * @return int 更新记录数
     */
    private int updateByPrimaryKey(StudentInfo record) {
        return this.studentInfoMapper.updateByPrimaryKey(record);
    }

    /**
     * @Title StudentInfoDao.deleteByExample
     * @Description: 根据查询条件，删除student_info
     * @param example
     *            通用查询条件类
     * @return int 删除个数
     */
    private int deleteByExample(Criteria example) {
        return this.studentInfoMapper.deleteByExample(example);
    }

    /**
     * @Title StudentInfoDao.updateByExampleSelective
     * @Description: 根据查询条件更新student_info部分字段
     * @param record
     *            要更新成为的StudentInfo对象
     * @param example
     *            更新记录的查询条件
     * @return int 更新记录数
     */
    private int updateByExampleSelective(StudentInfo record, Criteria example) {
        return this.studentInfoMapper.updateByExampleSelective(record, example);
    }

    /**
     * @Title StudentInfoDao.updateByExample
     * @Description: 根据查询条件更新student_info全表字段
     * @param record
     *            要更新成为的StudentInfo对象
     * @param example
     *            更新记录的查询条件
     * @return int 更新记录数
     */
    private int updateByExample(StudentInfo record, Criteria example) {
        return this.studentInfoMapper.updateByExample(record, example);
    }

    /**
     * @Title StudentInfoDao.insert
     * @Description: 插入一个student_info
     * @param record
     *            student_info的bean对象
     * @return int 插入个数
     */
    private int insert(StudentInfo record) {
        return this.studentInfoMapper.insert(record);
    }

    /**
     * @Title StudentInfoDao.insertSelective
     * @Description: 插入一个只有部分字段的student_info
     * @param record
     *            只含部分字段的student_info的bean对象
     * @return int 插入个数
     */
    private int insertSelective(StudentInfo record) {
        return this.studentInfoMapper.insertSelective(record);
    }

    /**
     * 查询出2018年小学毕业生学籍信息
     * 
     * @return
     */
    public List<StudentInfo> queryAllStudentInfo() {
        return this.selectByExample(null);
    }

    /**
     * 根据学籍号查询小学毕业生信息
     * 
     * @return
     */
    public List<StudentInfo> queryStudentInfo(String studentNumber) {
        Criteria example = new Criteria();
        Condition condition = example.createConditon();
        condition.andEqualTo(TStudentInfo.STUDENT_NUMBER, studentNumber);
        return this.selectByExample(example);
    }
    
    
}