package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientHardwareMonitorInsideMapper;
import com.xizi.redis_action.pojo.ClientHardwareMonitorInside;
import com.xizi.redis_action.service.MyClientHardwareMonitorInsideService;
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
public class MyClientHardwareMonitorInsideServiceImpl extends ServiceImpl<MysqlClientHardwareMonitorInsideMapper, ClientHardwareMonitorInside> implements MyClientHardwareMonitorInsideService {
    
    @Override
    @Async("taskExecutor")
    @Transactional
    public void restoreFinal(List<ClientHardwareMonitorInside> list) {
        log.info("task for ClientHardwareMonitorInside start");
        try {
            this.saveOrUpdateBatch(list);
            log.info("task for ClientHardwareMonitorInside end");
        } catch (Exception e) {
            log.error("ERROR!! msg info:{}",e);
        }
    }
}
