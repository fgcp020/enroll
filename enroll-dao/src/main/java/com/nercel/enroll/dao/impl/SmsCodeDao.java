package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.SmsCodeMapper;
import com.nercel.enroll.domain.model.beans.SmsCode;
import com.nercel.enroll.domain.model.constants.TSmsCode;
import com.nercel.enroll.domain.model.constants.TStudentInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import com.nercel.enroll.domain.mybatis.Criteria.Condition;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: SmsCodeDao
 * @Description: sms_code表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class SmsCodeDao {
	/**
	 * @Fields LOGGER : 日志操作类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SmsCodeDao.class);

	/**
	 * @Fields SmsCode表的Mybatis Mapper操作映射类
	 */
	@Resource
	private SmsCodeMapper smsCodeMapper;

	/**
	 * @Title SmsCodeDao.countByExample
	 * @Description: 根据查询条件，计算sms_code个数
	 * @param example
	 *            通用查询条件类
	 * @return int 结果个数
	 */
	private int countByExample(Criteria example) {
		int count = this.smsCodeMapper.countByExample(example);
		LOGGER.debug("count: {}", count);
		return count;
	}

	/**
	 * @Title SmsCodeDao.selectByPrimaryKey
	 * @Description: 根据主键类，返回sms_code
	 * @param id
	 *            id
	 * @return SmsCode bean对象
	 */
	private SmsCode selectByPrimaryKey(Integer id) {
		return this.smsCodeMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Title SmsCodeDao.selectByExample
	 * @Description: 根据查询条件类，返回sms_code结果集
	 * @param example
	 *            通用查询条件类
	 * @return List<SmsCode>sms_code结果集
	 */
	private List<SmsCode> selectByExample(Criteria example) {
		return this.smsCodeMapper.selectByExample(example);
	}

	/**
	 * @Title SmsCodeDao.deleteByPrimaryKey
	 * @Description: 根据属性名称，删除sms_code
	 * @param id
	 *            id
	 * @return int 删除个数
	 */
	private int deleteByPrimaryKey(Integer id) {
		return this.smsCodeMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title SmsCodeDao.updateByPrimaryKeySelective
	 * @Description: 根据主键更新sms_code部分字段
	 * @param record
	 *            要更新成为的SmsCode对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKeySelective(SmsCode record) {
		return this.smsCodeMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title SmsCodeDao.updateByPrimaryKey
	 * @Description: 根据主键更新sms_code全部字段
	 * @param record
	 *            要更新成为的SmsCode对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKey(SmsCode record) {
		return this.smsCodeMapper.updateByPrimaryKey(record);
	}

	/**
	 * @Title SmsCodeDao.deleteByExample
	 * @Description: 根据查询条件，删除sms_code
	 * @param example
	 *            通用查询条件类
	 * @return int 删除个数
	 */
	private int deleteByExample(Criteria example) {
		return this.smsCodeMapper.deleteByExample(example);
	}

	/**
	 * @Title SmsCodeDao.updateByExampleSelective
	 * @Description: 根据查询条件更新sms_code部分字段
	 * @param record
	 *            要更新成为的SmsCode对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExampleSelective(SmsCode record, Criteria example) {
		return this.smsCodeMapper.updateByExampleSelective(record, example);
	}

	/**
	 * @Title SmsCodeDao.updateByExample
	 * @Description: 根据查询条件更新sms_code全表字段
	 * @param record
	 *            要更新成为的SmsCode对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExample(SmsCode record, Criteria example) {
		return this.smsCodeMapper.updateByExample(record, example);
	}

	/**
	 * @Title SmsCodeDao.insert
	 * @Description: 插入一个sms_code
	 * @param record
	 *            sms_code的bean对象
	 * @return int 插入个数
	 */
	private int insert(SmsCode record) {
		return this.smsCodeMapper.insert(record);
	}

	/**
	 * @Title SmsCodeDao.insertSelective
	 * @Description: 插入一个只有部分字段的sms_code
	 * @param record
	 *            只含部分字段的sms_code的bean对象
	 * @return int 插入个数
	 */
	private int insertSelective(SmsCode record) {
		return this.smsCodeMapper.insertSelective(record);
	}

	/**
	 * 插入一条验证码
	 * 
	 * @param record
	 *            验证码
	 * @return
	 */
	public int saveSmsCode(SmsCode record) {
		return this.insertSelective(record);
	}

	/**
	 * 根据手机号和验证码查询信息
	 * 
	 * @param phone
	 *            手机号
	 * @param code
	 *            验证码
	 * @return
	 */
	public List<SmsCode> querySmsCodeByPhoneAndCode(String phone, String code) {

		Criteria example = new Criteria();
		Condition condition = example.createConditon();
		condition.andEqualTo(TSmsCode.PHONE, phone).andEqualTo(TSmsCode.CODE, code);
		return this.selectByExample(example);
	}
    /**
     * 根据手机号查询已经全部发送的验证码
     * @param phone 手机号
     * @return
     */
	public List<SmsCode> querySmsCodeByPhone(String phone) {
		Criteria example = new Criteria();
		Condition condition = example.createConditon();
		condition.andEqualTo(TSmsCode.PHONE, phone);
		return this.selectByExample(example);

	}
}