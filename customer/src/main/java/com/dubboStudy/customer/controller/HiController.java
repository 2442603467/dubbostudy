package com.dubboStudy.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbostudy.api.HiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author by ydj
 * @Date 2019/2/24下午9:03
 **/
@RestController
public class HiController {

    @Reference(version = "1.0.0")
    private HiService hiService;

    @GetMapping(value = "/dubbo/hi/{message}")
    public String sayHello(@PathVariable String message){
        String result = hiService.Hi(message);
        return result;
    }

    @GetMapping(value = "/dubbo/hhh")
    public String sayHhh(){
        return "jjjk";
    }
}
