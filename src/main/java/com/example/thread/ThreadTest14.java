package com.example.thread;

public class ThreadTest14 {
    //全局公共对象。
    static int i = 0;
    static Object obj = new Object();

    public static void main(String[] args) {


        Thread t1 = new Thread();
        Thread t2 = new Thread();

        t1.setName("奇数");
        t2.setName("偶数");

        t1.start();
        t2.start();

        class MyRunnable1 implements Runnable{
            @Override
            public void run() {
                while(i<100){
                    synchronized (obj){
                        obj.notify();
                        if ( i % 2 != 0){
                            System.out.println("奇数为：" + i);
                            i++;
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    obj.notify();
                }
            }
        }

        class MyRunnable0 implements Runnable{
            @Override
            public void run() {
                while(i<100){
                    synchronized (obj){
                        obj.notify();
                        if ( i % 2 == 0){
                            System.out.println("偶数为：" + i);
                            i++;
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    obj.notify();
                }
            }
        }
    }
}
