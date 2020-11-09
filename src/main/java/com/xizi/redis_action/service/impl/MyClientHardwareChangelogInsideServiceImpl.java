package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientHardwareChangelogInsideMapper;
import com.xizi.redis_action.pojo.ClientHardwareChangelogInside;
import com.xizi.redis_action.service.MyClientHardwareChangelogInsideService;
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
public class MyClientHardwareChangelogInsideServiceImpl extends ServiceImpl<MysqlClientHardwareChangelogInsideMapper, ClientHardwareChangelogInside> implements MyClientHardwareChangelogInsideService {
    
    @Override
    @Async("taskExecutor")
    public void restoreFinal(List<ClientHardwareChangelogInside> list) {
        this.saveOrUpdateBatch(list);
    }
}
