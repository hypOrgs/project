package com.ypan.project.juc;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class JucTest {

    public static Object lock = new Object();
    public static int maxCount = 100;

    public static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Seq(0));
        Thread t2 = new Thread(new Seq(1));
        Thread t3 = new Thread(new Seq(2));

        t1.start();
        t2.start();
        t3.start();

    }

     static class Seq implements Runnable {

        public int index;

        public Seq(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            while (count < maxCount) {
                synchronized (lock) {
                    if (count % 3 != index) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (count <= maxCount) {
                        System.out.println("Thread-" + index + ":" + count);
                    }
                    count++;
                    lock.notifyAll();
                }
            }

        }
    }

}



