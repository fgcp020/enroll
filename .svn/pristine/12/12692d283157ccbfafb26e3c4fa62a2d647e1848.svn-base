package com.nercel.enroll.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.nercel.enroll.domain.dto.PlanTimeDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 基础操作相关的接口
 * 
 * @author yishui
 * @date 2018年6月29日
 * @version 0.0.1
 */
@RestController
@RequestMapping("/basic")
@Api(value = "基础数据", tags = { "基础操作相关的接口" })
public interface BasicOperateController {

	/**
	 * 发送验证码
	 * 
	 * @param request
	 * @param phone
	 * @return
	 */
	@ApiOperation(value = "发送验证码", notes = "发送验证码")
	@PostMapping(value = "/sendSmsCode")
	@ResponseBody
	Response sendSmsCode(HttpServletRequest request,
			@ApiParam(required = true, name = "phone", value = "手机号") @RequestParam(value = "phone", required = true) String phone);

	/**
	 * 验证码校验
	 * 
	 * @param request
	 * @param phone
	 * @param smsCode
	 * @return
	 */
	@ApiOperation(value = "检验验证码是否正确", notes = "判断验证码是否正确")
	@GetMapping(value = "/querySmsCode")
	@ResponseBody
	Response querySmsCode(HttpServletRequest request,
			@ApiParam(required = true, name = "phone", value = "手机号") @RequestParam(value = "phone", required = true) String phone,
			@ApiParam(required = true, name = "smsCode", value = "验证码") @RequestParam(value = "smsCode", required = true) String smsCode);

	/**
	 * 保存计划时间
	 * 
	 * @param token
	 * @param planTimeDto
	 * @return
	 */
	@ApiOperation(value = "保存计划时间", notes = "管理员角色保存计划时间")
	@PostMapping(value = "/savePlanTime")
	@ResponseBody
	Response savePlanTime(
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token,

			@ApiParam(required = true, name = "planTimeDto", value = "时间参数") @RequestBody(required = true) PlanTimeDto planTimeDto);

	/**
	 * 系统管理员开启或关闭审核权限
	 * 
	 * @param token
	 * @param statu
	 * @return
	 */
	@ApiOperation(value = "开启/关闭审核和学校分配权限", notes = "系统开启/关闭审核和学校分配权限")
	@PutMapping(value = "/updateAuditStatu")
	@ResponseBody
	Response updateAuditStatu(
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token,
			@ApiParam(required = true, name = "status", value = "true表开启审核权限，false表示关闭") @RequestParam(name = "status", required = true) Boolean status);

	/**
	 * 查询开关的开启状态
	 * 
	 * @param token
	 *            用户token
	 * @return
	 */
	@ApiOperation(value = "系统管理员查询审核开光的状态", notes = "系统管理员查询审核开光的状态，true表示其他管理员角色可以审核")
	@GetMapping(value = "/queryAuditStatu")
	@ResponseBody
	Response queryAuditStatu(
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token);

	/**
	 * 查询计划时间
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "查询计划时间", notes = "查询系统的计划时间")
	@GetMapping(value = "/queryPlanTime")
	@ResponseBody
	Response queryPlanTime(HttpServletRequest request, HttpServletResponse response);

	/**
	 * 验证身份证号是否存在或年龄不正确
	 * 
	 * @param request
	 * @param response
	 * @param idCard
	 * @return
	 */
	@ApiOperation(value = "身份证号校验", notes = "验证身份证号是否存在或年龄不正确，该用户没有注册过且身份证号符合要求返回true，其他情况为false")
	@GetMapping(value = "/validateIdCard")
	@ResponseBody
	Response validateIdCard(HttpServletRequest request, HttpServletResponse response,
			@ApiParam(required = true, name = "idCard", value = "学生的身份证号") @RequestParam(name = "idCard", required = true) String idCard);

}
