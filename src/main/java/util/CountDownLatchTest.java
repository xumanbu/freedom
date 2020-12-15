package util;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<3;i++){
                    try {
                        Thread.sleep(3000* i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                    System.out.println("countDown -1");
                }
            }
        }).start();

        try {
            System.out.println("main waiting");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main start run");


    }

}
