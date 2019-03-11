package com.dubboStudy.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author by ydj
 * @Date 2019/3/4下午4:37
 **/
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @GetMapping(value = "/kafka/send/{message}")
    public String send(String message){
        kafkaTemplate.send("testTopic",message);
        return "success";
    }
}
