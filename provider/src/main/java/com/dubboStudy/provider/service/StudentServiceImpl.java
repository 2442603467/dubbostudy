package com.dubboStudy.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbostudy.api.VO.Student;
import com.dubbostudy.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author by ydj
 * @Date 2019/2/28下午4:41
 **/
@Component("studentServiceImpl")
@Service(version = "1.0.0",interfaceClass = StudentService.class,timeout = 1000)
public class StudentServiceImpl implements StudentService{

    @Autowired(required = true)
    private StringRedisTemplate stringRedisTemplate;

    @Autowired(required = true)
    private RedisTemplate redisTemplate;
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public void set(Student s) {
        redisTemplate.opsForValue().set(s.getId(),s);
    }

    public Student getStudent(String key) {
        return (Student) redisTemplate.opsForValue().get(key);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
