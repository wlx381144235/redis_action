package com.xizi.redis_action.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xizi.redis_action.pojo.ClientSoftware;
import com.xizi.redis_action.service.MyClientSoftService;
import com.xizi.redis_action.service.PostClientSoftService;
import com.xizi.redis_action.util.ListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @author 夜尽
 * @date 2020/11/3 17:24
 */

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    
    @Resource
    private PostClientSoftService postClientSoftService;
    
    @Resource
    private MyClientSoftService myClientSoftService;
    
    @Resource
    private RedisTemplate<String,List<ClientSoftware>> redisTemplate;
    
        
    @GetMapping("/getall")
    public String getAll(){
        int count = postClientSoftService.count() + 1000;
        int pageNum = -1;
        IPage<ClientSoftware> page = new Page<>();
        for(int i = 0; i < count; i = i +1000) {
            page.setPages(pageNum + 1).setSize(1000);
            postClientSoftService.restore(page);
        }
        return "写入redis完成";
    }
    
    @GetMapping("/getmy")
    public String getmy(){
        long size = redisTemplate.opsForList().size("clientSoft");
        for(int i = 0; i < size; i++) {
            List<ClientSoftware> list = redisTemplate.opsForList().index("clientSoft",i);
            myClientSoftService.restore(list);
        }
        return "提交成功";
    }
    
    @GetMapping("/restore")
    public String restore() throws ExecutionException, InterruptedException {
        List<ClientSoftware> clientSoftwareList = postClientSoftService.list();
        Map<String,List<ClientSoftware>> map = ListUtil.groupList(clientSoftwareList);
        for (List<ClientSoftware> list :map.values()){
            myClientSoftService.restoreFinal(list);
        }
        return "success";
    }
    
}
