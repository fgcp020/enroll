package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: Country
* @Description: country表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class Country extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields country.Id :
     */
    private Integer id;

    /**
     * @Fields country.code :国家编码
     */
    private String code;

    /**
     * @Fields country.content :国家名字
     */
    private String content;

    /**
     * @return country.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of country : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return country.code : 返回 国家编码
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code of country : 设置 国家编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return country.content : 返回 国家名字
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content of country : 设置 国家名字
     */
    public void setContent(String content) {
        this.content = content;
    }
}