package com.example.thread;

/**
 * 面试题：以下程序会让线程t进入休眠状态吗？
 */
public class ThreadTest06 {
    public static void main(String[] args) {
        Thread t = new Mythread3();//多态
        t.setName("t");
        t.start();

        //调用sleep方法
        try {
            t.sleep(1000 * 5);//在执行的时候还是会转换成：Thread.sleep(1000*5)
                                    //这行代码的作用是：让《当前》线程进入休眠，也就是main线程进入休眠
                                    //这行代码出现在main方法中，main线程休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //5秒之后执行这里
        System.out.println("hello World！");
    }
}
class Mythread3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i<100; i ++){
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}
