package com.example.thread;

import java.util.ArrayList;
import java.util.List;
/*
1.使用wait方法和notify方法实现“生产者和消费者模式”
2.wait方法：让线程进入等待状态，释放掉t线程之前占有的对象锁
3.notify方法：唤醒o对象上等待的线程，只是通知，不会释放占有的锁。
 */

public class ThreadTest12 {
    public static void main(String[] args) {
        //创建1个仓库对象，是共享的
        List list = new ArrayList();
        //创建两个线程对象

        //生产者线程
        Thread t1 = new Thread(new Producer(list));

        //消费者县茨城
        Thread t2 = new Thread(new Consumer(list));

        t1.setName("生产者线程");
        t2.setName("消费者线程");

        t1.start();
        t2.start();
    }
}
//生产线程
class Producer implements Runnable{
    //仓库
    private List list;

    public Producer(List list){
        this.list = list;
    }
    @Override
    public void run(){
        //一直生产（使用死循环来模拟一直生产）
        while(true){
            //给仓库对象list加锁、
            synchronized (list){
                if (list.size()>0){//大于0说明仓库已经有1个元素了
                    try {
                        //当前线程进入等待状态，并且释放Producer之前占有的list集合的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序执行到这里说明仓库是空的，可以生产（因为size不大于0）
                Object obj = new Object();
                list.add(obj);
                System.out.println(Thread.currentThread().getName() + "---->"+ obj);

                //唤醒消费者进行消费
                list.notify();
            }
        }
    }
}
//消费线程
class Consumer implements Runnable{
    //仓库
    private List list;

    public Consumer(List list){
        this.list = list;
    }
    @Override
    public void run(){
        while (true){
            synchronized (list){
                if (list.size()== 0){
                    try {
                        //仓库已经空了，消费者线程等待，释放list集合的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //程序执行到这里说明仓库已经满，需要消费
                Object obj = list.remove(0);
                System.out.println(Thread.currentThread().getName() + "---->" + obj);

                //唤醒生产者生产
                list.notify();
            }
        }
    }
}