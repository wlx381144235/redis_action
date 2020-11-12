package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientHardwareChangelogMapper;
import com.xizi.redis_action.pojo.ClientHardwareChangelog;
import com.xizi.redis_action.service.MyClientHardwareChangelogService;
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
public class MyClientHardwareChangelogServiceImpl extends ServiceImpl<MysqlClientHardwareChangelogMapper, ClientHardwareChangelog> implements MyClientHardwareChangelogService {
    
    @Override
    @Async("taskExecutor")
    @Transactional
    public void restoreFinal(List<ClientHardwareChangelog> list) {
        log.info("task for ClientHardwareChangelog start");
        try {
            this.saveOrUpdateBatch(list);
            log.info("task for ClientHardwareChangelog end");
        } catch (Exception e) {
            log.error("ERROR!! msg info:{}",e);
        }
    }
}
