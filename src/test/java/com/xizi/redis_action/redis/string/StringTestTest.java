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
    
    @Test
    public void testList(){
//        从左边插入数据 如果key不存在，则创建key的list
        redisTemplate.opsForList().leftPush("list","1");
        redisTemplate.opsForList().leftPush("list","2");
        redisTemplate.opsForList().leftPush("list","3");
        
//        从右边插入数据，如果key不存在，则创建key的list
        redisTemplate.opsForList().rightPush("list","3");
        redisTemplate.opsForList().rightPush("list","2");
        redisTemplate.opsForList().rightPush("list","1");
        
//        设置list中的下标为2的数据为“100”
        redisTemplate.opsForList().set("list",2,"100");
        
//        获取list中下标为2的数据
        System.out.println(redisTemplate.opsForList().index("list", 2));
        
//        从左边删除并返回数据
        System.out.println(redisTemplate.opsForList().leftPop("list"));
        
//        在规定时间内从左边删除并返回数据，时间结束返回null
        System.out.println(redisTemplate.opsForList().leftPop("list",Duration.ofSeconds(10)));
        
//        从左边插入数据，在“1”之前插入“100”
        redisTemplate.opsForList().leftPush("list","1","100");
        
//        从左边插入数据，如果key存在的话  不存在不执行
        redisTemplate.opsForList().leftPushIfPresent("list1","1");
        
//        获取key中的satrt-end的数据
//        redisTemplate.opsForList().range("list",0,2).forEach(System.out::println);

//        移除“2”前面的1哥数据（包括2）
        redisTemplate.opsForList().remove("list",1,"2");
        
//      将list修建至start-end的长度
        redisTemplate.opsForList().trim("list",0,3);
    }
}