package com.example.threadTest;

public class ThreadTest04 extends Thread{
    public ThreadTest04() {
        System.out.println("构造方法：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println("run方法：" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadTest04();
        t1.start();

        Runrun runrun = new Runrun();
        Thread t2 = new Thread(runrun);
        t2.start();
    }
}
class Runrun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println("Runnable：" + Thread.currentThread().getName());
        }
    }
}
