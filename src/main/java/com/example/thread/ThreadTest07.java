package com.example.thread;

/**
 * interrupt:使终断
 * 注意：不是终断线程的执行，而是终止线程的睡眠
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable2());
        t.setName("t");
        t.start();

        //5秒之后，t线程醒来
        try {
            t.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //终断t线程的睡眠（这种终断睡眠的方式依靠了java的异常处理机制）
        t.interrupt();
    }
}

class MyRunnable2 implements Runnable{
    /**
     * 只能tyr catch 是因为run（）方法在父类中没有抛出任何异常，子类不能比父类抛出更多的异常
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-----> begin");
        try {
            //睡眠一年
            Thread.sleep(1000 * 60 * 60 * 24 * 365 );
        } catch (InterruptedException e) {
            //打印异常信息，可注释
            e.printStackTrace();
        }
        //一年之后执行这里
        System.out.println(Thread.currentThread().getName() + "----> end");
    }
}
