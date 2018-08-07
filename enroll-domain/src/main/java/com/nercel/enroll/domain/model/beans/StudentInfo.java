package com.nercel.enroll.domain.model.beans;

import com.nercel.enroll.domain.common.BaseEntity;
import java.io.Serializable;

/**
 * @ClassName: StudentInfo
* @Description: student_info表对应的java bean类
* @author: linyl linyuliang.85@gmail.com
 */
public class StudentInfo extends BaseEntity implements Serializable {
    /**
     * @Fields serialVersionUID : 自动生成默认序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields student_info.Id :
     */
    private Integer id;

    /**
     * @Fields student_info.student_number :学籍号
     */
    private String studentNumber;

    /**
     * @Fields student_info.student_name :学生的名字
     */
    private String studentName;

    /**
     * @Fields student_info.school :毕业学校
     */
    private String school;

    /**
     * @return student_info.Id : 返回 
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id of student_info : 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return student_info.student_number : 返回 学籍号
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * @param studentNumber of student_info : 设置 学籍号
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * @return student_info.student_name : 返回 学生的名字
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName of student_info : 设置 学生的名字
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return student_info.school : 返回 毕业学校
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school of student_info : 设置 毕业学校
     */
    public void setSchool(String school) {
        this.school = school;
    }
}