package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.RelationalMapper;
import com.nercel.enroll.domain.model.beans.Relational;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: RelationalDao
* @Description: relational表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class RelationalDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RelationalDao.class);

    /**
     * @Fields Relational表的Mybatis Mapper操作映射类
     */
    @Resource
    private RelationalMapper relationalMapper;

    /**
    * @Title RelationalDao.countByExample
    * @Description: 根据查询条件，计算relational个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    private int countByExample(Criteria example) {
        int count = this.relationalMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title RelationalDao.selectByPrimaryKey
    * @Description: 根据主键类，返回relational
    * @param id id
    * @return Relational bean对象
     */
    private Relational selectByPrimaryKey(Integer id) {
        return this.relationalMapper.selectByPrimaryKey(id);
    }

    /**
    * @Title RelationalDao.selectByExample
    * @Description: 根据查询条件类，返回relational结果集
    * @param example 通用查询条件类
    * @return List<Relational>relational结果集
     */
    private List<Relational> selectByExample(Criteria example) {
        return this.relationalMapper.selectByExample(example);
    }

    /**
    * @Title RelationalDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除relational
    * @param id id
    * @return int  删除个数
     */
    private int deleteByPrimaryKey(Integer id) {
        return this.relationalMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Title RelationalDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新relational部分字段
    * @param record 要更新成为的Relational对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKeySelective(Relational record) {
        return this.relationalMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title RelationalDao.updateByPrimaryKey
    * @Description: 根据主键更新relational全部字段
    * @param record 要更新成为的Relational对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKey(Relational record) {
        return this.relationalMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title RelationalDao.deleteByExample
    * @Description: 根据查询条件，删除relational
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    private int deleteByExample(Criteria example) {
        return this.relationalMapper.deleteByExample(example);
    }

    /**
    * @Title RelationalDao.updateByExampleSelective
    * @Description: 根据查询条件更新relational部分字段
    * @param record 要更新成为的Relational对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExampleSelective(Relational record, Criteria example) {
        return this.relationalMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title RelationalDao.updateByExample
    * @Description: 根据查询条件更新relational全表字段
    * @param record 要更新成为的Relational对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExample(Relational record, Criteria example) {
        return this.relationalMapper.updateByExample(record, example);
    }

    /**
    * @Title RelationalDao.insert
    * @Description: 插入一个relational
    * @param record relational的bean对象
    * @return int  插入个数
     */
    private int insert(Relational record) {
        return this.relationalMapper.insert(record);
    }

    /**
    * @Title RelationalDao.insertSelective
    * @Description: 插入一个只有部分字段的relational
    * @param record 只含部分字段的relational的bean对象
    * @return int  插入个数
     */
    private int insertSelective(Relational record) {
        return this.relationalMapper.insertSelective(record);
    }
    
    /**
     * 查询出所有的与学生的关系
     * @return
     */
    public List<Relational> queryAllRelational(){
        return this.selectByExample(null);
    }
    
    public Relational queryRelationalById(Integer id){
    	return this.selectByPrimaryKey(id);
    }
}