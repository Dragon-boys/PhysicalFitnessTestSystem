package com.example.thread;/*
package thread;

import java.util.List;

public class ThreadTest13 {
    public class Num implements Runnable{
        private int i;
        public Num(int i){
            this.i = i;
        }

        @Override
        public void run() {
            while(i<100){
                synchronized (){
                    i.notify();
                    if ( i % 2 != 0){
                        System.out.println("奇数为：" + i);
                        i++;
                        try {
                            i.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                list.notify();
            }
        }
    }
    public static void main(String[] args) {


        Thread t1 = new Thread(new Num());
        Thread t2 = new Thread();

        t1.setName("奇数");
        t2.setName("偶数");

        t1.start();
        t2.start();
    }
}
*/
/*    @Override
    public void run() {
        while(i<100){
            synchronized (list){
                list.notify();
                if ( i % 2 != 0){
                    System.out.println("奇数为：" + i);
                    i++;
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            list.notify();
    }
}*//*

class MyRunnable0 implements Runnable{
*/
/*    int i = 0;
    Object obj = new Object();*//*

    private List list;
    public MyRunnable0(List list){
        this.list = list;
    }
    @Override
    public void run() {
        while(i<100){
            synchronized (list){
                list.notify();
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
*/
