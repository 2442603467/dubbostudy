package com.dubboStudy.provider.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author by ydj
 * @Date 2019/3/4上午9:35
 **/
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sender(String message){
        kafkaTemplate.send("testTopic",message);

    }
}
