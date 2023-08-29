package com.example.threadTest;

public class WaitAndNotify {
    public static void main(String[] args) {
        final Message message = new Message();

        // 线程 A 打印消息
        Thread threadA = new Thread(() -> {
            synchronized (message) {
                try {
                    System.out.println("Thread A is waiting...");
                    message.wait();
                    System.out.println("Thread A received a message: " + message.getMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 线程 B 发送消息
        Thread threadB = new Thread(() -> {
            synchronized (message) {
                System.out.println("Thread B is sending a message...");
                message.setMessage("Hello, World!");
                message.notify();
            }
        });

        threadA.start();
        threadB.start();
    }

    static class Message {
        private String message;

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}