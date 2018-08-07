package com.nercel.enroll.domain.vo;

import java.io.Serializable;
/**
 * 申请记录信息，方便前端使用
 * @author yishui
 * @date 2018年6月19日
 * @version 0.0.1
 */
public class ApplyVo implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields apply_info.Id :
     */
    private Integer id;

    /**
     * @Fields apply_info.applicant :申请人的id
     */
    private Integer applicant;

    /**
     * @Fields apply_info.apply_school :申请学校
     */
    private Integer applySchool;

    /**
     * @Fields apply_info.apply_reason :申请原因(暂时保留)
     */
    private String applyReason;

    /**
     * @Fields apply_info.apply_status :审核状态(0未审核、1审核通过、2审核失败、3驳回补充材料、4注册时户口信息不完整)
     */
    private Integer applyStatus;

    /**
     * @Fields apply_info.apply_time :申请时间
     */
    private Long applyTime;

    /**
     * @Fields apply_info.approver :审批人
     */
    private Integer approver;
    /**
     * 审批人的姓名
     */
    private String approverName;

    /**
     * @Fields apply_info.approve_time :审批时间
     */
    private Long approveTime;

    /**
     * @Fields apply_info.approve_opinion :审批意见
     */
    private String approveOpinion;

    /**
     * @Fields apply_info.student_name :学生姓名（冗余字段，方便查询)
     */
    private String studentName;

    /**
     * @Fields apply_info.idCard :学生的身份证号(冗余字段，方便查询)
     */
    private String idcard;

    /**
     * @Fields apply_info.student_type :学生类别(一二三类 、冗余字段，方便查询)
     */
    private Integer studentType;

    /**
     * @Fields apply_info.school_type :学校类别(1小学，2中学，冗余字段，方便查询)
     */
    private Integer schoolType;

    /**
     * @Fields apply_info.apply_school_name :申请到的学校的名字(方便查询，冗余字段)
     */
    private String applySchoolName;

    /**
     * @Fields apply_info.tooltip :申请结果提示信息
     */
    private String tooltip;

    /**
     * @return apply_info.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of apply_info : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return apply_info.applicant : 返回 申请人的id
     */
    public Integer getApplicant() {
        return applicant;
    }

    /**
     * @param applicant of apply_info : 设置 申请人的id
     */
    public void setApplicant(Integer applicant) {
        this.applicant = applicant;
    }

    /**
     * @return apply_info.apply_school : 返回 申请学校
     */
    public Integer getApplySchool() {
        return applySchool;
    }

    /**
     * @param applySchool of apply_info : 设置 申请学校
     */
    public void setApplySchool(Integer applySchool) {
        this.applySchool = applySchool;
    }

    /**
     * @return apply_info.apply_reason : 返回 申请原因(暂时保留)
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * @param applyReason of apply_info : 设置 申请原因(暂时保留)
     */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    /**
     * @return apply_info.apply_status : 返回 审核状态(0未审核、1审核通过、2审核失败、3驳回补充材料、4注册时户口信息不完整)
     */
    public Integer getApplyStatus() {
        return applyStatus;
    }

    /**
     * @param applyStatus of apply_info : 设置 审核状态(0未审核、1审核通过、2审核失败、3驳回补充材料、4注册时户口信息不完整)
     */
    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    /**
     * @return apply_info.apply_time : 返回 申请时间
     */
    public Long getApplyTime() {
        return applyTime;
    }

    /**
     * @param applyTime of apply_info : 设置 申请时间
     */
    public void setApplyTime(Long applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * @return apply_info.approver : 返回 审批人
     */
    public Integer getApprover() {
        return approver;
    }

    /**
     * @param approver of apply_info : 设置 审批人
     */
    public void setApprover(Integer approver) {
        this.approver = approver;
    }

    /**
     * @return apply_info.approve_time : 返回 审批时间
     */
    public Long getApproveTime() {
        return approveTime;
    }

    /**
     * @param approveTime of apply_info : 设置 审批时间
     */
    public void setApproveTime(Long approveTime) {
        this.approveTime = approveTime;
    }

    /**
     * @return apply_info.approve_opinion : 返回 审批意见
     */
    public String getApproveOpinion() {
        return approveOpinion;
    }

    /**
     * @param approveOpinion of apply_info : 设置 审批意见
     */
    public void setApproveOpinion(String approveOpinion) {
        this.approveOpinion = approveOpinion;
    }

    /**
     * @return apply_info.student_name : 返回 学生姓名（冗余字段，方便查询)
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName of apply_info : 设置 学生姓名（冗余字段，方便查询)
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return apply_info.idCard : 返回 学生的身份证号(冗余字段，方便查询)
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * @param idcard of apply_info : 设置 学生的身份证号(冗余字段，方便查询)
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * @return apply_info.student_type : 返回 学生类别(一二三类 、冗余字段，方便查询)
     */
    public Integer getStudentType() {
        return studentType;
    }

    /**
     * @param studentType of apply_info : 设置 学生类别(一二三类 、冗余字段，方便查询)
     */
    public void setStudentType(Integer studentType) {
        this.studentType = studentType;
    }

    /**
     * @return apply_info.school_type : 返回 学校类别(1小学，2中学，冗余字段，方便查询)
     */
    public Integer getSchoolType() {
        return schoolType;
    }

    /**
     * @param schoolType of apply_info : 设置 学校类别(1小学，2中学，冗余字段，方便查询)
     */
    public void setSchoolType(Integer schoolType) {
        this.schoolType = schoolType;
    }

    /**
     * @return apply_info.apply_school_name : 返回 申请到的学校的名字(方便查询，冗余字段)
     */
    public String getApplySchoolName() {
        return applySchoolName;
    }

    /**
     * @param applySchoolName of apply_info : 设置 申请到的学校的名字(方便查询，冗余字段)
     */
    public void setApplySchoolName(String applySchoolName) {
        this.applySchoolName = applySchoolName;
    }

    /**
     * @return apply_info.tooltip : 返回 申请结果提示信息
     */
    public String getTooltip() {
        return tooltip;
    }

    public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	/**
     * @param tooltip of apply_info : 设置 申请结果提示信息
     */
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

}
