package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.SchoolRelationshipMapper;
import com.nercel.enroll.domain.model.beans.SchoolRelationship;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: SchoolRelationshipDao
* @Description: school_relationship表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class SchoolRelationshipDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SchoolRelationshipDao.class);

    /**
     * @Fields SchoolRelationship表的Mybatis Mapper操作映射类
     */
    @Resource
    private SchoolRelationshipMapper schoolRelationshipMapper;

    /**
    * @Title SchoolRelationshipDao.countByExample
    * @Description: 根据查询条件，计算school_relationship个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    private int countByExample(Criteria example) {
        int count = this.schoolRelationshipMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title SchoolRelationshipDao.selectByPrimaryKey
    * @Description: 根据主键类，返回school_relationship
    * @param id id
    * @return SchoolRelationship bean对象
     */
    private SchoolRelationship selectByPrimaryKey(Integer id) {
        return this.schoolRelationshipMapper.selectByPrimaryKey(id);
    }

    /**
    * @Title SchoolRelationshipDao.selectByExample
    * @Description: 根据查询条件类，返回school_relationship结果集
    * @param example 通用查询条件类
    * @return List<SchoolRelationship>school_relationship结果集
     */
    private List<SchoolRelationship> selectByExample(Criteria example) {
        return this.schoolRelationshipMapper.selectByExample(example);
    }

    /**
    * @Title SchoolRelationshipDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除school_relationship
    * @param id id
    * @return int  删除个数
     */
    private int deleteByPrimaryKey(Integer id) {
        return this.schoolRelationshipMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Title SchoolRelationshipDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新school_relationship部分字段
    * @param record 要更新成为的SchoolRelationship对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKeySelective(SchoolRelationship record) {
        return this.schoolRelationshipMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title SchoolRelationshipDao.updateByPrimaryKey
    * @Description: 根据主键更新school_relationship全部字段
    * @param record 要更新成为的SchoolRelationship对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKey(SchoolRelationship record) {
        return this.schoolRelationshipMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title SchoolRelationshipDao.deleteByExample
    * @Description: 根据查询条件，删除school_relationship
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    private int deleteByExample(Criteria example) {
        return this.schoolRelationshipMapper.deleteByExample(example);
    }

    /**
    * @Title SchoolRelationshipDao.updateByExampleSelective
    * @Description: 根据查询条件更新school_relationship部分字段
    * @param record 要更新成为的SchoolRelationship对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExampleSelective(SchoolRelationship record, Criteria example) {
        return this.schoolRelationshipMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title SchoolRelationshipDao.updateByExample
    * @Description: 根据查询条件更新school_relationship全表字段
    * @param record 要更新成为的SchoolRelationship对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExample(SchoolRelationship record, Criteria example) {
        return this.schoolRelationshipMapper.updateByExample(record, example);
    }

    /**
    * @Title SchoolRelationshipDao.insert
    * @Description: 插入一个school_relationship
    * @param record school_relationship的bean对象
    * @return int  插入个数
     */
    private int insert(SchoolRelationship record) {
        return this.schoolRelationshipMapper.insert(record);
    }

    /**
    * @Title SchoolRelationshipDao.insertSelective
    * @Description: 插入一个只有部分字段的school_relationship
    * @param record 只含部分字段的school_relationship的bean对象
    * @return int  插入个数
     */
    private int insertSelective(SchoolRelationship record) {
        return this.schoolRelationshipMapper.insertSelective(record);
    }
}