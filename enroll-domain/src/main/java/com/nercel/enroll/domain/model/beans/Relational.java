package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: Relational
* @Description: relational表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class Relational extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields relational.Id :
     */
    private Integer id;

    /**
     * @Fields relational.code :关系编码
     */
    private String code;

    /**
     * @Fields relational.content :内容
     */
    private String content;

    /**
     * @return relational.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of relational : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return relational.code : 返回 关系编码
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code of relational : 设置 关系编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return relational.content : 返回 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content of relational : 设置 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}