package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientHardwareSummaryInsideMapper;
import com.xizi.redis_action.pojo.ClientHardwareSummaryInside;
import com.xizi.redis_action.service.MyClientHardwareSummaryInsideService;
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
public class MyClientHardwareSummaryInsideServiceImpl extends ServiceImpl<MysqlClientHardwareSummaryInsideMapper, ClientHardwareSummaryInside> implements MyClientHardwareSummaryInsideService {
    
    @Override
    @Async("taskExecutor")
    @Transactional
    public void restoreFinal(List<ClientHardwareSummaryInside> list) {
        log.info("task for ClientHardwareSummaryInside start");
        try {
            this.saveOrUpdateBatch(list);
            log.info("task for ClientHardwareSummaryInside end");
        } catch (Exception e) {
            log.error("ERROR!! msg info:{}",e);
        }
    }
}
