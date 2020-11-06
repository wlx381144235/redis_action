package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientNicInside;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020年11月6日09:40:01
 */

public interface MyClientNicInsideService extends IService<ClientNicInside> {
    
    void restoreFinal(List<ClientNicInside> list);
    
}
