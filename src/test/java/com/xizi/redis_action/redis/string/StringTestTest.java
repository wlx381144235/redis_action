package com.xizi.redis_action.redis.string;

import com.xizi.redis_action.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
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
    
    @Test
    public void testHash(){
//        向“hash”这个hash中存入数据
        redisTemplate.opsForHash().put("hash","age","10");
        
//        获取hash中key为"age"的值
        System.out.println(redisTemplate.opsForHash().get("hash", "age"));
        
//      删除
        redisTemplate.opsForHash().delete("hash","age");
        
//        获取hash中的键值对集合
        System.out.println(redisTemplate.opsForHash().entries("hash"));
        
//      判断hash中是否包含“name”这个key
        System.out.println(redisTemplate.opsForHash().hasKey("hash","name"));
        
//      对hash中某个key的value进行增加操作
        redisTemplate.opsForHash().increment("hash","age",1);
        
//      同上 增加的double值
        redisTemplate.opsForHash().increment("hash","age",Double.parseDouble("1.45"));
        
//        获取hash中的所有key集合
        System.out.println(redisTemplate.opsForHash().keys("hash"));
        
//        获取hash中某个key的value的长度
        System.out.println(redisTemplate.opsForHash().lengthOfValue("hash", "name"));
        
//      批量获取
        System.out.println(redisTemplate.opsForHash().multiGet("hash", Arrays.asList("name", "age")));
        
//      获取hash中的所有value集合
        System.out.println(redisTemplate.opsForHash().values("hash"));
        
//      获取hash中的键值对数量
        System.out.println(redisTemplate.opsForHash().size("hash"));
        
//      用来代替keys命令，虽然总体时间增加，但是不会阻塞redis。支持正则（match key的正则表达式） 分批次（count 每次扫描的记录数）
        System.out.println(redisTemplate.opsForHash().scan("hash", ScanOptions.scanOptions().count(1).match("*").build()).next());
    }
    
    
    @Test
    public void testset(){
        redisTemplate.opsForSet().add("myset","a","b","c");

//        返回第一个set和其他set的差集（即myset2有而myset没有的集合）
        System.out.println(redisTemplate.opsForSet().difference(Arrays.asList("myset2", "myset")));

//        将myset和myset2的差集保存在一个新的set myset3中。
        redisTemplate.opsForSet().differenceAndStore(Arrays.asList("myset","myset2"),"myset3");

//        在myset中随机获取2个元素返回为集合
        System.out.println(redisTemplate.opsForSet().distinctRandomMembers("myset", 2));

//        返回myset和myset3的交集
        System.out.println(redisTemplate.opsForSet().intersect(Arrays.asList("myset", "myset3")));

//        判断某元素是否在myset中
        System.out.println(redisTemplate.opsForSet().isMember("myset", "a"));

//        获取myset中的所有元素
        System.out.println(redisTemplate.opsForSet().members("myset"));

//        将myset中的“a”移到myset2
        redisTemplate.opsForSet().move("myset","a","myset2");

//        随机删除myset2中的一个元素并返回
        redisTemplate.opsForSet().pop("myset2");
    
//        随机删除myset2中的2个元素并返回list
        redisTemplate.opsForSet().pop("myset2",2);

//        随机获取myset2中的一个元素 randomMembers函数就是返回多个了
        redisTemplate.opsForSet().randomMember("myset2");

//        删除myset2中的指定元素
        redisTemplate.opsForSet().remove("myset2","a");

//        返回两个set的并集。
        System.out.println(redisTemplate.opsForSet().union("myset", "myset2"));

//        两个set并集并保存。
        redisTemplate.opsForSet().unionAndStore("myset","myset2","myset4");
    }
}