package com.zdx.sync;

/**
 * Synchronized 关键字可见性测试
 * 总结：Synchronized保证可见性是基于JMM中的Lock/Unlock指令
 * lock指令会将线程工作内存的数据清空，再操作就会重新读取主内存数据
 * unlock指令会将工作内存的数据刷新到主内存中
 * 因此Synchronized保证了可见性
 * @author ZDX
 * @date 2020/01/13 11:30
 */
public class SyncTest {
    private static boolean flag = true;
    private static final Object obj = new Object();
    public static void main(String[] args) {

        new Thread(() -> {
            while (flag) {
                synchronized (obj) {}
            }
        }).start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            flag = false;
            System.out.println("修改线程执行完毕 "+ flag);
        }).start();
    }
}
