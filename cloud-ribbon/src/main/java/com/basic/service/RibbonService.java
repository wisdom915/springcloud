package com.basic.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: 业务逻辑
 * @Author: wisdomwang
 * @Date: 2019-05-13 16:51
 **/
@Service
public class RibbonService {

    @Value("${server.port}")
    private String port;

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiRibbonService(){
        return restTemplate.getForObject("http://EUREKA-CLIENT/hi",String.class);
    }

    public String hiError() {
        return "hi,兄弟 ，sorry,error!";
    }

}
