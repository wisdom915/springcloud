package com.basic.config;

import com.basic.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @Description: 熔断器
 * @Author: wisdomwang
 * @Date: 2019-05-14 15:36
 **/
@Component
public class MyHystrix implements FeignService {

    @Override
    public String sayHiFromClientOne() {
        return "hi,兄弟 ，sorry,error!";
    }
}
