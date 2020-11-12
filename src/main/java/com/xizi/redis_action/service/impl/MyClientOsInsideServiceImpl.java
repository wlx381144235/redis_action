package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientOsInsideMapper;
import com.xizi.redis_action.pojo.ClientOsInside;
import com.xizi.redis_action.service.MyClientOsInsideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 夜尽
 * @date 2020/11/4 10:15
 */

@Service
@Slf4j
public class MyClientOsInsideServiceImpl extends ServiceImpl<MysqlClientOsInsideMapper, ClientOsInside> implements MyClientOsInsideService {
    
    @Override
    @Async("taskExecutor")
    @Transactional
    public void restoreFinal(List<ClientOsInside> list) {
        log.info("task for ClientOsInside start");
        try {
            this.saveOrUpdateBatch(list);
            log.info("task for ClientOsInside end");
        } catch (Exception e) {
            log.error("ERROR!! msg info:{}",e);
        }
    }
}
