package com.example.test03.service2.impl;

import com.example.test03.service2.ThreadTestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadTestConfigServiceImpl implements ThreadTestService {
    @Override
    @Async
    public void executeThread(int i) {
        System.out.println("线程" + Thread.currentThread().getName() + "执行异步任务" + i);
    }
}
