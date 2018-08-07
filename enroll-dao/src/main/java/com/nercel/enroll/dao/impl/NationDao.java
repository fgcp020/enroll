package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.NationMapper;
import com.nercel.enroll.domain.model.beans.Nation;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: NationDao
 * @Description: nation表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class NationDao {
	/**
	 * @Fields LOGGER : 日志操作类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(NationDao.class);

	/**
	 * @Fields Nation表的Mybatis Mapper操作映射类
	 */
	@Resource
	private NationMapper nationMapper;

	/**
	 * @Title NationDao.countByExample
	 * @Description: 根据查询条件，计算nation个数
	 * @param example
	 *            通用查询条件类
	 * @return int 结果个数
	 */
	private int countByExample(Criteria example) {
		int count = this.nationMapper.countByExample(example);
		LOGGER.debug("count: {}", count);
		return count;
	}

	/**
	 * @Title NationDao.selectByPrimaryKey
	 * @Description: 根据主键类，返回nation
	 * @param id
	 *            id
	 * @return Nation bean对象
	 */
	private Nation selectByPrimaryKey(Integer id) {
		return this.nationMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Title NationDao.selectByExample
	 * @Description: 根据查询条件类，返回nation结果集
	 * @param example
	 *            通用查询条件类
	 * @return List<Nation>nation结果集
	 */
	private List<Nation> selectByExample(Criteria example) {
		return this.nationMapper.selectByExample(example);
	}

	/**
	 * @Title NationDao.deleteByPrimaryKey
	 * @Description: 根据属性名称，删除nation
	 * @param id
	 *            id
	 * @return int 删除个数
	 */
	private int deleteByPrimaryKey(Integer id) {
		return this.nationMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title NationDao.updateByPrimaryKeySelective
	 * @Description: 根据主键更新nation部分字段
	 * @param record
	 *            要更新成为的Nation对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKeySelective(Nation record) {
		return this.nationMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title NationDao.updateByPrimaryKey
	 * @Description: 根据主键更新nation全部字段
	 * @param record
	 *            要更新成为的Nation对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKey(Nation record) {
		return this.nationMapper.updateByPrimaryKey(record);
	}

	/**
	 * @Title NationDao.deleteByExample
	 * @Description: 根据查询条件，删除nation
	 * @param example
	 *            通用查询条件类
	 * @return int 删除个数
	 */
	private int deleteByExample(Criteria example) {
		return this.nationMapper.deleteByExample(example);
	}

	/**
	 * @Title NationDao.updateByExampleSelective
	 * @Description: 根据查询条件更新nation部分字段
	 * @param record
	 *            要更新成为的Nation对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExampleSelective(Nation record, Criteria example) {
		return this.nationMapper.updateByExampleSelective(record, example);
	}

	/**
	 * @Title NationDao.updateByExample
	 * @Description: 根据查询条件更新nation全表字段
	 * @param record
	 *            要更新成为的Nation对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExample(Nation record, Criteria example) {
		return this.nationMapper.updateByExample(record, example);
	}

	/**
	 * @Title NationDao.insert
	 * @Description: 插入一个nation
	 * @param record
	 *            nation的bean对象
	 * @return int 插入个数
	 */
	private int insert(Nation record) {
		return this.nationMapper.insert(record);
	}

	/**
	 * @Title NationDao.insertSelective
	 * @Description: 插入一个只有部分字段的nation
	 * @param record
	 *            只含部分字段的nation的bean对象
	 * @return int 插入个数
	 */
	private int insertSelective(Nation record) {
		return this.nationMapper.insertSelective(record);
	}

	/**
	 * 根据id查询民族
	 * 
	 * @param id
	 *            民族的id
	 * @return 民族的信息
	 */
	public Nation queryNationById(Integer id) {
		return this.selectByPrimaryKey(id);
	}

	/**
	 * 查询出所有的民族信息
	 * 
	 * @return
	 */
	public List<Nation> queryAllNation() {
		return this.selectByExample(null);
	}
}