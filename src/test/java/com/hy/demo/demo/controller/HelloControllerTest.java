package com.hy.demo.demo.controller;

import com.hy.demo.demo.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HelloService helloService;

    @Test
    public void sayHello() throws Exception{
        given(this.helloService.sayHello("zsb")).willReturn("Hello spring zsb, use port : 8081");
        this.mvc.perform( get("/hello?name=zsb")
                    .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello spring zsb, use port : 8081"));
    }


}
