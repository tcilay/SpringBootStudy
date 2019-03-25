package com.hy.demo.demo.controller;


import com.hy.demo.demo.exception.AspectException;
import com.hy.demo.demo.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public String sayHello(String name) throws  AspectException{
        logger.info("request sayHello ......");
//        if(!"zsb".equals(name)) throw new AspectException("参数name不合法"+name);
        return helloService.sayHello(name);
    }
}
