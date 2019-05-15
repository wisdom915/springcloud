package com.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient //@EnableDiscoveryClient向服务中心注册
@EnableHystrix
@EnableHystrixDashboard //开启dashboard熔断监控
public class ServiceRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run( ServiceRibbonApplication.class, args );
    }

}
