package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientHardwareCpu;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020年11月6日09:38:54
 */

public interface MyClientHardwareCpuService extends IService<ClientHardwareCpu> {
    
    void restoreFinal(List<ClientHardwareCpu> list);
    
}
