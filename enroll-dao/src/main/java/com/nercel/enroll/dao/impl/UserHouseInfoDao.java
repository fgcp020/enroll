package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.UserHouseInfoMapper;
import com.nercel.enroll.domain.model.beans.UserHouseInfo;
import com.nercel.enroll.domain.model.constants.TUserExtendedInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import com.nercel.enroll.domain.mybatis.Criteria.Condition;
 
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserHouseInfoDao
 * @Description: user_house_info表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class UserHouseInfoDao {
	/**
	 * @Fields LOGGER : 日志操作类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserHouseInfoDao.class);

	/**
	 * @Fields UserHouseInfo表的Mybatis Mapper操作映射类
	 */
	@Resource
	private UserHouseInfoMapper userHouseInfoMapper;

	/**
	 * @Title UserHouseInfoDao.countByExample
	 * @Description: 根据查询条件，计算user_house_info个数
	 * @param example
	 *            通用查询条件类
	 * @return int 结果个数
	 */
	private int countByExample(Criteria example) {
		int count = this.userHouseInfoMapper.countByExample(example);
		LOGGER.debug("count: {}", count);
		return count;
	}

	/**
	 * @Title UserHouseInfoDao.selectByPrimaryKey
	 * @Description: 根据主键类，返回user_house_info
	 * @param id
	 *            id
	 * @return UserHouseInfo bean对象
	 */
	private UserHouseInfo selectByPrimaryKey(Integer id) {
		return this.userHouseInfoMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Title UserHouseInfoDao.selectByExample
	 * @Description: 根据查询条件类，返回user_house_info结果集
	 * @param example
	 *            通用查询条件类
	 * @return List<UserHouseInfo>user_house_info结果集
	 */
	private List<UserHouseInfo> selectByExample(Criteria example) {
		return this.userHouseInfoMapper.selectByExample(example);
	}

	/**
	 * @Title UserHouseInfoDao.deleteByPrimaryKey
	 * @Description: 根据属性名称，删除user_house_info
	 * @param id
	 *            id
	 * @return int 删除个数
	 */
	private int deleteByPrimaryKey(Integer id) {
		return this.userHouseInfoMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title UserHouseInfoDao.updateByPrimaryKeySelective
	 * @Description: 根据主键更新user_house_info部分字段
	 * @param record
	 *            要更新成为的UserHouseInfo对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKeySelective(UserHouseInfo record) {
		return this.userHouseInfoMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title UserHouseInfoDao.updateByPrimaryKey
	 * @Description: 根据主键更新user_house_info全部字段
	 * @param record
	 *            要更新成为的UserHouseInfo对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKey(UserHouseInfo record) {
		return this.userHouseInfoMapper.updateByPrimaryKey(record);
	}

	/**
	 * @Title UserHouseInfoDao.deleteByExample
	 * @Description: 根据查询条件，删除user_house_info
	 * @param example
	 *            通用查询条件类
	 * @return int 删除个数
	 */
	private int deleteByExample(Criteria example) {
		return this.userHouseInfoMapper.deleteByExample(example);
	}

	/**
	 * @Title UserHouseInfoDao.updateByExampleSelective
	 * @Description: 根据查询条件更新user_house_info部分字段
	 * @param record
	 *            要更新成为的UserHouseInfo对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExampleSelective(UserHouseInfo record, Criteria example) {
		return this.userHouseInfoMapper.updateByExampleSelective(record, example);
	}

	/**
	 * @Title UserHouseInfoDao.updateByExample
	 * @Description: 根据查询条件更新user_house_info全表字段
	 * @param record
	 *            要更新成为的UserHouseInfo对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExample(UserHouseInfo record, Criteria example) {
		return this.userHouseInfoMapper.updateByExample(record, example);
	}

	/**
	 * @Title UserHouseInfoDao.insert
	 * @Description: 插入一个user_house_info
	 * @param record
	 *            user_house_info的bean对象
	 * @return int 插入个数
	 */
	private int insert(UserHouseInfo record) {
		return this.userHouseInfoMapper.insert(record);
	}

	/**
	 * @Title UserHouseInfoDao.insertSelective
	 * @Description: 插入一个只有部分字段的user_house_info
	 * @param record
	 *            只含部分字段的user_house_info的bean对象
	 * @return int 插入个数
	 */
	private int insertSelective(UserHouseInfo record) {
		return this.userHouseInfoMapper.insertSelective(record);
	}

	/**
	 * 选择性保存用户的房产信息
	 * 
	 * @param record
	 *            用户的房产信息
	 * @return 受影响的记录数
	 */
	public Integer save(UserHouseInfo record) {
		return this.insertSelective(record);
	}

	/**
	 * 根据用户id查询出房产信息
	 * 
	 * @param userId
	 *            用户id
	 * @return 房产信息
	 */
	public List<UserHouseInfo> queryUserHouseInfoByUserId(Integer userId) {

		Criteria example = new Criteria();
		Condition condition = example.createConditon();
		condition.andEqualTo(TUserExtendedInfo.USER_ID, userId);
		return this.selectByExample(example);

	}
	
	/**
	 * 根据id更新房产信息
	 * @param userHouseInfo
	 * @return
	 */
	public Integer updateUserHouseInfoById(UserHouseInfo userHouseInfo){
		return this.updateByPrimaryKeySelective(userHouseInfo);
	}
}