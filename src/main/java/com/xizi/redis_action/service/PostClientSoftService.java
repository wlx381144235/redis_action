package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientSoftware;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author 夜尽
 * @date 2020/11/4 10:13
 */

public interface PostClientSoftService extends IService<ClientSoftware> {
    
    void restore(IPage<ClientSoftware> page);
    
    Future<List<ClientSoftware>> restoreFinal(IPage<ClientSoftware> page);
    
}
