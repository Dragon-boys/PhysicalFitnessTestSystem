package com.example.thread;

public class ThreadTest02 {
    public static void main(String[] args) {
        //创建一个可运行的对象
        //MyRunnable r = new MyRunnable();
        //将可运行的对象封装成一个线程对象
        //Thread t =  new Thread(r);

        //合并以上
        Thread t = new Thread(new MyRunnable());
        //启动线程
        t.start();

        for (int i = 1; i <= 100; i++){
            System.out.println("主线程----->" + i);
        }
    }
}

//这并不是一个线程类，是一个可运行的类，它还不是一个线程
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++){
            System.out.println("分支线程----->" + i);
        }
    }
}
