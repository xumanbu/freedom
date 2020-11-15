package com.feiwang.freedom.volatilest;

public class VolatileThreadSafe {
    static volatile int i = 0;
    //static int i = 0;

    static synchronized void add(int x){
        i++;
        //return x;
    }

    public static void main(String[] args) {

        for(int x=0;x<10;x++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0;j<10;j++){
                        add(i);
                    }
                    System.out.println("i="+i);
                }
            }).start();
        }



    }
}
