package com.nercel.enroll.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nercel.enroll.domain.common.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 学位相关的接口
 * @author yishui
 * @date 2018年7月2日
 * @version 0.0.1
 */
@RestController
@RequestMapping("/degree")
@Api(value = "学位相关的接口", tags = { "学生学位相关相关的处理接口" })
public interface DegreeController {
	/**
	 * 批量发送学位申请成功的短信
	 * 
	 * @param request
	 * @param response
	 * @param token
	 *            token信息
	 * @param studentIds
	 *            申请学生的id的集合
	 * @return
	 */
	@ApiOperation(value = "发送学位申请成功短信", notes = "批量发送学位申请成功短信")
	@PostMapping(value = "/sendConfirmSms")
	@ResponseBody
	public Response sendConfirmSms(HttpServletRequest request, HttpServletResponse response,
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader String token,
			@ApiParam(required = true, name = "studentIds", value = "申请学生的id的集合") @RequestBody(required = true) List<Integer> studentIds);
}
