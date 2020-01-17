package com.zdx.sync;

/**
 * synchronized 不可中断等待或阻塞线程，并且异常会自动释放锁
 * @author ZDX
 * @date 2020/01/13 13:49
 */
public class NonInterrupt {
    private static Object obj = new Object();
    public static void main(String[] args) {
       Thread t1 =  new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
       t1.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        System.out.println("t2中断前");
        t2.interrupt();
        System.out.println("t2中断后");

        System.out.println(t1.getState());
        System.out.println(t2.getState());


    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (obj) {
                //int a = 10/0;
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
