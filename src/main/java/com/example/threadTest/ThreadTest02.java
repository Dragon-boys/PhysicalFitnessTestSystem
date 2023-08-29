package com.example.threadTest;

/**
 * MyThreadWithExtends
 *
 * @author Stephen
 * @time 2020-7-1 17:59:59
 */
public class ThreadTest02  implements Runnable {

    private int number = 10;

    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            if (number > 0) {
                number--;//优惠卷减一
                System.out.println(Thread.currentThread().getName() + "顾客抢到手，剩余优惠券：" + number);
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest02 threadTest02 = new ThreadTest02();
        Thread thread1 = new Thread(threadTest02,"t1");
        Thread thread2 = new Thread(threadTest02,"t2");
        Thread thread3 = new Thread(threadTest02,"t3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

