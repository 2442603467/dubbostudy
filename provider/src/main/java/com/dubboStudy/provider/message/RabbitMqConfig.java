package com.dubboStudy.provider.message;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author by ydj
 * @Date 2019/2/27下午4:49
 **/
@Configuration
public class RabbitMqConfig {

    //创建一个消费队列
    @Bean
    public Queue immediateQueue(){
        //第一个字段是队列名，第二个是是否持久化
        return new Queue("immediate_queue_test1",true);
    }

    //创建直系的Exchange
    @Bean
    public DirectExchange immediateExchange(){
        //directExchange有3个构造器，durable 是否持久化，autoDelete 是否自动删除
        return new DirectExchange("immediate_exchange_direct",true,false);
    }

    //创建topic的交换器   有四种ExchangeType :direct、topic、headers、fanout
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("immediate_exchange_topic",true,false);
    }

    @Bean
    public Binding imediateExchange(){
        return BindingBuilder.bind(immediateQueue()).to(immediateExchange()).with("immediate_routing_key_test1");
    }

}
