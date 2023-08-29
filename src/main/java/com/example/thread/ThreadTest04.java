package com.example.thread;

/**
 * 获取当前线程对象：Thread t = Thread.currentThread();
 * 返回t就是当前线程
 * 获取对象名字：线程对象.getName();
 * 修改线程对象名字：线程对象.setName("线程名字")
 *
 * Thread.currentThread获取当前线程
 */

public class ThreadTest04  {
/*    public void doSome(){
        //这样就不行了
        this.getName();
        super.getName();
        //这样可以 因为ThreadTrst04不是线程类
        Thread.currentThread().getName();
    }*/
    public static void main(String[] args) {
        //currentTread就是当前线程对象
        //出现在main方法种，所以当前线程就是主线程
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());//main

        //创建线程对象
        MyThread2 t = new MyThread2();
        //设置线程名字
        t.setName("t1");
        //获取线程名字
        String tName = t.getName();
        System.out.println(tName);

        MyThread2 t2 = new MyThread2();
        t2.setName("t2");
        System.out.println(t2.getName());

        t2.start();
        t.start();
    }
}
class MyThread2 extends Thread{
    public void run(){
        for (int i = 0; i <= 100; i++){
            //currentThread就是当前线程对象，
            //当t1线程执行run方法，那么这个当前线程就是t1
            //当t2线程执行run方法，那么这个当前线程就是t2
            Thread currentThread =  Thread.currentThread();
            System.out.println(currentThread.getName() + "----->" + i);
        }
    }
}
