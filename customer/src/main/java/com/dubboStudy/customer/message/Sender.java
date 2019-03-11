package com.dubboStudy.customer.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author by ydj
 * @Date 2019/2/27下午5:04
 **/
@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message){
        System.out.println("message:"+message);
        rabbitTemplate.convertAndSend("immediate_exchange_direct","immediate_routing_key_test1",message);
    }
}
