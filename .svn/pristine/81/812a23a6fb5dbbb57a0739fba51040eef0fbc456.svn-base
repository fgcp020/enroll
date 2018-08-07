package com.nercel.enroll.core.service;

import java.text.ParseException;
import com.nercel.enroll.domain.common.CustomeException;
import com.nercel.enroll.domain.model.beans.User;
import com.nercel.enroll.domain.vo.UserVo;

/**
 * 处理与用户相关的逻辑
 * 
 * @author yishui
 * @date 2018年6月13日
 * @version 0.0.1
 */
public interface UserSerice {
	/**
	 * 保存用户的信息
	 * 
	 * @param userVo
	 *            用户相关的所有信息
	 * @return true表示注册成功，
	 * @throws CustomeException
	 * @throws ParseException
	 */
	public Boolean save(UserVo userVo) throws CustomeException, ParseException;

	/**
	 * 根据用户名或密码查询出用户
	 * 
	 * @param user
	 *            查询用户的信息
	 * @return 登录成功则返回jwt-token
	 */
	public User qeuryUserByCardOrName(User user);

	/**
	 * 根据token获取用户的所有的信息
	 * 
	 * @param token
	 *            用户token
	 * @return 用户的所有的信息
	 * @throws CustomeException
	 */
	public UserVo queryUserByToken(String token,String path) throws CustomeException;

	/**
	 * 更新用户相关的信息
	 * 
	 * @param token
	 *            用户token
	 * @param userVo
	 *            相关的信息
	 * @throws CustomeException 
	 */
	public Boolean updateUserInfo(String token, UserVo userVo) throws CustomeException;
	
	public UserVo queryStudentInfo(String token,Integer studentId,String path) throws CustomeException;
}
