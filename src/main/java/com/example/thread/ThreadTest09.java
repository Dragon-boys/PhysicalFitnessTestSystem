package com.example.thread;

/**
 * 线程合并
 */
public class ThreadTest09 {
    public static void main(String[] args) {
        System.out.println("main begin");
        Thread t = new Thread(new MyRunnable6());
        t.setName("t");
        t.start();

        //合并线程
        try {
            t.join();//t合并到当前线程中，当前线程受阻塞，t线程执行直到结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main over");
    }
}
class MyRunnable6 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()+ "------>" + i );
        }
    }
}
