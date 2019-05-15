package com.basic.controller;

import com.basic.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 控制器
 * @Author: wisdomwang
 * @Date: 2019-05-13 16:52
 **/
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @Autowired
    private LoadBalancerClient  loadBalancerClient;

    @GetMapping(value = "/hi")
    public String hi(){
        return ribbonService.hiRibbonService();
    }

    @GetMapping(value = "/test")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        return serviceInstance.getHost()+"========"+serviceInstance.getPort();
    }
}
