package com.example.thread;

public class ThreadTest01 {
    public static void main(String[] args) {
        //主线程，在主栈中运行
        //新建一个分支线程对象
        MyThread t = new MyThread();
        //启动线程

        //单线程，不会分配新的分支栈
//        t.run();

        //start()方法作用：开启一个新的栈空间（分支栈），然后start方法就结束了线程就启动成功了
        //多线程并发
        t.start();
        //这里的代码还是运行在主线程中。
        for (int i = 0 ; i <= 1000; i++){
            System.out.println("主线程------->" + i);
        }
    }
}
class MyThread extends Thread {
    public void run(){
        for (int i = 0 ; i <= 1000; i++){
            System.out.println("分支线程------->" + i);
        }
    }
}
