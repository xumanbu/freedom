package juc;

public class ThreadJoinSolution {
    public static void main(String[] args) {
//        try {
//            Thread.currentThread().wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start work....."+Thread.currentThread().getName());
                try {
                    Thread.sleep(1000*8);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("end work."+Thread.currentThread().getName());
            }
        });
        t1.start();

        Thread main = Thread.currentThread();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3*1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                main.interrupt();
//
//            }
//        }).start();

        try {
            // 本质上是调用了t1的wait方法进入等待状态，当t1结束后，会自动唤醒等待的线程。
            // 我等t1完成后再执行
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end."+Thread.currentThread().getName());

    }
}
