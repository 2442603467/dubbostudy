package com.dubboStudy.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

/**
 * @Author by ydj
 * @Date 2019/3/4下午4:37
 **/
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping(value = "/kafka/send/{message}")
    public String send(@PathVariable("message") String message){
        kafkaTemplate.send("testTopic",message);
        return "success";
    }
}
