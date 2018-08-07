package com.nercel.enroll.controller.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nercel.enroll.domain.common.Response;
import com.nercel.enroll.domain.dto.UserDto;
import com.nercel.enroll.domain.vo.UserVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 处理与用户相关的逻辑
 * 
 * @author yishui
 * @date 2018年6月13日
 * @version 0.0.1
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户信息相关的接口", tags = { "用户操作接口" })
public interface IndexController {
	/**
	 * 用户登录
	 * 
	 * @param user
	 *            用户信息
	 * @return
	 */
	@ApiOperation(value = "用户登录", notes = "用户登录时请求的接口")
	@PostMapping(value = "/login")
	@ResponseBody
	public Response login(@RequestBody UserDto userDto);

	/**
	 * 用户注册的接口
	 * 
	 * @param userVo
	 *            用户相关的所有信息
	 * @return
	 */
	@ApiOperation(value = "用户注册", notes = "用户用户注册时请求的接口")
	@PostMapping(value = "/register")
	@ResponseBody
	public Response register(HttpServletRequest request, @RequestBody UserVo userVo);

	/**
	 * 用户信息更新接口
	 * 
	 * @param userVo
	 *            用户相关的所有信息
	 * @return
	 */
	@ApiOperation(value = "用户信息更新", notes = "用户信息更新时请求的接口")
	@PutMapping(value = "/update")
	@ResponseBody
	public Response update(HttpServletRequest request,
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token,
			@RequestBody UserVo userVo);

	/**
	 * 根据token获取用户的全部信息
	 * 
	 * @param token
	 *            用户token
	 * @return
	 */
	@ApiOperation(value = "根据token获取用户的全部信息", notes = "根据token获取用户的全部信息的接口")
	@GetMapping(value = "/queryUserByToken")
	@ResponseBody
	public Response queryUserByToken(HttpServletRequest request,
			@ApiParam(required = true, name = "token", value = "token信息") @RequestParam String token);

	/**
	 * 根据学生的id查询出学生的全部个人信息
	 * @param request
	 * @param token  用户token
	 * @param studentId  学生的id
	 * @return
	 */
	@ApiOperation(value = "根据学生的id查询出学生的全部个人信息", notes = "用于管理根据学生的id查询出学生的全部个人信息")
	@GetMapping(value = "/queryStudentInfo")
	@ResponseBody
	public Response queryStudentInfo(HttpServletRequest request,
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader String token,
			@ApiParam(required = true, name = "studentId", value = "学生的id") @RequestParam(name = "studentId", required = true) Integer studentId);
}
