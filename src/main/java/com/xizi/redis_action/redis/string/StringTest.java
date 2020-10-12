package com.xizi.redis_action.redis.string;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 夜尽
 * @date 2020/10/12 15:14
 */

@Component
public class StringTest {
    
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    
    public void add(String k,String v){
        redisTemplate.opsForValue().set(k,v);
//        redisTemplate.opsForValue().setIfAbsent(k,v);
//        redisTemplate.opsForValue().setIfPresent(k,v);
    }
    
}
