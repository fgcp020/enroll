package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.CertificatesTypeMapper;
import com.nercel.enroll.domain.model.beans.CertificatesType;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: CertificatesTypeDao
* @Description: certificates_type表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class CertificatesTypeDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CertificatesTypeDao.class);

    /**
     * @Fields CertificatesType表的Mybatis Mapper操作映射类
     */
    @Resource
    private CertificatesTypeMapper certificatesTypeMapper;

    /**
    * @Title CertificatesTypeDao.countByExample
    * @Description: 根据查询条件，计算certificates_type个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    private int countByExample(Criteria example) {
        int count = this.certificatesTypeMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title CertificatesTypeDao.selectByPrimaryKey
    * @Description: 根据主键类，返回certificates_type
    * @param id id
    * @return CertificatesType bean对象
     */
    private CertificatesType selectByPrimaryKey(Integer id) {
        return this.certificatesTypeMapper.selectByPrimaryKey(id);
    }

    /**
    * @Title CertificatesTypeDao.selectByExample
    * @Description: 根据查询条件类，返回certificates_type结果集
    * @param example 通用查询条件类
    * @return List<CertificatesType>certificates_type结果集
     */
    private List<CertificatesType> selectByExample(Criteria example) {
        return this.certificatesTypeMapper.selectByExample(example);
    }

    /**
    * @Title CertificatesTypeDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除certificates_type
    * @param id id
    * @return int  删除个数
     */
    private int deleteByPrimaryKey(Integer id) {
        return this.certificatesTypeMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Title CertificatesTypeDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新certificates_type部分字段
    * @param record 要更新成为的CertificatesType对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKeySelective(CertificatesType record) {
        return this.certificatesTypeMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title CertificatesTypeDao.updateByPrimaryKey
    * @Description: 根据主键更新certificates_type全部字段
    * @param record 要更新成为的CertificatesType对象
    * @return int 更新记录数
     */
    private int updateByPrimaryKey(CertificatesType record) {
        return this.certificatesTypeMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title CertificatesTypeDao.deleteByExample
    * @Description: 根据查询条件，删除certificates_type
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    private int deleteByExample(Criteria example) {
        return this.certificatesTypeMapper.deleteByExample(example);
    }

    /**
    * @Title CertificatesTypeDao.updateByExampleSelective
    * @Description: 根据查询条件更新certificates_type部分字段
    * @param record 要更新成为的CertificatesType对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExampleSelective(CertificatesType record, Criteria example) {
        return this.certificatesTypeMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title CertificatesTypeDao.updateByExample
    * @Description: 根据查询条件更新certificates_type全表字段
    * @param record 要更新成为的CertificatesType对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    private int updateByExample(CertificatesType record, Criteria example) {
        return this.certificatesTypeMapper.updateByExample(record, example);
    }

    /**
    * @Title CertificatesTypeDao.insert
    * @Description: 插入一个certificates_type
    * @param record certificates_type的bean对象
    * @return int  插入个数
     */
    private int insert(CertificatesType record) {
        return this.certificatesTypeMapper.insert(record);
    }

    /**
    * @Title CertificatesTypeDao.insertSelective
    * @Description: 插入一个只有部分字段的certificates_type
    * @param record 只含部分字段的certificates_type的bean对象
    * @return int  插入个数
     */
    private int insertSelective(CertificatesType record) {
        return this.certificatesTypeMapper.insertSelective(record);
    }
    
    /**
     * 查询出所有的证件类型
     * @return
     */
    public List<CertificatesType> queryAllCertificatesType(){
        return this.selectByExample(null);
    }
    
    public CertificatesType queryCertificatesTypeById(Integer id){
    	return this.selectByPrimaryKey(id);
    }
}