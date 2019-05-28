package com.basic.config;

import com.netflix.loadbalancer.ILoadBalancer;
import feign.Client;
import feign.Feign;
import feign.Retryer;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.openfeign.ribbon.LoadBalancerFeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Description: feign配置文件
 * @Author: wisdomwang
 * @Date: 2019-05-14 14:09
 **/
@ConditionalOnClass({ILoadBalancer.class, Feign.class})
@AutoConfigureBefore(FeignAutoConfiguration.class)
@Configuration
public class FeignConfig {

    /**
     * @Author wisdomwang
     * @Description  Feign在远程调用失败会进行重试
     * @Date 2019/5/14 14:35
     */
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }

    /**
     * @Author wisdomwang
     * @Description feign使用HttpClient和OKHttp实现网络请求  Client.Default默认使用HttpURLConnection实现网络请求
     * @Date 2019/5/14 14:34
     */
    @Bean
    @ConditionalOnMissingBean
    public Client feignClient(CachingSpringLoadBalancerFactory cachingFactory, SpringClientFactory clientFactory){
        return new LoadBalancerFeignClient(new Client.Default(null,null),cachingFactory,clientFactory);
    }
}
