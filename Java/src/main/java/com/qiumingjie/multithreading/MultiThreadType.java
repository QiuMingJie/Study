package com.qiumingjie.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author QiuMingJie
 * @date 2020-01-03 20:00
 * @Description 实现3种多线程的方法
 */
public class MultiThreadType {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread1();
        Thread t2 = new Thread(new Thread2());
        FutureTask<MultiThreadType> ft = new FutureTask<MultiThreadType>(new Thread3<MultiThreadType>());
        Thread t3 = new Thread(ft);

        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(100000);
        System.out.println(ft.get());

    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            do {
                System.out.println("Thread1 running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    static class Thread2 implements Runnable {
        public void run() {
            do {
                System.out.println("Thread2 running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    static class Thread3<T> implements Callable<T> {
        public T call() throws Exception {
            do {
                System.out.println("Thread3 running");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }


}
