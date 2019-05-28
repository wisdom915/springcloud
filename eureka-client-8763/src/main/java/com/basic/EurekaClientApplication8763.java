package com.basic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication8763 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication8763.class, args);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("hi")
    public String HiController(String foo){
        return "hi 我来自EurekaClient的 port "+port+"参数foo!!!  "+ foo;
    }

}
