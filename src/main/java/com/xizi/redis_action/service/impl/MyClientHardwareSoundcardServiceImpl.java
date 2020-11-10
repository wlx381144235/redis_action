package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientHardwareSoundcardMapper;
import com.xizi.redis_action.pojo.ClientHardwareSoundcard;
import com.xizi.redis_action.service.MyClientHardwareSoundcardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020/11/4 10:15
 */

@Service
@Slf4j
public class MyClientHardwareSoundcardServiceImpl extends ServiceImpl<MysqlClientHardwareSoundcardMapper, ClientHardwareSoundcard> implements MyClientHardwareSoundcardService {
    
    @Override
    @Async("taskExecutor")
    public void restoreFinal(List<ClientHardwareSoundcard> list) {
        this.saveOrUpdateBatch(list);
    }
}
