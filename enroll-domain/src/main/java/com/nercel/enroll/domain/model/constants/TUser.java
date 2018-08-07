package com.nercel.enroll.domain.model.constants;

/**
 * @ClassName: TUser
* @Description: user表结构对应的常量类，定义字段名常量
* @author: linyl linyuliang.85@gmail.com
 */
public final class TUser {
    /**
     * @Fields user.ID: 
     */
    public static final String ID = "Id";

    /**
     * @Fields user.USERNAME: 用户名
     */
    public static final String USERNAME = "username";

    /**
     * @Fields user.PWD: 密码
     */
    public static final String PWD = "pwd";

    /**
     * @Fields user.ID_CARD: 身份证号
     */
    public static final String ID_CARD = "id_card";

    /**
     * @Fields user.PHONE: 手机号
     */
    public static final String PHONE = "phone";

    /**
     * @Fields user.PERMANENT_ADDRESS: 户籍地址
     */
    public static final String PERMANENT_ADDRESS = "permanent_address";

    /**
     * @Fields user.TYPE: 学生类别(一类，二类，三类)
     */
    public static final String TYPE = "type";

    /**
     * @Fields user.APPLY_STATUS: 申请状态
     */
    public static final String APPLY_STATUS = "apply_status";

    /**
     * @Fields user.SEX: 性别（0女1男）
     */
    public static final String SEX = "sex";

    /**
     * @Fields user.ROLE: 学生的角色(1幼升小、2小升初、3学校、4教育局)
     */
    public static final String ROLE = "role";

    /**
     * @Fields user.CREATE_TIME: 申请时间
     */
    public static final String CREATE_TIME = "create_time";

    /**
     * @Fields user.SCHOOL_ID: 用户所属的学校(对于学生角色而言，该字段为空)
     */
    public static final String SCHOOL_ID = "school_id";
}