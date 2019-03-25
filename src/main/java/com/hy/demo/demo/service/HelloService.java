package com.hy.demo.demo.service;

import com.hy.demo.demo.controller.HelloController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HelloService {

    private Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Value("${server.port}")
    private String port;

//    @Transactional
    public String sayHello(String name){
        return "Hello spring " + name+", use port : "+port;
    }

    public String doLogin(){
        return "Hello World";
    }
}
