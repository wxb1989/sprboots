package com.eds.cloud.bussiness.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author wxb
 * @version V1.0
 * @Package com.eds.cloud.bussiness.task
 * @date 2020/7/20 14:00
 */
@Component
public class AsyncExecutorTask extends AbstractTask{

    @Override
    @Async("taskExecutor")
    public void doTaskOne() throws Exception {
        System.out.println("任务三，当前线程：" + Thread.currentThread().getName());
    }

    @Override
    @Async("taskExecutor")
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
        System.out.println("任务三，当前线程：" + Thread.currentThread().getName());
    }

    @Override
    @Async("taskExecutor")
    public void doTaskThree() throws Exception {
        System.out.println("任务三，当前线程：" + Thread.currentThread().getName());
    }
}
