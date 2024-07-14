package com.soonmachine.leetcode.editor.cn;

public class MultiProcess {
    static int n = 100;
    static int count = 0;

    static Object lock = new Object();

    public static void main(String[] args) {
        Thread r1 = new Thread(new Single());
        Thread r2 = new Thread(new Double());
        r1.start();
        r2.start();
    }

    static class Single implements Runnable {
        @Override
        public void run() {
            while (count <= n) {
                synchronized (lock) {
                    if (count % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + " print " + count++);
                        lock.notify(); //唤醒其他线程
                    } else {
                        try {
                            lock.wait(); //当前线程等待
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    static class Double implements Runnable {
        @Override
        public void run() {
            while (count <= n) {
                synchronized (lock) {
                    if (count % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " print " + count++);
                        lock.notify(); //唤醒其他线程
                    } else {
                        try {
                            lock.wait(); //当前线程等待
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
