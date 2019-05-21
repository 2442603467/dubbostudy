package com.dubboStudy.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author by ydj
 * @Date 2019/2/24下午5:22
 **/
@SpringBootApplication
@EnableDubboConfiguration
public class ProviderApplication extends SpringBootServletInitializer{

    @Bean
    public JedisPool getJedisPool(){
        JedisPool pool = new JedisPool("127.0.0.1",6379);
        return pool;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        System.setProperty("dubbo.application.logger","log4j");
        return builder.sources(ProviderApplication.class);
    }
//    public static void main(String[] args) {
//        SpringApplication.run(ProviderApplication.class,args);
//    }
}
