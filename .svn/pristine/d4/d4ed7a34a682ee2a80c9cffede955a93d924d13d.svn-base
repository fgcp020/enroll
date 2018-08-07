package com.nercel.enroll.core.service;

import java.util.List;

import com.nercel.enroll.domain.common.CustomeException;
import com.nercel.enroll.domain.model.beans.User;
import com.nercel.enroll.domain.vo.UserVo;

/**
 * 学校学位分配逻辑
 * 
 * @author yishui
 * @date 2018年6月14日
 * @version 0.0.1
 */
public interface SchoolDegreeService {
	/**
	 * 保存学位申请信息
	 * 
	 * @param user
	 *            操作用户的基本信息
	 * @param userVo
	 *            操作用提交的信息
	 */
	public void saveSchoolDegree(User user, UserVo userVo);

	/**
	 * 更新学生的虚伪申请信息
	 * 
	 * @param user
	 *            操作用户的基本信息
	 * @param userVo
	 *            操作用提交的信息
	 */
	public void updateSchoolDegree(User user, UserVo userVo);

	/**
	 * 批量发送确认短信
	 * 
	 * @param token
	 *            用户的token
	 * @param studentIds
	 *            学生id的集合
	 * @return 数组，三个值分别为总共需要发送的短信的数据，发送成功的数量，发送失败的数量
	 * @throws CustomeException
	 */
	Integer[] sendConfirmSms(String token, List<Integer> studentIds) throws CustomeException;
}
