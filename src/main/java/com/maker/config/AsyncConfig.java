package com.maker.config;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
	@Value("${common.async.corepoolsize}")
	private Integer commonCorePoolSize;
	@Value("${common.async.maxpoolsize}")
	private Integer commonMaxpoolSize;

	@Bean(name = "commonAsync")
    public Executor consumerAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(commonCorePoolSize);
        executor.setMaxPoolSize(commonMaxpoolSize);
        executor.setQueueCapacity(commonCorePoolSize * commonMaxpoolSize);
        executor.setThreadNamePrefix("commonAsync-");
        executor.initialize();
        return executor;
    }
}
