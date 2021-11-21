package com.jsq.controller;

import com.jsq.service.LoginServiceImp;
import com.jsq.task.RunnableTask1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@Slf4j
@RestController
@RequestMapping
public class SyncTaskController {
    private LoginServiceImp loginServiceImp = new LoginServiceImp();
    /**
     * 同步处理
     * @return
     */
    @RequestMapping(value = "test2",method = RequestMethod.GET)
    public String syncTask(){
        loginServiceImp.getTest2();
        log.info(Thread.currentThread().getName()+"==========主线程名");
        return "同步,正在解析......";
    }

    /**
     * 异步处理1：线程池，创建新线程处理
     * @return
     */
    @RequestMapping(value = "test3",method = RequestMethod.GET)
    public String test3(){
        ExecutorService service = new ThreadPoolExecutor(10,10,0L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100),new CustomizableThreadFactory("jsq"),new ThreadPoolExecutor.DiscardOldestPolicy());
        RunnableTask1 task1 = new RunnableTask1();
        service.execute(task1);
        log.info("=========》当前线程名："+Thread.currentThread().getName());
        return "异步,正在解析......";
    }
}
