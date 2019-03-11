package com.dubbostudy.api.service;

import com.dubbostudy.api.VO.Student;

/**
 * @Author by ydj
 * @Date 2019/2/28下午4:41
 **/
public interface StudentService {

    void set(String key,String value);
    void set(Student s);
    Student getStudent(String key);
    String get(String key);
}
