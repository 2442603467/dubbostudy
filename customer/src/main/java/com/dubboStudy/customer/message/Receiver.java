package com.dubboStudy.customer.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author by ydj
 * @Date 2019/2/27下午5:15
 **/
@Component
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "immediate_queue_test1")
    public void process(String message){
        System.out.println("Receiver:"+message);
    }
}
