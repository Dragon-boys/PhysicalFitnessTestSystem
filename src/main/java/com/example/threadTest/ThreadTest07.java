package com.example.threadTest;

public class ThreadTest07 {
    public static void main(String[] args) {

        MyRunnable1 myRunnable1 = new MyRunnable1();
        Thread t = new Thread(myRunnable1);
        t.setName("t1");
        t.start();

        MyRunnable2 t2 = new MyRunnable2();
        t2.setName("t2");
        t2.start();
    }
}
class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
class MyRunnable2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 6; i++){
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
