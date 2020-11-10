package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientHardwareSummaryMapper;
import com.xizi.redis_action.pojo.ClientHardwareSummary;
import com.xizi.redis_action.service.MyClientHardwareSummaryService;
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
public class MyClientHardwareSummaryServiceImpl extends ServiceImpl<MysqlClientHardwareSummaryMapper, ClientHardwareSummary> implements MyClientHardwareSummaryService {
    
    @Override
    @Async("taskExecutor")
    public void restoreFinal(List<ClientHardwareSummary> list) {
        this.saveOrUpdateBatch(list);
    }
}
