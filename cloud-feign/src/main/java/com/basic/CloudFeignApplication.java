package com.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //@EnableDiscoveryClient向服务中心注册
@EnableFeignClients //程序启动时会扫描带有@FeignClient注解的接口
public class CloudFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run( CloudFeignApplication.class, args );
    }

}
