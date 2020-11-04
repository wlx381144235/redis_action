package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.post.PostClientMapper;
import com.xizi.redis_action.pojo.ClientSoftware;
import com.xizi.redis_action.service.PostClientSoftService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author 夜尽
 * @date 2020/11/4 10:15
 */

@Service
@Slf4j
public class PostClientSoftServiceImpl extends ServiceImpl<PostClientMapper, ClientSoftware> implements PostClientSoftService {
    
    @Resource
    private RedisTemplate<String, List<ClientSoftware>> redisTemplate;
    
    @Override
    @Async("taskExecutor")
    public void restore(IPage<ClientSoftware> page) {
        log.info("当前list有{}个元素",this.page(page).getRecords().size());
        long result = redisTemplate.opsForList().leftPushAll("clientSoft",this.page(page).getRecords());
        log.info("存到redis中{}个元素",result);
    }
    
    @Override
    @Async("taskExecutor")
    public Future<List<ClientSoftware>> restoreFinal(IPage<ClientSoftware> page) {
        return AsyncResult.forValue(this.page(page).getRecords());
    }
}
