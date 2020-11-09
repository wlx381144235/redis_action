package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientNetworkAdapterMapper;
import com.xizi.redis_action.pojo.ClientNetworkAdapters;
import com.xizi.redis_action.service.MyClientNetworkAdapterService;
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
public class MyClientNetworkAdapterServiceImpl extends ServiceImpl<MysqlClientNetworkAdapterMapper, ClientNetworkAdapters> implements MyClientNetworkAdapterService {
    
    @Override
    @Async("taskExecutor")
    public void restoreFinal(List<ClientNetworkAdapters> list) {
        this.saveOrUpdateBatch(list);
    }
}
