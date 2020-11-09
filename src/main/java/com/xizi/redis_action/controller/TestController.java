package com.xizi.redis_action.controller;

import com.xizi.redis_action.pojo.*;
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
    
    @Resource
    private PostClientAllService postClientAllService;
    
    @Resource
    private PostClientAllInsideService postClientAllInsideService;
    
    @Resource
    private MyClientAllService myClientAllService;
    
    @Resource
    private MyClientAllInsideService myClientAllInsideService;
    
    @Resource
    private PostClientOsService postClientOsService;
    
    @Resource
    private PostClientOsInsideService postClientOsInsideService;
    
    @Resource
    private MyClientOsService myClientOsService;
    
    @Resource
    private MyClientOsInsideService myClientOsInsideService;
    
    @Resource
    private PostClientNicService postClientNicService;
    
    @Resource
    private PostClientNicInsideService postClientNicInsideService;
    
    @Resource
    private MyClientNicService myClientNicService;
    
    @Resource
    private MyClientNicInsideService myClientNicInsideService;
    
    @Resource
    private PostClientNetworkAdapterService postClientNetworkAdapterService;
    
    @Resource
    private PostClientNetworkAdapterInsideService postClientNetworkAdapterInsideService;
    
    @Resource
    private MyClientNetworkAdapterService myClientNetworkAdapterService;
    
    @Resource
    private MyClientNetworkAdapterInsideService myClientNetworkAdapterInsideService;
    
    @Resource
    private PostClientHardwareChangelogService postClientHardwareChangelogService;
    
    @Resource
    private PostClientHardwareChangelogInsideService postClientHardwareChangelogInsideService;
    
    @Resource
    private MyClientHardwareChangelogService myClientHardwareChangelogService;
    
    @Resource
    private MyClientHardwareChangelogInsideService myClientHardwareChangelogInsideService;
    
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
    
    @GetMapping("/restore3")
    public String restore3() throws ExecutionException, InterruptedException {
        List<ClientAll> clientAllList = postClientAllService.list();
        List<ClientAll> clientAllInsideList = postClientAllInsideService.list();
        ListUtil<ClientAll, ClientAllInside> util = new ListUtil<>();
        Map<String,List<ClientAll>> map = util.groupList(clientAllList);
        Map<String,List<ClientAllInside>> mapInside = util.insideGroupList(clientAllInsideList,ClientAllInside.class);
        for (List<ClientAll> list :map.values()){
            myClientAllService.restoreFinal(list);
        }
        for (List<ClientAllInside> list :mapInside.values()){
            myClientAllInsideService.restoreFinal(list);
        }
        return "success";
    }
    
    @GetMapping("/restore4")
    public String restore4() throws ExecutionException, InterruptedException {
        List<ClientOs> clientOsList = postClientOsService.list();
        List<ClientOs> clientOsInsideList = postClientOsInsideService.list();
        ListUtil<ClientOs, ClientOsInside> util = new ListUtil<>();
        Map<String,List<ClientOs>> map = util.groupList(clientOsList);
        Map<String,List<ClientOsInside>> mapInside = util.insideGroupList(clientOsInsideList,ClientOsInside.class);
        for (List<ClientOs> list :map.values()){
            myClientOsService.restoreFinal(list);
        }
        for (List<ClientOsInside> list :mapInside.values()){
            myClientOsInsideService.restoreFinal(list);
        }
        return "success";
    }
    
    @GetMapping("/restore5")
    public String restore5() throws ExecutionException, InterruptedException {
        List<ClientNic> clientNicList = postClientNicService.list();
        List<ClientNic> clientNicInsideList = postClientNicInsideService.list();
        ListUtil<ClientNic, ClientNicInside> util = new ListUtil<>();
        Map<String,List<ClientNic>> map = util.groupList(clientNicList);
        Map<String,List<ClientNicInside>> mapInside = util.insideGroupList(clientNicInsideList,ClientNicInside.class);
        for (List<ClientNic> list :map.values()){
            myClientNicService.restoreFinal(list);
        }
        for (List<ClientNicInside> list :mapInside.values()){
            myClientNicInsideService.restoreFinal(list);
        }
        return "success";
    }
    
    @GetMapping("/restore6")
    public String restore6() throws ExecutionException, InterruptedException {
        List<ClientNetworkAdapters> clientNetworkAdaptersList = postClientNetworkAdapterService.list();
        List<ClientNetworkAdapters> clientNetworkAdaptersInsideList = postClientNetworkAdapterInsideService.list();
        ListUtil<ClientNetworkAdapters, ClientNetworkAdaptersInside> util = new ListUtil<>();
        Map<String,List<ClientNetworkAdapters>> map = util.groupList(clientNetworkAdaptersList);
        Map<String,List<ClientNetworkAdaptersInside>> mapInside = util.insideGroupList(clientNetworkAdaptersInsideList, ClientNetworkAdaptersInside.class);
        for (List<ClientNetworkAdapters> list :map.values()){
            myClientNetworkAdapterService.restoreFinal(list);
        }
        for (List<ClientNetworkAdaptersInside> list :mapInside.values()){
            myClientNetworkAdapterInsideService.restoreFinal(list);
        }
        return "success";
    }
    
    @GetMapping("/restore7")
    public String restore7() throws ExecutionException, InterruptedException {
        List<PostClientHardwareChangelog> clientHardwareChangelogList = postClientHardwareChangelogService.list();
        List<PostClientHardwareChangelog> clientHardwareChangelogInsideList = postClientHardwareChangelogInsideService.list();
        ListUtil<PostClientHardwareChangelog, ClientHardwareChangelog> util = new ListUtil<>();
        ListUtil<PostClientHardwareChangelog, ClientHardwareChangelogInside> insideUtil = new ListUtil<>();
        Map<String,List<ClientHardwareChangelog>> map = util.insideGroupList(clientHardwareChangelogList,ClientHardwareChangelog.class);
        Map<String,List<ClientHardwareChangelogInside>> mapInside = insideUtil.insideGroupList(clientHardwareChangelogInsideList, ClientHardwareChangelogInside.class);
        for (List<ClientHardwareChangelog> list :map.values()){
            myClientHardwareChangelogService.restoreFinal(list);
        }
        for (List<ClientHardwareChangelogInside> list :mapInside.values()){
            myClientHardwareChangelogInsideService.restoreFinal(list);
        }
        return "success";
    }
    
}
