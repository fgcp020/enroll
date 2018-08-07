package com.nercel.enroll.controller.api.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nercel.enroll.controller.api.DegreeApplicationController;
import com.nercel.enroll.core.service.DegreeeApplicationService;
import com.nercel.enroll.domain.common.CustomeException;
import com.nercel.enroll.domain.common.Response;
import com.nercel.enroll.domain.common.Response.Statu;
import com.nercel.enroll.domain.vo.ApplyVo;

import io.swagger.annotations.ApiParam;

/**
 * DegreeApplicationController接口实现类
 * 
 * @author yishui
 * @date 2018年6月15日
 * @version 0.0.1
 */
@RestController
public class DegreeApplicationImplController implements DegreeApplicationController {

	private final static Logger LOG = LoggerFactory.getLogger(DegreeApplicationController.class);
	@Autowired
	private DegreeeApplicationService degreeeApplicationService;

	@Override
	public Response queryDegreeApplyInfo(
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token) {
		Response response = null;
		try {
			ApplyVo applyInfo = degreeeApplicationService.queryDegreeApplyInfo(token);
			response = new Response(applyInfo == null ? Statu.FAIL : Statu.OK,
					applyInfo == null ? "未查询到学位申请信息" : applyInfo, token);
		} catch (CustomeException e) {
			response = new Response(Statu.ERROR, e.getMessage(), token);
		}
		return response;
	}

	@Override
	public Response queryDegreeApplyInfomation(
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token) {
		Response response = null;
		try {
			List<ApplyVo> applyInfos = degreeeApplicationService.queryDegreeApplyInfomation(token);
			response = new Response((applyInfos == null || applyInfos.size() == 0) ? Statu.FAIL : Statu.OK,
					(applyInfos == null || applyInfos.size() == 0) ? "未查询到学位申请信息" : applyInfos, token);
		} catch (CustomeException e) {
			response = new Response(Statu.ERROR, e.getMessage(), token);
		}
		return response;
	}

	@Override
	public Response queryDegreeApplyInfo(HttpServletRequest request,
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token,
			@ApiParam(required = false, name = "schoolId", value = "学校id") @RequestParam(name = "schoolId", required = false) Integer schoolId,
			@ApiParam(required = false, name = "studentName", value = "学生姓名") @RequestParam(name = "studentName", required = false) String studentName,
			@ApiParam(required = false, name = "idCard", value = "学生身份证号") @RequestParam(name = "idCard", required = false) String idCard,
			@ApiParam(required = false, name = "applyStatu", value = "学生的录取状态") @RequestParam(name = "applyStatu", required = false) Integer applyStatu,
			@ApiParam(required = false, name = "schoolType", value = "学校类型,1小学，2中学") @RequestParam(name = "schoolType", required = false) Integer schoolType) {

		Response response = null;
		try {
			List<ApplyVo> applyInfos = degreeeApplicationService.queryDegreeApplyInfo(token, schoolId, studentName,
					idCard, applyStatu, schoolType);
			response = new Response((applyInfos == null || applyInfos.size() == 0) ? Statu.FAIL : Statu.OK,
					(applyInfos == null || applyInfos.size() == 0) ? "未查询到学位申请信息" : applyInfos, token);
		} catch (CustomeException e) {
			response = new Response(Statu.ERROR, e.getMessage(), token);
		}

		return response;
	}

	@Override
	public Response updateApplyStatus(
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token,
			@ApiParam(required = true, name = "applyId", value = "学位申请记录的id") @RequestParam(name = "applyId", required = true) Integer applyId,
			@ApiParam(required = true, name = "studentId", value = "学生记录的id") @RequestParam(name = "studentId", required = true) Integer studentId,
			@ApiParam(required = true, name = "applyStatus", value = "学位申请的状态,1审核通过、2审核失败、3驳回补充材料)") @RequestParam(name = "applyStatus", required = true) Integer applyStatus,
			@ApiParam(required = true, name = "approveOpinion", value = "审核意见") @RequestParam(name = "approveOpinion", required = true) String approveOpinion) {
		Response response = null;
		try {
			Boolean result = degreeeApplicationService.updateApplyStatus(token, studentId, applyId, applyStatus,
					approveOpinion);
			response = new Response(result ? Statu.OK : Statu.FAIL, result ? "信息更新成功" : "信息更新失败", token);
		} catch (CustomeException e) {
			response = new Response(Statu.ERROR, e.getMessage(), token);
		}
		return response;
	}

	@Override
	public Response queryUnassignedStudent(
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token,
			@ApiParam(required = true, name = "schoolType", value = "学校类型,1小学，2中学") @RequestParam(name = "schoolType", required = true) Integer schoolType,
			@ApiParam(required = false, name = "studentName", value = "学生姓名") @RequestParam(name = "studentName", required = false) String studentName,
			@ApiParam(required = false, name = "idCard", value = "学生身份证号") @RequestParam(name = "idCard", required = false) String idCard) {
		Response response = null;
		try {
			List<ApplyVo> applyInfos = degreeeApplicationService.queryUnassignedStudent(token, schoolType,
					studentName, idCard);
			response = new Response((applyInfos == null || applyInfos.size() == 0) ? Statu.FAIL : Statu.OK,
					(applyInfos == null || applyInfos.size() == 0) ? "未查询到学位申请信息" : applyInfos, token);
		} catch (CustomeException e) {
			response = new Response(Statu.ERROR, e.getMessage(), token);
		}
		return response;
	}

	@Override
	public Response updateApplySchool(
			@ApiParam(required = true, name = "token", value = "token信息") @RequestHeader(value = "token", required = true) String token,
			@ApiParam(required = true, name = "userId", value = "学生记录的Id") @RequestParam(name = "userId", required = true) Integer userId,
			@ApiParam(required = true, name = "schoolId", value = "学校的Id") @RequestParam(name = "schoolId", required = true) Integer schoolId,
			@ApiParam(required = true, name = "applyId", value = "申请记录的id") @RequestParam(name = "applyId", required = true) Integer applyId) {
		Response response = null;
		try {
			Boolean result = degreeeApplicationService.updateApplySchool(token, userId, schoolId, applyId);
			response = new Response(result ? Statu.OK : Statu.FAIL, result ? "信息更新成功" : "信息更新失败", token);
		} catch (CustomeException e) {
			response = new Response(Statu.ERROR, e.getMessage(), token);
		}
		return response;
	}

}
