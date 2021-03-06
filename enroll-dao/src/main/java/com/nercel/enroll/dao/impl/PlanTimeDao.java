package com.nercel.enroll.dao.impl;

import com.nercel.enroll.dao.mapperInterface.PlanTimeMapper;
import com.nercel.enroll.domain.model.beans.PlanTime;
import com.nercel.enroll.domain.mybatis.Criteria;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
/**
 * @ClassName: PlanTimeDao
 * @Description: plan_time表对应dao操作接口实现类
 * @author: linyl linyuliang.85@gmail.com
 */
@Repository
public class PlanTimeDao {
	/**
	 * @Fields LOGGER : 日志操作类
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanTimeDao.class);

	/**
	 * @Fields PlanTime表的Mybatis Mapper操作映射类
	 */
	@Resource
	private PlanTimeMapper planTimeMapper;

	/**
	 * @Title PlanTimeDao.countByExample
	 * @Description: 根据查询条件，计算plan_time个数
	 * @param example
	 *            通用查询条件类
	 * @return int 结果个数
	 */
	private int countByExample(Criteria example) {
		int count = this.planTimeMapper.countByExample(example);
		LOGGER.debug("count: {}", count);
		return count;
	}

	/**
	 * @Title PlanTimeDao.selectByPrimaryKey
	 * @Description: 根据主键类，返回plan_time
	 * @param id
	 *            id
	 * @return PlanTime bean对象
	 */
	private PlanTime selectByPrimaryKey(Integer id) {
		return this.planTimeMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Title PlanTimeDao.selectByExample
	 * @Description: 根据查询条件类，返回plan_time结果集
	 * @param example
	 *            通用查询条件类
	 * @return List<PlanTime>plan_time结果集
	 */
	private List<PlanTime> selectByExample(Criteria example) {
		return this.planTimeMapper.selectByExample(example);
	}

	/**
	 * @Title PlanTimeDao.deleteByPrimaryKey
	 * @Description: 根据属性名称，删除plan_time
	 * @param id
	 *            id
	 * @return int 删除个数
	 */
	private int deleteByPrimaryKey(Integer id) {
		return this.planTimeMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Title PlanTimeDao.updateByPrimaryKeySelective
	 * @Description: 根据主键更新plan_time部分字段
	 * @param record
	 *            要更新成为的PlanTime对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKeySelective(PlanTime record) {
		return this.planTimeMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * @Title PlanTimeDao.updateByPrimaryKey
	 * @Description: 根据主键更新plan_time全部字段
	 * @param record
	 *            要更新成为的PlanTime对象
	 * @return int 更新记录数
	 */
	private int updateByPrimaryKey(PlanTime record) {
		return this.planTimeMapper.updateByPrimaryKey(record);
	}

	/**
	 * @Title PlanTimeDao.deleteByExample
	 * @Description: 根据查询条件，删除plan_time
	 * @param example
	 *            通用查询条件类
	 * @return int 删除个数
	 */
	private int deleteByExample(Criteria example) {
		return this.planTimeMapper.deleteByExample(example);
	}

	/**
	 * @Title PlanTimeDao.updateByExampleSelective
	 * @Description: 根据查询条件更新plan_time部分字段
	 * @param record
	 *            要更新成为的PlanTime对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExampleSelective(PlanTime record, Criteria example) {
		return this.planTimeMapper.updateByExampleSelective(record, example);
	}

	/**
	 * @Title PlanTimeDao.updateByExample
	 * @Description: 根据查询条件更新plan_time全表字段
	 * @param record
	 *            要更新成为的PlanTime对象
	 * @param example
	 *            更新记录的查询条件
	 * @return int 更新记录数
	 */
	private int updateByExample(PlanTime record, Criteria example) {
		return this.planTimeMapper.updateByExample(record, example);
	}

	/**
	 * @Title PlanTimeDao.insert
	 * @Description: 插入一个plan_time
	 * @param record
	 *            plan_time的bean对象
	 * @return int 插入个数
	 */
	private int insert(PlanTime record) {
		return this.planTimeMapper.insert(record);
	}

	/**
	 * @Title PlanTimeDao.insertSelective
	 * @Description: 插入一个只有部分字段的plan_time
	 * @param record
	 *            只含部分字段的plan_time的bean对象
	 * @return int 插入个数
	 */
	private int insertSelective(PlanTime record) {
		return this.planTimeMapper.insertSelective(record);
	}

	/**
	 * 选择插入计划时间
	 * 
	 * @param planTime
	 *            计划时间
	 * @return
	 */
	public int savePlanTime(PlanTime planTime) {
		return this.insertSelective(planTime);
	}
	/**
	 * 查询出所有的计划时间
	 * @return
	 */
	public List<PlanTime> queryAllPlanTime(){
		return this.selectByExample(null);
	}

}