package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientAllInsideMapper;
import com.xizi.redis_action.mapper.mysql.MysqlClientInsideMapper;
import com.xizi.redis_action.pojo.ClientAllInside;
import com.xizi.redis_action.pojo.ClientInside;
import com.xizi.redis_action.service.MyClientAllInsideService;
import com.xizi.redis_action.service.MyClientInsideService;
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
public class MyClientAllInsideServiceImpl extends ServiceImpl<MysqlClientAllInsideMapper, ClientAllInside> implements MyClientAllInsideService {
    
    @Override
    @Async("taskExecutor")
    public void restoreFinal(List<ClientAllInside> list) {
        this.saveOrUpdateBatch(list);
    }
}
