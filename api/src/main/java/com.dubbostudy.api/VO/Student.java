package com.dubbostudy.api.VO;

import java.io.Serializable;

/**
 * @Author by ydj
 * @Date 2019/2/28下午4:50
 **/
public class Student implements Serializable{

    private static final long serializableID = 1L;
    private String name;
    private String age;
    private String id;
    private String sex;
    private String grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
