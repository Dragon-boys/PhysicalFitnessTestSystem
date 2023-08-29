package com.example.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/*
使用定时器指定定时任务
 */
public class TimerTest {
    public static void main(String[] args) throws Exception {
        MyThread0 myThread0 = new MyThread0();
        myThread0.setName("线程");

        myThread0.start();

        //创建定时器对象
//        Timer time = new Timer();
        Timer timer = new Timer(true);//守护线程的方式 线程结束 定时器跟着结束！

        //指定定时任务
        //time.schedule（定时任务，第一次执行时间，间隔多久执行一次）

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

        Date firstTime = sdf.parse("2023-07-24 17:50:00 000");

        //TimerTask抽象不能new
        LogTimerTask l = new LogTimerTask();
        timer.schedule(l,firstTime,1000*3);

/*        //匿名内部类：TimerTask
        timer.schedule(new TimerTask(){
            @Override
            public void run() {

            }
        },firstTime,1000*3);*/
    }
}
//编写一个定时任务类
//假设这是一个记录日志的定时器
class LogTimerTask extends TimerTask{
    @Override
    public void run() {
        //编写你需要执行的任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String strTime = sdf.format(new Date());
        System.out.println(strTime + ":完成了一次数据备份");
    }
}
class MyThread0 extends Thread{
    public void run(){
        for (int i = 0 ; i <10; i++){
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "------>" + i);
        }
    }
}
