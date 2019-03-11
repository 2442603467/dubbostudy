package com.dubboStudy.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbostudy.api.VO.Student;
import com.dubbostudy.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author by ydj
 * @Date 2019/2/28下午5:06
 **/
@RestController
public class StudentController {

    @Reference(version = "1.0.0")
    private StudentService studentService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping(value = "/student/test")
    public String student(){
        studentService.set("myname", "aaaa");
        Student s = new Student();
        s.setId("001");
        s.setName("aaaa");
        s.setGrade("一年级");
        s.setAge("28");
        studentService.set(s);

        String name = studentService.get("myname");
        System.out.println("name:"+name);

        Student stu = studentService.getStudent("001");
        System.out.println(stu);
        return stu.toString();
    }

}
