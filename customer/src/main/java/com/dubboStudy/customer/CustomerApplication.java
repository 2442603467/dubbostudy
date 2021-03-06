package com.dubboStudy.customer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @Author by ydj
 * @Date 2019/2/24下午6:32
 **/
//@CrossOrigin
@SpringBootApplication
@EnableDubboConfiguration
public class CustomerApplication extends SpringBootServletInitializer{

//    public static void main(String[] args) {
//        SpringApplication.run(CustomerApplication.class,args);
//    }
@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(CustomerApplication.class);
    }
}
