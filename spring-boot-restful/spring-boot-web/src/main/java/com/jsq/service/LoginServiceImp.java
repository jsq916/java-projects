package com.jsq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginServiceImp implements LoginService{


    @Override
    public void getTest2() {
        Object o = new Object();
        synchronized (o){
            try {
                for (int i = 1;i <= 100;i++){
                    log.info(Thread.currentThread().getName()+"----------同步：>"+i);
                    o.wait(200);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
