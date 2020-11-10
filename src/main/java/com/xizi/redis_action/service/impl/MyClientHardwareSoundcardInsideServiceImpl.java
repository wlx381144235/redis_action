package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientHardwareSoundcardInsideMapper;
import com.xizi.redis_action.pojo.ClientHardwareSoundcardInside;
import com.xizi.redis_action.service.MyClientHardwareSoundcardInsideService;
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
public class MyClientHardwareSoundcardInsideServiceImpl extends ServiceImpl<MysqlClientHardwareSoundcardInsideMapper, ClientHardwareSoundcardInside> implements MyClientHardwareSoundcardInsideService {
    
    @Override
    @Async("taskExecutor")
    public void restoreFinal(List<ClientHardwareSoundcardInside> list) {
        this.saveOrUpdateBatch(list);
    }
}
