package com.xizi.redis_action.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author 夜尽
 * @date 2020/11/4 14:18
 */

@Configuration
public class AsyncConfig {
    
    private static final int MAX_POOL_SIZE = 50;
    
    private static final int CORE_POOL_SIZE = 20;
    
    @Bean("taskExecutor")
    public AsyncTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setThreadNamePrefix("restore-pool");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
