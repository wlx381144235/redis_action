package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientHardwareHarddisk;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020年11月6日09:38:54
 */

public interface MyClientHardwareHarddiskService extends IService<ClientHardwareHarddisk> {
    
    void restoreFinal(List<ClientHardwareHarddisk> list);
    
}
