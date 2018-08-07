package com.nercel.enroll.controller.api.impl;

import java.text.ParseException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nercel.enroll.common.utils.JwtTokenProvider;
import com.nercel.enroll.controller.api.IndexController;
import com.nercel.enroll.core.service.UserSerice;
import com.nercel.enroll.domain.common.CustomeException;
import com.nercel.enroll.domain.common.Response;
import com.nercel.enroll.domain.common.UserClaims;
import com.nercel.enroll.domain.dto.UserDto;
import com.nercel.enroll.domain.common.Response.Statu;
import com.nercel.enroll.domain.model.beans.User;
import com.nercel.enroll.domain.vo.UserVo;

import io.swagger.annotations.ApiParam;

/**
 * IndexController接口实现类
 * 
 * @author yishui
 * @date 2018年6月15日
 * @version 0.0.1
 */
@RestController
public class IndexImplController implements IndexController {
	private final static Logger LOG = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private UserSerice userSerice;

	@Override
	public Response login(@RequestBody UserDto userDto) {
		Response response = null;
		if (userDto != null && StringUtils.isNotBlank(userDto.getIdCard())
				&& StringUtils.isNotBlank(userDto.getPwd())) {

			User u = userSerice.qeuryUserByCardOrName(new User(userDto.getPwd(), userDto.getIdCard()));
			String token = UUID.randomUUID().toString();
			if (u != null) {
				token = new JwtTokenProvider(JwtTokenProvider.DEFAULT_KEY).createToken(new UserClaims(u.getId()));
			}
			response = new Response(u == null ? Response.Statu.FAIL : Response.Statu.OK, u == null ? "用户名或密码不匹配" : u,
					u == null ? UUID.randomUUID().toString() : token);
		}

		return response;
	}

	@Override
	public Response register(HttpServletRequest request, @RequestBody UserVo userVo) {
		Response response = null;
		try {
			Boolean flag = userSerice.save(userVo);
			response = new Response(flag ? Response.Statu.OK : Response.Statu.FAIL, flag ? "注册成功" : "注册失败",
					UUID.randomUUID().toString());
		} catch (CustomeException e) {
			LOG.error(e.getMessage());
			response = new Response(Response.Statu.FAIL, e.getMessage(), UUID.randomUUID().toString());
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			response = new Response(Response.Statu.ERROR, "注册失败", UUID.randomUUID().toString());
		}
		return response;
	}

	@Override
	public Response update(HttpServletRequest request,
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token,
			@RequestBody UserVo userVo) {
		Response response = null;
		try {
			Boolean flag = userSerice.updateUserInfo(token, userVo);
			response = new Response(flag ? Response.Statu.OK : Response.Statu.FAIL, flag ? "更新用户信息成功" : "更新用户信息失败",
					token);
		} catch (CustomeException e) {
			response = new Response(Response.Statu.ERROR, e.getMessage(), token);
		}
		return response;
	}

	@Override
	public Response queryUserByToken(HttpServletRequest request,
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token) {
		String path = request.getSession().getServletContext().getRealPath("");
		Response response = null;
		try {
			UserVo userVo = userSerice.queryUserByToken(token, path);
			response = new Response(userVo == null ? Response.Statu.FAIL : Response.Statu.OK, userVo, token);
		} catch (CustomeException e) {
			response = new Response(Statu.ERROR, e.getMessage(), token);
		}

		return response;

	}

	@Override
	public Response queryStudentInfo(HttpServletRequest request,
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader String token,
			@ApiParam(required = true, name = "studentId", value = "学生的id") @RequestParam(name = "studentId", required = true) Integer studentId) {
		String path = request.getSession().getServletContext().getRealPath("");
		Response response = null;
		try {
			UserVo userVo = userSerice.queryStudentInfo(token, studentId, path);
			response = new Response(userVo == null ? Response.Statu.FAIL : Response.Statu.OK, userVo, token);
		} catch (CustomeException e) {
			response = new Response(Statu.ERROR, e.getMessage(), token);
		}
		return response;
	}

}
