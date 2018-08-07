package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: UserPhotoType
* @Description: user_photo_type表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class UserPhotoType extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields user_photo_type.Id :
     */
    private Integer id;

    /**
     * @Fields user_photo_type.content :照片类型
     */
    private String content;

    /**
     * @return user_photo_type.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of user_photo_type : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_photo_type.content : 返回 照片类型
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content of user_photo_type : 设置 照片类型
     */
    public void setContent(String content) {
        this.content = content;
    }
}