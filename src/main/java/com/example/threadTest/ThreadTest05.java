package com.example.threadTest;

public class ThreadTest05 {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.setName("t1");
        myRunnable.start();
        for (int i = 0; i < 10; i++){
            myRunnable.sleep(1000);
            System.out.println("主线程：" + myRunnable);
            if (i == 5){
                System.out.println("t1开始插队或者礼让");
                myRunnable.join();
            }
        }


//        t1.interrupt();//打断t1状态

    }
}
class MyRunnable extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 12; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1...." + i);
        }


/*        while (true){
            try {
                Thread.sleep(1000*5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1查询正在运行");
        }*/
    }
}

