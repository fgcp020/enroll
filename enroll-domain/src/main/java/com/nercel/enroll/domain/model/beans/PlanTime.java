package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PlanTime
* @Description: plan_time表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class PlanTime extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields plan_time.Id :
     */
    private Integer id;

    /**
     * @Fields plan_time.register_start_time :注册开始时间
     */
    private Date registerStartTime;

    /**
     * @Fields plan_time.register_end_time :注册结束时间
     */
    private Date registerEndTime;

    /**
     * @Fields plan_time.apply_start_time :申请开始时间
     */
    private Date applyStartTime;

    /**
     * @Fields plan_time.apply_end_time :申请结束时间
     */
    private Date applyEndTime;

    /**
     * @Fields plan_time.school_check_start_time :学校开始审核的时间
     */
    private Date schoolCheckStartTime;

    /**
     * @Fields plan_time.school_check_end_time :学校审核结束时间
     */
    private Date schoolCheckEndTime;

    /**
     * @Fields plan_time.school_invest_start_time :学校面审材料并实地调查开始时间
     */
    private Date schoolInvestStartTime;

    /**
     * @Fields plan_time.school_invest_end_time :学校面审材料并实地调查结束时间
     */
    private Date schoolInvestEndTime;

    /**
     * @Fields plan_time.city_check_time_start_time :市局网审并实地调查开始时间
     */
    private Date cityCheckTimeStartTime;

    /**
     * @Fields plan_time.city_check_time_end_time :市局网审并实地调查结束时间
     */
    private Date cityCheckTimeEndTime;

    /**
     * @Fields plan_time.city_plan_start_time :市局统筹学位开始时间
     */
    private Date cityPlanStartTime;

    /**
     * @Fields plan_time.city_plan_end_time :市局统筹学位结束时间
     */
    private Date cityPlanEndTime;

    /**
     * @Fields plan_time.print_notice_start_time :打印入学通知书开始时间
     */
    private Date printNoticeStartTime;

    /**
     * @Fields plan_time.print_notice_end_time :打印入学通知书结束时间
     */
    private Date printNoticeEndTime;

    /**
     * @Fields plan_time.division_start_time :新生分班报名开始时间
     */
    private Date divisionStartTime;

    /**
     * @Fields plan_time.division_end_time :新生分班报名结束时间
     */
    private Date divisionEndTime;

    /**
     * @Fields plan_time.data_abutment_start_time :学籍数据对接开始时间
     */
    private Date dataAbutmentStartTime;

    /**
     * @Fields plan_time.data_abutment_end_time :学籍数据对接结束时间
     */
    private Date dataAbutmentEndTime;

    /**
     * @Fields plan_time.type :时间类型，为后期做准备
     */
    private Integer type;

    /**
     * @return plan_time.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of plan_time : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return plan_time.register_start_time : 返回 注册开始时间
     */
    public Date getRegisterStartTime() {
        return registerStartTime;
    }

    /**
     * @param registerStartTime of plan_time : 设置 注册开始时间
     */
    public void setRegisterStartTime(Date registerStartTime) {
        this.registerStartTime = registerStartTime;
    }

    /**
     * @return plan_time.register_end_time : 返回 注册结束时间
     */
    public Date getRegisterEndTime() {
        return registerEndTime;
    }

    /**
     * @param registerEndTime of plan_time : 设置 注册结束时间
     */
    public void setRegisterEndTime(Date registerEndTime) {
        this.registerEndTime = registerEndTime;
    }

    /**
     * @return plan_time.apply_start_time : 返回 申请开始时间
     */
    public Date getApplyStartTime() {
        return applyStartTime;
    }

    /**
     * @param applyStartTime of plan_time : 设置 申请开始时间
     */
    public void setApplyStartTime(Date applyStartTime) {
        this.applyStartTime = applyStartTime;
    }

    /**
     * @return plan_time.apply_end_time : 返回 申请结束时间
     */
    public Date getApplyEndTime() {
        return applyEndTime;
    }

    /**
     * @param applyEndTime of plan_time : 设置 申请结束时间
     */
    public void setApplyEndTime(Date applyEndTime) {
        this.applyEndTime = applyEndTime;
    }

    /**
     * @return plan_time.school_check_start_time : 返回 学校开始审核的时间
     */
    public Date getSchoolCheckStartTime() {
        return schoolCheckStartTime;
    }

    /**
     * @param schoolCheckStartTime of plan_time : 设置 学校开始审核的时间
     */
    public void setSchoolCheckStartTime(Date schoolCheckStartTime) {
        this.schoolCheckStartTime = schoolCheckStartTime;
    }

    /**
     * @return plan_time.school_check_end_time : 返回 学校审核结束时间
     */
    public Date getSchoolCheckEndTime() {
        return schoolCheckEndTime;
    }

    /**
     * @param schoolCheckEndTime of plan_time : 设置 学校审核结束时间
     */
    public void setSchoolCheckEndTime(Date schoolCheckEndTime) {
        this.schoolCheckEndTime = schoolCheckEndTime;
    }

    /**
     * @return plan_time.school_invest_start_time : 返回 学校面审材料并实地调查开始时间
     */
    public Date getSchoolInvestStartTime() {
        return schoolInvestStartTime;
    }

    /**
     * @param schoolInvestStartTime of plan_time : 设置 学校面审材料并实地调查开始时间
     */
    public void setSchoolInvestStartTime(Date schoolInvestStartTime) {
        this.schoolInvestStartTime = schoolInvestStartTime;
    }

    /**
     * @return plan_time.school_invest_end_time : 返回 学校面审材料并实地调查结束时间
     */
    public Date getSchoolInvestEndTime() {
        return schoolInvestEndTime;
    }

    /**
     * @param schoolInvestEndTime of plan_time : 设置 学校面审材料并实地调查结束时间
     */
    public void setSchoolInvestEndTime(Date schoolInvestEndTime) {
        this.schoolInvestEndTime = schoolInvestEndTime;
    }

    /**
     * @return plan_time.city_check_time_start_time : 返回 市局网审并实地调查开始时间
     */
    public Date getCityCheckTimeStartTime() {
        return cityCheckTimeStartTime;
    }

    /**
     * @param cityCheckTimeStartTime of plan_time : 设置 市局网审并实地调查开始时间
     */
    public void setCityCheckTimeStartTime(Date cityCheckTimeStartTime) {
        this.cityCheckTimeStartTime = cityCheckTimeStartTime;
    }

    /**
     * @return plan_time.city_check_time_end_time : 返回 市局网审并实地调查结束时间
     */
    public Date getCityCheckTimeEndTime() {
        return cityCheckTimeEndTime;
    }

    /**
     * @param cityCheckTimeEndTime of plan_time : 设置 市局网审并实地调查结束时间
     */
    public void setCityCheckTimeEndTime(Date cityCheckTimeEndTime) {
        this.cityCheckTimeEndTime = cityCheckTimeEndTime;
    }

    /**
     * @return plan_time.city_plan_start_time : 返回 市局统筹学位开始时间
     */
    public Date getCityPlanStartTime() {
        return cityPlanStartTime;
    }

    /**
     * @param cityPlanStartTime of plan_time : 设置 市局统筹学位开始时间
     */
    public void setCityPlanStartTime(Date cityPlanStartTime) {
        this.cityPlanStartTime = cityPlanStartTime;
    }

    /**
     * @return plan_time.city_plan_end_time : 返回 市局统筹学位结束时间
     */
    public Date getCityPlanEndTime() {
        return cityPlanEndTime;
    }

    /**
     * @param cityPlanEndTime of plan_time : 设置 市局统筹学位结束时间
     */
    public void setCityPlanEndTime(Date cityPlanEndTime) {
        this.cityPlanEndTime = cityPlanEndTime;
    }

    /**
     * @return plan_time.print_notice_start_time : 返回 打印入学通知书开始时间
     */
    public Date getPrintNoticeStartTime() {
        return printNoticeStartTime;
    }

    /**
     * @param printNoticeStartTime of plan_time : 设置 打印入学通知书开始时间
     */
    public void setPrintNoticeStartTime(Date printNoticeStartTime) {
        this.printNoticeStartTime = printNoticeStartTime;
    }

    /**
     * @return plan_time.print_notice_end_time : 返回 打印入学通知书结束时间
     */
    public Date getPrintNoticeEndTime() {
        return printNoticeEndTime;
    }

    /**
     * @param printNoticeEndTime of plan_time : 设置 打印入学通知书结束时间
     */
    public void setPrintNoticeEndTime(Date printNoticeEndTime) {
        this.printNoticeEndTime = printNoticeEndTime;
    }

    /**
     * @return plan_time.division_start_time : 返回 新生分班报名开始时间
     */
    public Date getDivisionStartTime() {
        return divisionStartTime;
    }

    /**
     * @param divisionStartTime of plan_time : 设置 新生分班报名开始时间
     */
    public void setDivisionStartTime(Date divisionStartTime) {
        this.divisionStartTime = divisionStartTime;
    }

    /**
     * @return plan_time.division_end_time : 返回 新生分班报名结束时间
     */
    public Date getDivisionEndTime() {
        return divisionEndTime;
    }

    /**
     * @param divisionEndTime of plan_time : 设置 新生分班报名结束时间
     */
    public void setDivisionEndTime(Date divisionEndTime) {
        this.divisionEndTime = divisionEndTime;
    }

    /**
     * @return plan_time.data_abutment_start_time : 返回 学籍数据对接开始时间
     */
    public Date getDataAbutmentStartTime() {
        return dataAbutmentStartTime;
    }

    /**
     * @param dataAbutmentStartTime of plan_time : 设置 学籍数据对接开始时间
     */
    public void setDataAbutmentStartTime(Date dataAbutmentStartTime) {
        this.dataAbutmentStartTime = dataAbutmentStartTime;
    }

    /**
     * @return plan_time.data_abutment_end_time : 返回 学籍数据对接结束时间
     */
    public Date getDataAbutmentEndTime() {
        return dataAbutmentEndTime;
    }

    /**
     * @param dataAbutmentEndTime of plan_time : 设置 学籍数据对接结束时间
     */
    public void setDataAbutmentEndTime(Date dataAbutmentEndTime) {
        this.dataAbutmentEndTime = dataAbutmentEndTime;
    }

    /**
     * @return plan_time.type : 返回 时间类型，为后期做准备
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type of plan_time : 设置 时间类型，为后期做准备
     */
    public void setType(Integer type) {
        this.type = type;
    }

	public PlanTime(Date registerStartTime, Date registerEndTime, Date applyStartTime, Date applyEndTime,
			Date schoolCheckStartTime, Date schoolCheckEndTime, Date schoolInvestStartTime, Date schoolInvestEndTime,
			Date cityCheckTimeStartTime, Date cityCheckTimeEndTime, Date cityPlanStartTime, Date cityPlanEndTime,
			Date printNoticeStartTime, Date printNoticeEndTime, Date divisionStartTime, Date divisionEndTime,
			Date dataAbutmentStartTime, Date dataAbutmentEndTime) {
		this.registerStartTime = registerStartTime;
		this.registerEndTime = registerEndTime;
		this.applyStartTime = applyStartTime;
		this.applyEndTime = applyEndTime;
		this.schoolCheckStartTime = schoolCheckStartTime;
		this.schoolCheckEndTime = schoolCheckEndTime;
		this.schoolInvestStartTime = schoolInvestStartTime;
		this.schoolInvestEndTime = schoolInvestEndTime;
		this.cityCheckTimeStartTime = cityCheckTimeStartTime;
		this.cityCheckTimeEndTime = cityCheckTimeEndTime;
		this.cityPlanStartTime = cityPlanStartTime;
		this.cityPlanEndTime = cityPlanEndTime;
		this.printNoticeStartTime = printNoticeStartTime;
		this.printNoticeEndTime = printNoticeEndTime;
		this.divisionStartTime = divisionStartTime;
		this.divisionEndTime = divisionEndTime;
		this.dataAbutmentStartTime = dataAbutmentStartTime;
		this.dataAbutmentEndTime = dataAbutmentEndTime;
	}

	@Override
	public String toString() {
		return "PlanTime [id=" + id + ", registerStartTime=" + registerStartTime + ", registerEndTime="
				+ registerEndTime + ", applyStartTime=" + applyStartTime + ", applyEndTime=" + applyEndTime
				+ ", schoolCheckStartTime=" + schoolCheckStartTime + ", schoolCheckEndTime=" + schoolCheckEndTime
				+ ", schoolInvestStartTime=" + schoolInvestStartTime + ", schoolInvestEndTime=" + schoolInvestEndTime
				+ ", cityCheckTimeStartTime=" + cityCheckTimeStartTime + ", cityCheckTimeEndTime="
				+ cityCheckTimeEndTime + ", cityPlanStartTime=" + cityPlanStartTime + ", cityPlanEndTime="
				+ cityPlanEndTime + ", printNoticeStartTime=" + printNoticeStartTime + ", printNoticeEndTime="
				+ printNoticeEndTime + ", divisionStartTime=" + divisionStartTime + ", divisionEndTime="
				+ divisionEndTime + ", dataAbutmentStartTime=" + dataAbutmentStartTime + ", dataAbutmentEndTime="
				+ dataAbutmentEndTime + ", type=" + type + "]";
	}

	public PlanTime() {
	
	}
    
    
}