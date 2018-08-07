package com.nercel.enroll.domain.model.constants;

/**
 * @ClassName: TApplyInfo
* @Description: apply_info表结构对应的常量类，定义字段名常量
* @author: linyl linyuliang.85@gmail.com
 */
public final class TApplyInfo {
    /**
     * @Fields apply_info.ID: 
     */
    public static final String ID = "Id";

    /**
     * @Fields apply_info.APPLICANT: 申请人的id
     */
    public static final String APPLICANT = "applicant";

    /**
     * @Fields apply_info.APPLY_SCHOOL: 申请学校
     */
    public static final String APPLY_SCHOOL = "apply_school";

    /**
     * @Fields apply_info.APPLY_REASON: 申请原因(暂时保留)
     */
    public static final String APPLY_REASON = "apply_reason";

    /**
     * @Fields apply_info.APPLY_STATUS: 审核状态(0未审核、1审核通过、2审核失败、3驳回补充材料、4注册时户口信息不完整)
     */
    public static final String APPLY_STATUS = "apply_status";

    /**
     * @Fields apply_info.APPLY_TIME: 申请时间
     */
    public static final String APPLY_TIME = "apply_time";

    /**
     * @Fields apply_info.APPROVER: 审批人
     */
    public static final String APPROVER = "approver";

    /**
     * @Fields apply_info.APPROVE_TIME: 审批时间
     */
    public static final String APPROVE_TIME = "approve_time";

    /**
     * @Fields apply_info.APPROVE_OPINION: 审批意见
     */
    public static final String APPROVE_OPINION = "approve_opinion";

    /**
     * @Fields apply_info.STUDENT_NAME: 学生姓名（冗余字段，方便查询)
     */
    public static final String STUDENT_NAME = "student_name";

    /**
     * @Fields apply_info.IDCARD: 学生的身份证号(冗余字段，方便查询)
     */
    public static final String IDCARD = "idCard";

    /**
     * @Fields apply_info.STUDENT_TYPE: 学生类别(一二三类 、冗余字段，方便查询)
     */
    public static final String STUDENT_TYPE = "student_type";

    /**
     * @Fields apply_info.SCHOOL_TYPE: 学校类别(1小学，2中学，冗余字段，方便查询)
     */
    public static final String SCHOOL_TYPE = "school_type";

    /**
     * @Fields apply_info.APPLY_SCHOOL_NAME: 申请到的学校的名字(方便查询，冗余字段)
     */
    public static final String APPLY_SCHOOL_NAME = "apply_school_name";

    /**
     * @Fields apply_info.TOOLTIP: 申请结果提示信息
     */
    public static final String TOOLTIP = "tooltip";
}