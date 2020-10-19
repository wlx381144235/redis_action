package com.xizi.redis_action.redis.string;

import com.xizi.redis_action.pojo.Article;
import com.xizi.redis_action.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.util.*;
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
    public static String getFullKey(String prefix,String id){
        return String.format(prefix,id);
    }
    
    /** 发送文章
     * @param article
     */
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
    
    /** 点赞文章
     * @param user
     * @param article
     */
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
    
    /** 分页获取文章
     * @param start
     * @param end
     * @return
     */
    public List<Map> getArticles(long start,long end){
        Set<String> set = redisTemplate.opsForZSet().reverseRange("score",start,end);
        List<Map> list = new ArrayList();
        set.forEach(e -> {
            Map<Object, Object> map = redisTemplate.opsForHash().entries(getFullKey(ARTICLE_PREFIX,e));
            list.add(map);
        });
        return list;
    }
    
    /** 将文章放入群组
     * @param group
     * @param articleId
     */
    public void addGroup(String group,String articleId){
        redisTemplate.opsForSet().add(group,articleId);
    }
    
    /** 获取某个组中的排行榜
     * @param group
     * @return
     */
    public Set<String> getGroupArticles(String group,long end){
        redisTemplate.opsForZSet().intersectAndStore(group,Arrays.asList("score"),group + "score", RedisZSetCommands.Aggregate.MAX);
        return redisTemplate.opsForZSet().reverseRange(group + "score",0,end);
    }
    
    @Test
    public void test(){
//        Article article = new Article("wz1","zz1");
        Article article2 = new Article("wz2","zz2");
        Article article3 = new Article("wz3","zz3");
        Article article4 = new Article("wz4","zz4");
        Article article5 = new Article("wz5","zz5");
//        pushArticle(article);
        pushArticle(article2);
        pushArticle(article3);
        pushArticle(article4);
        pushArticle(article5);
        addGroup("18x","wz2");
        addGroup("18x","wz3");
        addGroup("18x","wz1");
        addGroup("18x","wz4");
        addGroup("18x","wz5");
    
        System.out.println(getGroupArticles("18x",2));
    }
    
    @Test
    public void testVote(){
        Article article = new Article("wz1","zz1");
        User user = new User("yh1","yh1");
        vote(user,article);
    }

}