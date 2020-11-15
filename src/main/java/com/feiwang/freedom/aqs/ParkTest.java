package com.feiwang.freedom.aqs;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    if(i>10){
                        System.out.println("wait");
                        if(Thread.currentThread().isInterrupted()){
                            System.out.println("Iam over");
                            break;
                        }
                        i=0;
                        LockSupport.park();
                    }
                    i++;
                    System.out.println("i="+i);
                }
            }
        });
        t.setDaemon(true);
        t.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    if(i>100){
                        System.out.printf("wait2");
                        t.interrupt();
                        //LockSupport.unpark(t);
                        LockSupport.park();
                    }
                    i++;
                    System.out.println("i2="+i);
                }
            }
        });
        t2.start();


        System.out.println("=============");
    }
}
