package com.basic.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: ribbon配置文件
 * @Author: wisdomwang
 * @Date: 2019-05-14 11:39
 **/
@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced //@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * @Author wisdomwang
     * @Description  更改ribbon默认负载均衡算法 默认轮询
     * @Date 2019/5/13 16:54
     **/
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

    /**
     * @Author wisdomwang
     * @Description  解决hystrix没有/actuator/hystrix.stream路径
     * @Date 2019/5/14 16:46
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
