package com.xizi.redis_action.redis.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
/**
 *@author 夜尽
 *@date 2020/10/12 15:21
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringTestTest {
  
    @Autowired
    private StringTest stringTest;
    
    @Test
    public void addTest(){
        String a = "hello";
        String b = "world";
        stringTest.add(a,b);
    }
    
}