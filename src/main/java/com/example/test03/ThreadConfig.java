/*
package com.example.test03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

*/
/**
 * 定义异步执行线性池
 *//*

@Configuration
@EnableAsync
public class ThreadConfig {
    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor executor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        //配置核心线程数
        executor.setCorePoolSize(15);

        //最大线程数30：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(30);

        // 缓冲队列：用来缓冲执行任务的队列
        executor.setQueueCapacity(1000);

        //线程名字前缀
        executor.setThreadNamePrefix("Executor-");

        //线程活跃时间（秒）
        //executor.setKeepAliveSeconds(60);
        //等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);

        //设置拒绝策略
        //executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        //执行初始化
        executor.initialize();
        return executor;
    }
}
*/
