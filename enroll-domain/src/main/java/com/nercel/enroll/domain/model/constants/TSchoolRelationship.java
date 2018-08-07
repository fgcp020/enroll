package com.nercel.enroll.domain.model.constants;

/**
 * @ClassName: TSchoolRelationship
* @Description: school_relationship表结构对应的常量类，定义字段名常量
* @author: linyl linyuliang.85@gmail.com
 */
public final class TSchoolRelationship {
    /**
     * @Fields school_relationship.ID: 
     */
    public static final String ID = "Id";

    /**
     * @Fields school_relationship.SOURCE_SCHOOL: 原始学校
     */
    public static final String SOURCE_SCHOOL = "source_school";

    /**
     * @Fields school_relationship.TARGET_SCHOOL: 目标学校
     */
    public static final String TARGET_SCHOOL = "target_school";

    /**
     * @Fields school_relationship.TYPE: 1小学初中对口、2初中学校后补
     */
    public static final String TYPE = "type";
}