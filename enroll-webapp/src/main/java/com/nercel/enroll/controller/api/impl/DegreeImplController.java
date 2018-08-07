package com.nercel.enroll.controller.api.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.nercel.enroll.controller.api.DegreeController;
import com.nercel.enroll.core.service.SchoolDegreeService;
import com.nercel.enroll.domain.common.CustomeException;
import com.nercel.enroll.domain.common.Response;

import io.swagger.annotations.ApiParam;

/**
 * DegreeController 接口实现类
 * 
 * @author yishui
 * @date 2018年7月2日
 * @version 0.0.1
 */
@RestController
public class DegreeImplController implements DegreeController {
	@Autowired
	private SchoolDegreeService schoolDegreeService;

	@Override
	public Response sendConfirmSms(HttpServletRequest request, HttpServletResponse resp,
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader String token,
			@ApiParam(required = true, name = "studentIds", value = "申请学生的id的集合") @RequestBody(required = true) List<Integer> studentIds) {
		Response response = null;
		try {
			Integer[] result = schoolDegreeService.sendConfirmSms(token, studentIds);
			response = new Response(Response.Statu.OK,
					String.format("总共发送短信 %s条,启动成功了 %s 条,失败了 %s 条", result[0], result[1], result[2]), token);
		} catch (CustomeException e) {
			response = new Response(Response.Statu.ERROR, e.getMessage(), token);
		}
		return response;
	}

}
