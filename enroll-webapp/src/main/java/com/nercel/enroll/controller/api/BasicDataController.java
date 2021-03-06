package com.nercel.enroll.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nercel.enroll.domain.common.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 处理基础数据相关的流程
 * 
 * @author yishui
 * @date 2018年6月13日
 * @version 0.0.1
 */
@RestController
@RequestMapping("/basic")
@Api(value = "基础数据", tags = { "基础数据接口" })
public interface BasicDataController {
	/**
	 * 查询出所有的民族
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询出所有的民族", notes = "查询出所有的民族的接口")
	@GetMapping(value = "/nation")
	@ResponseBody
	Response queryAllNation();


	/**
	 * 查询出所有的国家
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询出所有的国家", notes = "查询出所有的国家的接口")
	@GetMapping(value = "/country")
	@ResponseBody
	Response queryALLCountry();

	/**
	 * 查询出所有的证件类型
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询出所有的证件类型", notes = "查询出所有的证件类型的接口")
	@GetMapping(value = "/certifatesType")
	@ResponseBody
	Response queryAllCertificatesType();

	/**
	 * 查询出所有的与学生的关系
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询出所有的与学生的关系", notes = "查询出所有的与学生的关系的接口")
	@GetMapping(value = "/relational")
	@ResponseBody
	Response queryAllRelational();

	/**
	 * 查询出所有的学校
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询出所有的学校", notes = "查询出所有的学校的接口")
	@GetMapping(value = "/school")
	@ResponseBody
	Response queryAllSchool();

	/**
	 * 查询出学校招收的街道
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询出所有的学校招收的街道", notes = "查询出所有的学校招收的街道的接口")
	@GetMapping(value = "/streetSchool")
	@ResponseBody
	Response queryAllStreetSchool();

	/**
	 * 查询出2018年小学毕业生学籍信息
	 * 
	 * @return
	 */
	@ApiOperation(value = "查询出2018年小学毕业生学籍信息", notes = "查询出2018年小学毕业生学籍信息的接口")
	@GetMapping(value = "/studentInfo")
	@ResponseBody
	Response queryAllStudentInfo();

	/**
	 * 根据学籍号查询小学毕业生信息
	 * 
	 * @return
	 */
	@ApiOperation(value = "根据学籍号查询小学毕业生信息", notes = "根据学籍号查询小学毕业生信息的接口")
	@GetMapping(value = "/studentNumber")
	@ResponseBody
	Response queryStudentInfo(@ApiParam(required = true, name = "studentNumber", value = "学生的学籍号") @RequestParam(name = "studentNumber") String studentNumber);

	/**
	 * 根据学校类型查询学校
	 * 
	 * @return
	 */
	@ApiOperation(value = "根据学校类型查询学校", notes = "根据学校类型查询学校的接口")
	@GetMapping(value = "/schoolType")
	@ResponseBody
	Response querySchoolByType(@ApiParam(required = true, name = "schoolType", value = "学校类型，1表示小学，2表示中学") @RequestParam(name = "schoolType") Integer schoolType);


}
