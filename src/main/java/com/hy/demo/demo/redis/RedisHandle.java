package com.hy.demo.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RedisHandle {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public Set getKeys(String pattern){
        return stringRedisTemplate.keys(pattern);
    }

    public void addKey(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    public Object getValue(String key){
       return stringRedisTemplate.opsForValue().get(key);
    }

}
