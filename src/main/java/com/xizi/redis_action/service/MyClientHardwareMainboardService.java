package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientHardwareMainboard;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020年11月6日09:38:54
 */

public interface MyClientHardwareMainboardService extends IService<ClientHardwareMainboard> {
    
    void restoreFinal(List<ClientHardwareMainboard> list);
    
}
