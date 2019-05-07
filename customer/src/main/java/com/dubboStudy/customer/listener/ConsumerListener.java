package com.dubboStudy.customer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author by ydj
 * @Date 2019/3/4下午2:41
 **/
@Component
public class ConsumerListener {


    @KafkaListener(topics = {"testTopic"})
    public void listen(ConsumerRecord<?,?> record){

        System.out.println("1233333333333");
        System.out.println("*****************************=="+record.value());
        System.out.println(record.offset());
    }
}
