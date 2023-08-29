package com.example.threadTest;

public class ThreadTest03 implements Runnable{

    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 1; i <10; i++){
            if (ticket > 0){
                ticket --;
                System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余:" + ticket);
            }else break;
            try {
                //三秒执行一次
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
        public static void main(String[] args) {

            ThreadTest03 threadTest03 = new ThreadTest03();
            Thread t1 = new Thread(threadTest03,"售票1");
            Thread t2 = new Thread(threadTest03,"售票2");
            Thread t3 = new Thread(threadTest03,"售票3");

            t1.start();
            t2.start();
            t3.start();
        }

}
