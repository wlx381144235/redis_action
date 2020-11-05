package com.xizi.redis_action.controller;

import com.xizi.redis_action.pojo.ClientSoftware;
import com.xizi.redis_action.pojo.ClientSoftwareInside;
import com.xizi.redis_action.service.MyClientSoftInsideService;
import com.xizi.redis_action.service.MyClientSoftService;
import com.xizi.redis_action.service.PostClientInsideSoftService;
import com.xizi.redis_action.service.PostClientSoftService;
import com.xizi.redis_action.util.ListUtil;
import lombok.extern.slf4j.Slf4j;
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
    private PostClientInsideSoftService postClientInsideSoftService;
    
    @Resource
    private MyClientSoftService myClientSoftService;
    
    @Resource
    private MyClientSoftInsideService myClientSoftInsideService;
    
    @GetMapping("/restore")
    public String restore() throws ExecutionException, InterruptedException {
        List<ClientSoftware> clientSoftwareList = postClientSoftService.list();
        List<ClientSoftware> clientSoftwareInsideList = postClientInsideSoftService.list();
        ListUtil<ClientSoftware,ClientSoftwareInside> util = new ListUtil<>();
        Map<String,List<ClientSoftware>> map = util.groupList(clientSoftwareList);
        Map<String,List<ClientSoftwareInside>> mapInside = util.insideGroupList(clientSoftwareInsideList,ClientSoftwareInside.class);
        for (List<ClientSoftware> list :map.values()){
            myClientSoftService.restoreFinal(list);
        }
        for (List<ClientSoftwareInside> list :mapInside.values()){
            myClientSoftInsideService.restoreFinal(list);
        }
        return "success";
    }
    
}
