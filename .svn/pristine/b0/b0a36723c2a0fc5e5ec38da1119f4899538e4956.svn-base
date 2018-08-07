package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: SmsCode
* @Description: sms_code表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class SmsCode extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields sms_code.Id :
     */
    private Integer id;

    /**
     * @Fields sms_code.phone :手机号码
     */
    private String phone;

    /**
     * @Fields sms_code.code :短信验证码
     */
    private String code;

    /**
     * @Fields sms_code.create_time :生成短信验证码的时间
     */
    private Long createTime;

    /**
     * @return sms_code.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of sms_code : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return sms_code.phone : 返回 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone of sms_code : 设置 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return sms_code.code : 返回 短信验证码
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code of sms_code : 设置 短信验证码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return sms_code.create_time : 返回 生成短信验证码的时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime of sms_code : 设置 生成短信验证码的时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

	public SmsCode(String phone, String code, Long createTime) {
		this.phone = phone;
		this.code = code;
		this.createTime = createTime;
	}

	public SmsCode() {
	
	}

	@Override
	public String toString() {
		return "SmsCode [id=" + id + ", phone=" + phone + ", code=" + code + ", createTime=" + createTime + "]";
	}
    
    
    
}