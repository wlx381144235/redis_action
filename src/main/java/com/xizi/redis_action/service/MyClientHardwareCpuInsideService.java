package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientHardwareCpuInside;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020年11月6日09:40:01
 */

public interface MyClientHardwareCpuInsideService extends IService<ClientHardwareCpuInside> {
    
    void restoreFinal(List<ClientHardwareCpuInside> list);
    
}
