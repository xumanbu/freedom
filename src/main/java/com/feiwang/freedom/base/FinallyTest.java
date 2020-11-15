package com.feiwang.freedom.base;

public class FinallyTest {
    public static void main(String[] args) {
        System.out.printf(test()+"");
    }

    public static int test(){
        try{
            Integer.valueOf("x");
            return 5;
        }catch (Exception e){
            return 0;
        }finally {
            return 1;
        }
    }
}
