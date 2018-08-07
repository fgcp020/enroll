package com.nercel.enroll.domain.vo;

import java.io.Serializable;

import com.nercel.enroll.domain.model.beans.ApplyInfo;
import com.nercel.enroll.domain.model.beans.School;
import com.nercel.enroll.domain.model.beans.User;
/**
 * 学位申请信息Vo类
 * @author yishui
 * @date 2018年7月2日
 * @version 0.0.1
 */
public class ApplyInfoVo implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = -7856129104215104501L;
    
    /**
     * 学位申请基本信息
     */
    private ApplyInfo applyInfo;
    
    /**
     * 申请学生的信息
     */
    private User student;
    /**
     * 审核老师的信息
     */
    private User approver;
    
    /**
     * 学校信息
     */
    private School school;

	public ApplyInfo getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(ApplyInfo applyInfo) {
		this.applyInfo = applyInfo;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public User getApprover() {
		return approver;
	}

	public void setApprover(User approver) {
		this.approver = approver;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public ApplyInfoVo(ApplyInfo applyInfo, User student, User approver, School school) {
		this.applyInfo = applyInfo;
		this.student = student;
		this.approver = approver;
		this.school = school;
	}

	public ApplyInfoVo(ApplyInfo applyInfo, User approver) {
		this.applyInfo = applyInfo;
		this.approver = approver;
	}

	public ApplyInfoVo() {
	
	}

	@Override
	public String toString() {
		return "ApplyInfoVo [applyInfo=" + applyInfo + ", student=" + student + ", approver=" + approver + ", school="
				+ school + "]";
	}

   
}
