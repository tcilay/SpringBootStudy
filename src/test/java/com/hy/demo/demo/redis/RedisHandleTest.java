package com.hy.demo.demo.redis;

import com.hy.demo.demo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class RedisHandleTest extends BaseTest {

    @Autowired
    private RedisHandle redisHandle;

    @Test
    public void add(){
        redisHandle.addKey("zsb","redis zsb");
    }

    @Test
    public void getKeys(){
        Set set = redisHandle.getKeys("*");
        set.stream().forEach(key->{
            System.out.println(key);
            System.out.println(redisHandle.getValue(key.toString()));
        });
    }
}
