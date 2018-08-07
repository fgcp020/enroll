package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.UserGuardianInfoMapper;
import com.nercel.enroll.domain.model.beans.UserGuardianInfo;
import com.nercel.enroll.domain.model.constants.TUserExtendedInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import com.nercel.enroll.domain.mybatis.Criteria.Condition;
 
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserGuardianInfoDao
 * @Description: user_guardian_info表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class UserGuardianInfoDao {
	/**
	 * @Fields LOGGER : 日志操作类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserGuardianInfoDao.class);

	/**
	 * @Fields UserGuardianInfo表的Mybatis Mapper操作映射类
	 */
	@Resource
	private UserGuardianInfoMapper userGuardianInfoMapper;

	/**
	 * @Title UserGuardianInfoDao.countByExample
	 * @Description: 根据查询条件，计算user_guardian_info个数
	 * @param example
	 *            通用查询条件类
	 * @return int 结果个数
	 */
	private int countByExample(Criteria example) {
		int count = this.userGuardianInfoMapper.countByExample(example);
		LOGGER.debug("count: {}", count);
		return count;
	}

	/**
	 * @Title UserGuardianInfoDao.selectByPrimaryKey
	 * @Description: 根据主键类，返回user_guardian_info
	 * @param id
	 *            id
	 * @return UserGuardianInfo bean对象
	 */
	private UserGuardianInfo selectByPrimaryKey(Integer id) {
		return this.userGuardianInfoMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Title UserGuardianInfoDao.selectByExample
	 * @Description: 根据查询条件类，返回user_guardian_info结果集
	 * @param example
	 *            通用查询条件类
	 * @return List<UserGuardianInfo>user_guardian_info结果集
	 */
	private List<UserGuardianInfo> selectByExample(Criteria example) {
		return this.userGuardianInfoMapper.selectByExample(example);
	}

	/**
	 * @Title UserGuardianInfoDao.deleteByPrimaryKey
	 * @Description: 根据属性名称，删除user_guardian_info
	 * @param id
	 *            id
	 * @return int 删除个数
	 */
	private int deleteByPrimaryKey(Integer id) {
		return this.userGuardianInfoMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title UserGuardianInfoDao.updateByPrimaryKeySelective
	 * @Description: 根据主键更新user_guardian_info部分字段
	 * @param record
	 *            要更新成为的UserGuardianInfo对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKeySelective(UserGuardianInfo record) {
		return this.userGuardianInfoMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title UserGuardianInfoDao.updateByPrimaryKey
	 * @Description: 根据主键更新user_guardian_info全部字段
	 * @param record
	 *            要更新成为的UserGuardianInfo对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKey(UserGuardianInfo record) {
		return this.userGuardianInfoMapper.updateByPrimaryKey(record);
	}

	/**
	 * @Title UserGuardianInfoDao.deleteByExample
	 * @Description: 根据查询条件，删除user_guardian_info
	 * @param example
	 *            通用查询条件类
	 * @return int 删除个数
	 */
	private int deleteByExample(Criteria example) {
		return this.userGuardianInfoMapper.deleteByExample(example);
	}

	/**
	 * @Title UserGuardianInfoDao.updateByExampleSelective
	 * @Description: 根据查询条件更新user_guardian_info部分字段
	 * @param record
	 *            要更新成为的UserGuardianInfo对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExampleSelective(UserGuardianInfo record, Criteria example) {
		return this.userGuardianInfoMapper.updateByExampleSelective(record, example);
	}

	/**
	 * @Title UserGuardianInfoDao.updateByExample
	 * @Description: 根据查询条件更新user_guardian_info全表字段
	 * @param record
	 *            要更新成为的UserGuardianInfo对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExample(UserGuardianInfo record, Criteria example) {
		return this.userGuardianInfoMapper.updateByExample(record, example);
	}

	/**
	 * @Title UserGuardianInfoDao.insert
	 * @Description: 插入一个user_guardian_info
	 * @param record
	 *            user_guardian_info的bean对象
	 * @return int 插入个数
	 */
	private int insert(UserGuardianInfo record) {
		return this.userGuardianInfoMapper.insert(record);
	}

	/**
	 * @Title UserGuardianInfoDao.insertSelective
	 * @Description: 插入一个只有部分字段的user_guardian_info
	 * @param record
	 *            只含部分字段的user_guardian_info的bean对象
	 * @return int 插入个数
	 */
	private int insertSelective(UserGuardianInfo record) {
		return this.userGuardianInfoMapper.insertSelective(record);
	}

	/**
	 * 选择性保存用户的监护人信息
	 * 
	 * @param record
	 *            监护人信息
	 * @return 受影响的记录数
	 */
	public Integer save(UserGuardianInfo record) {
		return this.insertSelective(record);
	}

	/**
	 * 根据用户id查询出监护人信息
	 * 
	 * @param userId
	 *            用户id
	 * @return 监护人信息
	 */
	public List<UserGuardianInfo> queryUserGuardianInfoByUserId(Integer userId) {

		Criteria example = new Criteria();
		Condition condition = example.createConditon();
		condition.andEqualTo(TUserExtendedInfo.USER_ID, userId);
		return this.selectByExample(example);
	}
	/**
	 * 根据id更新监护人信息
	 * @param userGuardianInfo 监护人信息
	 * @return
	 */
	public Integer updateUserGuardianInfoById(UserGuardianInfo userGuardianInfo){
		return this.updateByPrimaryKeySelective(userGuardianInfo);
	}
}