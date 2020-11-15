package com.feiwang.freedom.base;

public class SqrtSolution {

    public static void main(String[] args) {
        System.out.println(sqrt(5));
    }

    public static float sqrt(float a){
        return mid(1,a,a);
    }

    public static float mid(float left,float right,float target){
        if(left==right) return left;
        if(right - left<0.001)return right;
        if(left*left > target){
            return mid(left-(left* left-target)/2,left,target);
        }else if(right* right<right){
            return mid(right,right+(target-right*right)/2,target);
        }else{
            return left;
        }
    }
}
