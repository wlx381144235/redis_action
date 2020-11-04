package com.xizi.redis_action.redis.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *@author 夜尽
 *@date 2020年10月19日16:41:20
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CookieTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    
    /** 获取该token用户
     * @param token  token
     * @return String
     */
    public String checkToken(String token){
        return (String) redisTemplate.opsForHash().get("login",token);
    }
    
    /**更新token 并记录最新token 然后记录用户里浏览的商品，最多保存25个
     * @param userId userId
     * @param token token
     * @param productName 商品名
     */
    public void updateToken(String userId,String token,String productName){
        long time = System.currentTimeMillis();
        redisTemplate.opsForHash().put("login",token,userId);
        redisTemplate.opsForZSet().add("recent",token,time);
        redisTemplate.opsForZSet().add("viewed:" + token,productName,time);
        redisTemplate.opsForZSet().removeRange("viewed:" + token,0,-26);
    }

    @Test
    public void cleanSession(){
        
    }
}