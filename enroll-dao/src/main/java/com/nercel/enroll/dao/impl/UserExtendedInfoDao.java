package com.nercel.enroll.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
 
import com.nercel.enroll.dao.mapperInterface.UserExtendedInfoMapper;
import com.nercel.enroll.domain.model.beans.UserExtendedInfo;
import com.nercel.enroll.domain.model.constants.TUserExtendedInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import com.nercel.enroll.domain.mybatis.Criteria.Condition;

/**
 * @ClassName: UserExtendedInfoDao
 * @Description: user_extended_info表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class UserExtendedInfoDao {
	/**
	 * @Fields LOGGER : 日志操作类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserExtendedInfoDao.class);

	/**
	 * @Fields UserExtendedInfo表的Mybatis Mapper操作映射类
	 */
	@Resource
	private UserExtendedInfoMapper userExtendedInfoMapper;

	/**
	 * @Title UserExtendedInfoDao.countByExample
	 * @Description: 根据查询条件，计算user_extended_info个数
	 * @param example
	 *            通用查询条件类
	 * @return int 结果个数
	 */
	private int countByExample(Criteria example) {
		int count = this.userExtendedInfoMapper.countByExample(example);
		LOGGER.debug("count: {}", count);
		return count;
	}

	/**
	 * @Title UserExtendedInfoDao.selectByPrimaryKey
	 * @Description: 根据主键类，返回user_extended_info
	 * @param id
	 *            id
	 * @return UserExtendedInfo bean对象
	 */
	private UserExtendedInfo selectByPrimaryKey(Integer id) {
		return this.userExtendedInfoMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Title UserExtendedInfoDao.selectByExample
	 * @Description: 根据查询条件类，返回user_extended_info结果集
	 * @param example
	 *            通用查询条件类
	 * @return List<UserExtendedInfo>user_extended_info结果集
	 */
	private List<UserExtendedInfo> selectByExample(Criteria example) {
		return this.userExtendedInfoMapper.selectByExample(example);
	}

	/**
	 * @Title UserExtendedInfoDao.deleteByPrimaryKey
	 * @Description: 根据属性名称，删除user_extended_info
	 * @param id
	 *            id
	 * @return int 删除个数
	 */
	private int deleteByPrimaryKey(Integer id) {
		return this.userExtendedInfoMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title UserExtendedInfoDao.updateByPrimaryKeySelective
	 * @Description: 根据主键更新user_extended_info部分字段
	 * @param record
	 *            要更新成为的UserExtendedInfo对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKeySelective(UserExtendedInfo record) {
		return this.userExtendedInfoMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title UserExtendedInfoDao.updateByPrimaryKey
	 * @Description: 根据主键更新user_extended_info全部字段
	 * @param record
	 *            要更新成为的UserExtendedInfo对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKey(UserExtendedInfo record) {
		return this.userExtendedInfoMapper.updateByPrimaryKey(record);
	}

	/**
	 * @Title UserExtendedInfoDao.deleteByExample
	 * @Description: 根据查询条件，删除user_extended_info
	 * @param example
	 *            通用查询条件类
	 * @return int 删除个数
	 */
	private int deleteByExample(Criteria example) {
		return this.userExtendedInfoMapper.deleteByExample(example);
	}

	/**
	 * @Title UserExtendedInfoDao.updateByExampleSelective
	 * @Description: 根据查询条件更新user_extended_info部分字段
	 * @param record
	 *            要更新成为的UserExtendedInfo对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExampleSelective(UserExtendedInfo record, Criteria example) {
		return this.userExtendedInfoMapper.updateByExampleSelective(record, example);
	}

	/**
	 * @Title UserExtendedInfoDao.updateByExample
	 * @Description: 根据查询条件更新user_extended_info全表字段
	 * @param record
	 *            要更新成为的UserExtendedInfo对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExample(UserExtendedInfo record, Criteria example) {
		return this.userExtendedInfoMapper.updateByExample(record, example);
	}

	/**
	 * @Title UserExtendedInfoDao.insert
	 * @Description: 插入一个user_extended_info
	 * @param record
	 *            user_extended_info的bean对象
	 * @return int 插入个数
	 */
	private int insert(UserExtendedInfo record) {
		return this.userExtendedInfoMapper.insert(record);
	}

	/**
	 * @Title UserExtendedInfoDao.insertSelective
	 * @Description: 插入一个只有部分字段的user_extended_info
	 * @param record
	 *            只含部分字段的user_extended_info的bean对象
	 * @return int 插入个数
	 */
	private int insertSelective(UserExtendedInfo record) {
		return this.userExtendedInfoMapper.insertSelective(record);
	}

	/**
	 * 选择性保存用户的扩展信息
	 * 
	 * @param record
	 *            用户的扩展信息
	 * @return 受影响的记录的行数
	 */
	public Integer save(UserExtendedInfo record) {
		return this.insertSelective(record);
	}

	/**
	 * 根据用户id查询出扩展信息
	 * 
	 * @param userId
	 *            用户id
	 * @return 扩展信息
	 */
	public List<UserExtendedInfo> queryUserExtendedInfoByUserId(Integer userId) {

		Criteria example = new Criteria();
		Condition condition = example.createConditon();
		condition.andEqualTo(TUserExtendedInfo.USER_ID, userId);
		return this.selectByExample(example);

	}

	/**
	 * 根据id查询出用户的扩展信息
	 * 
	 * @param userExtendedInfo
	 *            扩展信息
	 * @return
	 */
	public Integer updateUserExtendedInfoById(UserExtendedInfo userExtendedInfo) {
		return this.updateByPrimaryKeySelective(userExtendedInfo);
	}
}