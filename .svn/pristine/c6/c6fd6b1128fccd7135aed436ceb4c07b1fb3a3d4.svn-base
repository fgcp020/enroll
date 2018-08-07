package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.UserPhotoInfoMapper;
import com.nercel.enroll.domain.model.beans.UserPhotoInfo;
import com.nercel.enroll.domain.model.constants.TUserExtendedInfo;
import com.nercel.enroll.domain.mybatis.Criteria;
import com.nercel.enroll.domain.mybatis.Criteria.Condition;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserPhotoInfoDao
 * @Description: user_photo_info表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class UserPhotoInfoDao {
	/**
	 * @Fields LOGGER : 日志操作类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserPhotoInfoDao.class);

	/**
	 * @Fields UserPhotoInfo表的Mybatis Mapper操作映射类
	 */
	@Resource
	private UserPhotoInfoMapper userPhotoInfoMapper;

	/**
	 * @Title UserPhotoInfoDao.countByExample
	 * @Description: 根据查询条件，计算user_photo_info个数
	 * @param example
	 *            通用查询条件类
	 * @return int 结果个数
	 */
	private int countByExample(Criteria example) {
		int count = this.userPhotoInfoMapper.countByExample(example);
		LOGGER.debug("count: {}", count);
		return count;
	}

	/**
	 * @Title UserPhotoInfoDao.selectByPrimaryKey
	 * @Description: 根据主键类，返回user_photo_info
	 * @param id
	 *            id
	 * @return UserPhotoInfo bean对象
	 */
	private UserPhotoInfo selectByPrimaryKey(Integer id) {
		return this.userPhotoInfoMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Title UserPhotoInfoDao.selectByExample
	 * @Description: 根据查询条件类，返回user_photo_info结果集
	 * @param example
	 *            通用查询条件类
	 * @return List<UserPhotoInfo>user_photo_info结果集
	 */
	private List<UserPhotoInfo> selectByExample(Criteria example) {
		return this.userPhotoInfoMapper.selectByExample(example);
	}

	/**
	 * @Title UserPhotoInfoDao.deleteByPrimaryKey
	 * @Description: 根据属性名称，删除user_photo_info
	 * @param id
	 *            id
	 * @return int 删除个数
	 */
	private int deleteByPrimaryKey(Integer id) {
		return this.userPhotoInfoMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title UserPhotoInfoDao.updateByPrimaryKeySelective
	 * @Description: 根据主键更新user_photo_info部分字段
	 * @param record
	 *            要更新成为的UserPhotoInfo对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKeySelective(UserPhotoInfo record) {
		return this.userPhotoInfoMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title UserPhotoInfoDao.updateByPrimaryKey
	 * @Description: 根据主键更新user_photo_info全部字段
	 * @param record
	 *            要更新成为的UserPhotoInfo对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKey(UserPhotoInfo record) {
		return this.userPhotoInfoMapper.updateByPrimaryKey(record);
	}

	/**
	 * @Title UserPhotoInfoDao.deleteByExample
	 * @Description: 根据查询条件，删除user_photo_info
	 * @param example
	 *            通用查询条件类
	 * @return int 删除个数
	 */
	private int deleteByExample(Criteria example) {
		return this.userPhotoInfoMapper.deleteByExample(example);
	}

	/**
	 * @Title UserPhotoInfoDao.updateByExampleSelective
	 * @Description: 根据查询条件更新user_photo_info部分字段
	 * @param record
	 *            要更新成为的UserPhotoInfo对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExampleSelective(UserPhotoInfo record, Criteria example) {
		return this.userPhotoInfoMapper.updateByExampleSelective(record, example);
	}

	/**
	 * @Title UserPhotoInfoDao.updateByExample
	 * @Description: 根据查询条件更新user_photo_info全表字段
	 * @param record
	 *            要更新成为的UserPhotoInfo对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExample(UserPhotoInfo record, Criteria example) {
		return this.userPhotoInfoMapper.updateByExample(record, example);
	}

	/**
	 * @Title UserPhotoInfoDao.insert
	 * @Description: 插入一个user_photo_info
	 * @param record
	 *            user_photo_info的bean对象
	 * @return int 插入个数
	 */
	private int insert(UserPhotoInfo record) {
		return this.userPhotoInfoMapper.insert(record);
	}

	/**
	 * @Title UserPhotoInfoDao.insertSelective
	 * @Description: 插入一个只有部分字段的user_photo_info
	 * @param record
	 *            只含部分字段的user_photo_info的bean对象
	 * @return int 插入个数
	 */
	private int insertSelective(UserPhotoInfo record) {
		return this.userPhotoInfoMapper.insertSelective(record);
	}

	/**
	 * 选择性保存用户的照片信息
	 * 
	 * @param record
	 *            用户的照片信息
	 * @return 受影响的记录数
	 */
	public Integer save(UserPhotoInfo record) {
		return this.insertSelective(record);
	}

	/**
	 * 根据用户id查询照片信息
	 * 
	 * @param userId
	 *            用户id
	 * @return 照片信息
	 */
	public List<UserPhotoInfo> queryUserPhotoInfo(Integer userId) {
		Criteria example = new Criteria();
		Condition condition = example.createConditon();
		condition.andEqualTo(TUserExtendedInfo.USER_ID, userId);
		return this.selectByExample(example);

	}

	/**
	 * 根据id查询照片信息
	 * 
	 * @param id
	 *            记录id
	 * @return
	 */
	public UserPhotoInfo queryUserPhotoInfoById(Integer id) {
		return this.selectByPrimaryKey(id);
	}

	/**
	 * 根据id更新照片信息
	 * 
	 * @param userPhotoInfo
	 * @return
	 */
	public Integer updateUserPhotoInfoById(UserPhotoInfo userPhotoInfo) {
		return this.updateByPrimaryKeySelective(userPhotoInfo);
	}

}