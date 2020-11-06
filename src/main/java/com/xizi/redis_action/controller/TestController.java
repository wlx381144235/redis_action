package com.xizi.redis_action.controller;

import com.xizi.redis_action.pojo.Client;
import com.xizi.redis_action.pojo.ClientInside;
import com.xizi.redis_action.pojo.ClientSoftware;
import com.xizi.redis_action.pojo.ClientSoftwareInside;
import com.xizi.redis_action.service.*;
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
    
    @Resource
    private PostClientService postClientService;
    
    @Resource
    private PostClientInsideService postClientInsideService;
    
    @Resource
    private MyClientService myClientService;
    
    @Resource
    private MyClientInsideService myClientInsideService;
    
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
    
    @GetMapping("/restore2")
    public String restore2() throws ExecutionException, InterruptedException {
        List<Client> clientList = postClientService.list();
        List<Client> clientInsideList = postClientInsideService.list();
        ListUtil<Client, ClientInside> util = new ListUtil<>();
        Map<String,List<Client>> map = util.groupList(clientList);
        Map<String,List<ClientInside>> mapInside = util.insideGroupList(clientInsideList,ClientInside.class);
        for (List<Client> list :map.values()){
            myClientService.restoreFinal(list);
        }
        for (List<ClientInside> list :mapInside.values()){
            myClientInsideService.restoreFinal(list);
        }
        return "success";
    }
    
}
