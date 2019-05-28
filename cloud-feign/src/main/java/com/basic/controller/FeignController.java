package com.basic.controller;

import com.basic.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 控制层
 * @Author: wisdomwang
 * @Date: 2019-05-13 16:42
 **/
@RestController
public class FeignController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    private FeignService feignService;

    @GetMapping(value = "/hi")
    public String sayHi() {
        return feignService.sayHiFromClientOne();
    }
}
