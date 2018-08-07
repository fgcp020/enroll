package com.nercel.enroll.domain.model.constants;

/**
 * @ClassName: TStreetSchool
* @Description: street_school表结构对应的常量类，定义字段名常量
* @author: linyl linyuliang.85@gmail.com
 */
public final class TStreetSchool {
    /**
     * @Fields street_school.ID: 
     */
    public static final String ID = "Id";

    /**
     * @Fields street_school.STREET: 街道的名字
     */
    public static final String STREET = "street";

    /**
     * @Fields street_school.SCHOOL_ID: 学校的id
     */
    public static final String SCHOOL_ID = "school_id";

    /**
     * @Fields street_school.SCHOOL_NAME: 学校名称
     */
    public static final String SCHOOL_NAME = "school_name";

    /**
     * @Fields street_school.SCHOOL_TYPE: 学校类型(冗余字段，1小学、2中学)
     */
    public static final String SCHOOL_TYPE = "school_type";
}