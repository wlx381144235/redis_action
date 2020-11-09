package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientHardwareDisplaycardInside;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020年11月6日09:40:01
 */

public interface MyClientHardwareDisplaycardInsideService extends IService<ClientHardwareDisplaycardInside> {
    
    void restoreFinal(List<ClientHardwareDisplaycardInside> list);
    
}
