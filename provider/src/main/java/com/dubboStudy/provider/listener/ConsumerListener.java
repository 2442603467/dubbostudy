package com.dubboStudy.provider.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * @Author by ydj
 * @Date 2019/3/4下午2:41
 **/
public class ConsumerListener {

    @KafkaListener(topics = {"testTopic"})
    public void listen(ConsumerRecord<?,?> record){
        System.out.println("*****************************=="+record.value());
        System.out.println(record.offset());
    }
}
