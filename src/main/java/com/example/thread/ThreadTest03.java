package com.example.thread;

public class ThreadTest03 {
    public static void main(String[] args) {
        //创建线程对象，采用匿名内部类方式
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++){
                    System.out.println("分支线程i----->" + i);
                }
            }
        });
        //启动线程
        t.start();
        //  主线程
        for (int i = 0; i <= 100; i++){
            System.out.println("主线程i----->" + i);
        }
    }


}
