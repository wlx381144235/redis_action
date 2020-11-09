package com.xizi.redis_action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xizi.redis_action.pojo.ClientHardwareDisplaycard;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020年11月6日09:38:54
 */

public interface MyClientHardwareDisplaycardService extends IService<ClientHardwareDisplaycard> {
    
    void restoreFinal(List<ClientHardwareDisplaycard> list);
    
}
