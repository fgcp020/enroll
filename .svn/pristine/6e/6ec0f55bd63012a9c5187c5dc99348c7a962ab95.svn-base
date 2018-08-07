package com.nercel.enroll.core.service;

import java.util.List;

import com.nercel.enroll.domain.common.CustomeException;
import com.nercel.enroll.domain.vo.ApplyVo;

/**
 * 学位申请信息获取接口
 * 
 * @author Administrator
 * @date 2018年6月13日
 * @version 0.0.1
 *
 */
public interface DegreeeApplicationService {
	/**
	 * 根据token查询到学生的学位申请信息
	 * 
	 * @param token
	 *            请求token
	 * @return
	 * @throws CustomeException
	 */
	ApplyVo queryDegreeApplyInfo(String token) throws CustomeException;

	/**
	 * 教师角色根据token查询本校学生的录取情况
	 * 
	 * @param token
	 *            请求token
	 * @return
	 * @throws CustomeException
	 */
	List<ApplyVo> queryDegreeApplyInfomation(String token) throws CustomeException;

	/**
	 * 根据查询条件查询出学位申请信息
	 * 
	 * @param token
	 *            请求token
	 * @param schoolId
	 *            学校的ID
	 * @param studentName
	 *            学生的名字
	 * @param IdCard
	 *            学生的身份证号
	 * @param applyStatu
	 *            申请状态
	 * @param schoolType
	 *            学校类型
	 * @return
	 * @throws CustomeException
	 */
	List<ApplyVo> queryDegreeApplyInfo(String token, Integer schoolId, String studentName, String idCard,
			Integer applyStatu, Integer schoolType) throws CustomeException;

	/**
	 * 学校管理和教育局管理员对学位申请情况进行审核
	 * 
	 * @param token
	 *            请求token
	 * @param applyId
	 *            学位申请记录的id
	 * @param applyStatus
	 *            审批状态
	 * @param approve_opinion
	 *            审批意见
	 * @return
	 * @throws CustomeException
	 */

	Boolean updateApplyStatus(String token, Integer studentId, Integer applyId, Integer applyStatus,
			String approveOpinion) throws CustomeException;

	/**
	 * 教育局管理员根据请求token查询出未分配学位的学生
	 * 
	 * @param token
	 * @return
	 * @throws CustomeException
	 */
	List<ApplyVo> queryUnassignedStudent(String token, Integer schoolType) throws CustomeException;

	/**
	 * 根据条件查询出未分配的学生的信息
	 * 
	 * @param token
	 *            请求token
	 * @param schoolType
	 *            学校类型
	 * @param studentName
	 *            学生名字
	 * @param IdCard
	 *            学生的身份证号
	 * @return
	 * @throws CustomeException
	 */
	List<ApplyVo> queryUnassignedStudent(String token, Integer schoolType, String studentName, String idCard)
			throws CustomeException;

	/**
	 * 手动对学生进行学位分配
	 * 
	 * @param token
	 *            请求token
	 * @param userId
	 *            学生的id
	 * @param schoolId
	 *            学校的id
	 * @return
	 * @throws CustomeException
	 */
	Boolean updateApplySchool(String token, Integer userId, Integer schoolId, Integer applyId) throws CustomeException;
}
