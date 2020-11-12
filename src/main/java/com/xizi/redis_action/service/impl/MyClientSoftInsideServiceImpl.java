package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientSoftInsideMapper;
import com.xizi.redis_action.pojo.ClientSoftwareInside;
import com.xizi.redis_action.service.MyClientSoftInsideService;
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
public class MyClientSoftInsideServiceImpl extends ServiceImpl<MysqlClientSoftInsideMapper, ClientSoftwareInside> implements MyClientSoftInsideService {
    
    @Override
    @Async("taskExecutor")
    @Transactional
    public void restoreFinal(List<ClientSoftwareInside> list) {
        log.info("task for ClientSoftwareInside start");
        try {
            this.saveOrUpdateBatch(list);
            log.info("task for ClientSoftwareInside end");
        } catch (Exception e) {
            log.error("ERROR!! msg info:{}",e);
        }
    }
}
