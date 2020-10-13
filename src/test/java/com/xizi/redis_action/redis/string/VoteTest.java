package com.xizi.redis_action.redis.string;

import com.xizi.redis_action.pojo.Article;
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
 *@date 2020年10月13日14:09:02
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class VoteTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    
    private static final int WEEK_TO_SECOND = 604800;
    
    private static final int VOTE_SCORE = 432;
    
    private static final String VOTED_PREFIX = "voted:%s";
    
    private static final String ARTICLE_PREFIX = "article:%s";
    
    public static String getFullKey(String prefix,Article article){
        return String.format(prefix,article.getArticleId());
    }
    
    public void pushArticle(Article article){
        redisTemplate.opsForSet().add(getFullKey(VOTED_PREFIX,article),article.getAuthor());
        redisTemplate.expire(getFullKey(VOTED_PREFIX,article),Duration.ofSeconds(WEEK_TO_SECOND));
        
        Map<String,String> map = new HashMap<>();
        map.put("articleId",article.getArticleId());
        map.put("autor",article.getAuthor());
        map.put("voted","0");
        redisTemplate.opsForHash().putAll(getFullKey(ARTICLE_PREFIX,article),map);
        
        long now = System.currentTimeMillis() / 1000;
        redisTemplate.opsForZSet().add("score",article.getArticleId(),now + VOTE_SCORE);
        
        redisTemplate.opsForZSet().add("time",article.getArticleId(),now);
    
    }
    
    public void vote(User user,Article article){
        long offsetTime = (System.currentTimeMillis() / 1000) - WEEK_TO_SECOND;
        if(redisTemplate.opsForZSet().score("time",article.getArticleId()) < offsetTime){
            return;
        }
        if(redisTemplate.opsForSet().add(getFullKey(VOTED_PREFIX,article),user.getUserId()) == 1){
            redisTemplate.opsForZSet().incrementScore("score", article.getArticleId(),VOTE_SCORE);
            redisTemplate.opsForHash().increment(getFullKey(ARTICLE_PREFIX,article),"voted",1);
        }
    }
    
    @Test
    public void test(){
        Article article = new Article("wz1","zz1");
        pushArticle(article);
    }
    
    @Test
    public void testVote(){
        Article article = new Article("wz1","zz1");
        User user = new User("yh1","yh1");
        vote(user,article);
    }

}