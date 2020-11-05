package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientSoftwareInside;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020/11/4 10:13
 */

public interface MyClientSoftInsideService extends IService<ClientSoftwareInside> {
    
    void restoreFinal(List<ClientSoftwareInside> list);
    
}
