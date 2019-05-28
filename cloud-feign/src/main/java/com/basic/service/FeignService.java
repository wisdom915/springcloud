package com.basic.service;

import com.basic.config.FeignConfig;
import com.basic.config.MyHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Author: wisdomwang
 * @Date: 2019-05-13 16:41
 **/
@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = MyHystrix.class )
public interface FeignService {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne();
}
