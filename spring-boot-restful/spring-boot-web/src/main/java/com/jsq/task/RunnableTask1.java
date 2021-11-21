package com.jsq.task;

public class RunnableTask1 implements Runnable{
    @Override
    public void run() {
        Object o = new Object();
        synchronized (o){
            try {
                for (int i = 1;i <= 100;i++){
                    System.out.println(Thread.currentThread().getName()+"----------异步：>"+i);
                    o.wait(200);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
