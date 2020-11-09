package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientNetworkAdaptersInside;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020年11月6日09:40:01
 */

public interface MyClientNetworkAdapterInsideService extends IService<ClientNetworkAdaptersInside> {
    
    void restoreFinal(List<ClientNetworkAdaptersInside> list);
    
}
