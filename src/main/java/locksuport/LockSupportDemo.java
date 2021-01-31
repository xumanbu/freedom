package locksuport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static Object u = new Object();
    // locksupport不影响wait锁的问题
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }
        @Override public void run() {
            //synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("被中断了");
                }
                System.out.println("继续执行");
            //}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        /**
         * t1内部有休眠1s的操作，所以unpark肯定先于park的调用，但是t1最终仍然可以完结。
         * 这是因为park和unpark会对每个线程维持一个许可（boolean值）
         * unpark调用时，如果当前线程还未进入park，则许可为true
         * park调用时，判断许可是否为true，如果是true，则继续往下执行；如果是false，则等待，直到许可为true
         *
         */
        LockSupport.unpark(t1);
        Thread.sleep(3000L);
        System.out.println("start interrupt");
        // interrupt 也会中断park等待，会设置中断标识位
        t1.interrupt();
        Thread.sleep(10000);
        System.out.println("start unpark");
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}