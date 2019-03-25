package com.hy.demo.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest

public class HelloServiceTests {

    @Autowired
    private HelloService helloService;

    @Test
    public void doLogin(){
        String result = helloService.doLogin();
        assertThat(result).isEqualTo("Hello World");
    }

}
