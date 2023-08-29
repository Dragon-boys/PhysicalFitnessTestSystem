package com.example.threadTest;

public class ThreadTest06 extends Thread{
    @Override
    public void run() {
        for (int i  = 0; i < 10; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }

    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        t1.setName("t1");

        Mythread t2 = new Mythread();
        t2.setName("t2");

        ThreadTest06 t3 = new ThreadTest06();
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Mythread extends Thread{
    @Override
    public void run() {
        for (int i  = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
