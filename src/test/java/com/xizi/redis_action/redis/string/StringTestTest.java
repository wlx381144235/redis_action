package com.xizi.redis_action.redis.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/**
 *@author 夜尽
 *@date 2020/10/12 15:21
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringTestTest {
  
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    
    @Test
    public void TestString(){
        String a = "hello";
        String b = "world";
        String c = "123";
        String d = "456";
//        简单操作字符串，直接向redis中存入数据
        redisTemplate.opsForValue().set(a,b);
        
//        操作字符串，向redis中存入数据，同时对value进行偏移
        redisTemplate.opsForValue().set(a,b,3);
        
//        操作redis字符串，设置过期时间
        redisTemplate.opsForValue().set(a,b,15, TimeUnit.SECONDS);
        
//        操作redis字符串，设置过期时间
        redisTemplate.opsForValue().set(a,b, Duration.ofSeconds(10));
        
//        同理就可以理解setIfAbsent和setIfPresent
        redisTemplate.opsForValue().setIfAbsent(a,"1");
        redisTemplate.opsForValue().setIfPresent(a,"0");
        
//        获取v的长度
        System.out.println(redisTemplate.opsForValue().size(a));
        
//        给值增加字符
        redisTemplate.opsForValue().append(a,"+");
        
//        减少存储为字符串的整数值1
        redisTemplate.opsForValue().decrement(a);
        
//        减少存储为字符串的整数值 参数值 同理可理解increment,increment多一个函数返回Double值： Double increment(K key, double delta);
        redisTemplate.opsForValue().decrement(a,10);
        
//        这个就没啥好说了
        System.out.println(redisTemplate.opsForValue().get(a));
        
//        返回切割的字符串
        System.out.println(redisTemplate.opsForValue().get(a,2,2));
        
//        返回老值，写入新值
        System.out.println(redisTemplate.opsForValue().getAndSet(a, "100"));
        
//        批量获取key的值
        redisTemplate.opsForValue().multiGet(Arrays.asList(a,c)).forEach(System.out::println);
        
//        批量存储数据到redis
        Map<String,String> map = new HashMap<>();
        map.put(a,b);
        map.put(c,d);
        redisTemplate.opsForValue().multiSet(map);
    }
    
}