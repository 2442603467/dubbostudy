package com.dubboStudy.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.dubbostudy.api.service.HiService;
import org.springframework.stereotype.Component;

/**
 * @Author by ydj
 * @Date 2019/2/24下午5:23
 **/
@Service(version = "1.0.0",timeout = 1000,interfaceClass = HiService.class)
@Component("hiImpl")
public class HiImpl implements HiService{

    public String Hi(String message) {
        return message;
    }
}
