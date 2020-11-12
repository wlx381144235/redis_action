package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientHardwareDisplaycardInsideMapper;
import com.xizi.redis_action.pojo.ClientHardwareDisplaycardInside;
import com.xizi.redis_action.service.MyClientHardwareDisplaycardInsideService;
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
public class MyClientHardwareDisplaycardInsideServiceImpl extends ServiceImpl<MysqlClientHardwareDisplaycardInsideMapper, ClientHardwareDisplaycardInside> implements MyClientHardwareDisplaycardInsideService {
    
    @Override
    @Async("taskExecutor")
    @Transactional
    public void restoreFinal(List<ClientHardwareDisplaycardInside> list) {
        log.info("task for ClientHardwareDisplaycardInside start");
        try {
            this.saveOrUpdateBatch(list);
            log.info("task for ClientHardwareDisplaycardInside end");
        } catch (Exception e) {
            log.error("ERROR!! msg info:{}",e);
        }
    }
}
