package com.xizi.redis_action.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xizi.redis_action.mapper.mysql.MysqlClientMapper;
import com.xizi.redis_action.pojo.ClientSoftware;
import com.xizi.redis_action.service.MyClientSoftService;
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
public class MyClientSoftServiceImpl extends ServiceImpl<MysqlClientMapper, ClientSoftware> implements MyClientSoftService {
    
    @Override
    @Async("taskExecutor")
    public void restore(List<ClientSoftware> list) {
        boolean result = this.saveOrUpdateBatch(list);
        if(result){
            log.info("这个list有{}个元素",list.size());
        } else {
            log.error("失败了");
        }
    }
    
    @Override
    @Async("taskExecutor")
    public void restoreFinal(List<ClientSoftware> list) {
        this.saveOrUpdateBatch(list);
    }
}
