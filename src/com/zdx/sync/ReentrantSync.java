package com.zdx.sync;

/**
 * Synchronized 可重入性探讨
 * @author ZDX
 * @date 2020/01/13 12:13
 */
public class ReentrantSync {

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        synchronized (MyThread.class) {
            System.out.println(getName()+"进入了外部代码块");
            synchronized (MyThread.class) {
                System.out.println(getName()+"进入了内部代码块");
            }
        }
    }
}
