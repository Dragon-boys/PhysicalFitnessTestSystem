package com.example.test03.config;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 线程配置类
 */
@Configuration
@EnableAsync
public class ThreadTestConfig implements AsyncConfigurer {

    /**
     *  ThreadPoolTaskExecutor的处理流程
     *  当池子大小小于corePoolSize，就新建线程，并处理请求
     *  当池子大小等于corePoolSize，把请求放入workQueue中，池子里的空闲线程就去workQueue中取任务并处理
     *  当workQueue放不下任务时，就新建线程放入线程池，并处理请求，如果池子大小撑到了maximumPoolSize，就用RejectedExecutionHandler来做拒绝处理
     *  当池子的线程数大于corePoolSize时，多余的线程会等待keepAliveTime长时间，如果无请求可处理就自行销毁
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor tp = new ThreadPoolTaskExecutor();
        //设置核心线程数
        tp.setCorePoolSize(10);
        //设置最大线程数
        tp.setMaxPoolSize(100);
        //线程使用的缓冲队列
        tp.setQueueCapacity(10);
        //设置程序关闭时要等待线程全部执行完
        tp.setWaitForTasksToCompleteOnShutdown(true);
        //设置等待时间，超过等待时间后立即停止
        tp.setAwaitTerminationSeconds(60);
        //线程名称前缀
        tp.setThreadNamePrefix("Test-Async-");
        //初始化线程
        tp.initialize();
        return tp;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return null;
    }
}