package com.example.threadTest;

/**
 * 不合理！
 */
public class ThreadTest01 extends Thread{

    private int number = 10;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            if (number >0){
                number--;
                System.out.println(Thread.currentThread().getName() + "顾客抢到手，剩余优惠券：" + number);
            }
        }
    }
    public static void main(String[] args) {
        ThreadTest01 threadTest01 = new ThreadTest01();
        ThreadTest01 threadTest02 = new ThreadTest01();
        ThreadTest01 threadTest03 = new ThreadTest01();

        threadTest01.start();
        threadTest02.start();
        threadTest03.start();
    }
}
