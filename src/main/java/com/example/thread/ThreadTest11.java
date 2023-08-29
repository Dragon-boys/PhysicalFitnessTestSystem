package com.example.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/*
实现线程的第三种方式
    实现Callable接口
    优点：可以获取到线程的执行结果
    缺点：效率低，获取t线程执行结果的时候，当前线程受阻塞。
 */
public class ThreadTest11 {
    public static void main(String[] args) {

        //第一步：创建一个“未来任务类”对象
        //参数非常重要，需要给一个Callable接口实现类对象。
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {//相当于run方法，有返回值
                System.out.println("call method begin");
                Thread.sleep(1000*3);
                System.out.println("call method end!");
                int a = 100;
                int b = 200;
                return a + b;//自动装箱变成Integer
            }
        });

        //创建线程对象
        Thread t = new Thread(task);

        //启动线程
        t.start();

        //这里是main方法，主线程，get（）方法执行会导致"当前线程阻塞"
        try {
            Object obj = task.get();
            System.out.println("线程执行结果：" + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("hello world!");
    }
}
