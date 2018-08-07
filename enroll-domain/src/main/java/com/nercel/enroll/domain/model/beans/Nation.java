package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: Nation
* @Description: nation表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class Nation extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields nation.Id :
     */
    private Integer id;

    /**
     * @Fields nation.code :民族编码
     */
    private String code;

    /**
     * @Fields nation.content :内容
     */
    private String content;

    /**
     * @return nation.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of nation : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return nation.code : 返回 民族编码
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code of nation : 设置 民族编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return nation.content : 返回 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content of nation : 设置 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

	@Override
	public String toString() {
		return "Nation [id=" + id + ", code=" + code + ", content=" + content + "]";
	}
    
    
}