package com.feiwang.freedom.base;

import java.util.LinkedList;

public class AnyArray {
    static LinkedList<int[]> resultPackage = new LinkedList();
    static int[] stateEme = {0,1};

    public static void main(String[] args) {
        int[] target = new int[10];
        for(int j=0;j<target.length;j++){
            target[j] = -1;
        }
        setNState(target,0);
    }

    /**
     * 递归有两种情况：
     * 一种是结果向下递归，result值每次改变被带入下一层，结果在终止递归处
     * 另一种是结果向上递归，result的值需要下一层计算完，返回后计算，初始计算值在终止递归处
     *
     * 递归每一层都需要有N的状态变化
     * 递归里可以嵌套多个
     * @param result
     * @param n
     */
    public static void setNState(int[] result,int n){
        if(n ==result.length-1){
            resultPackage.add(result);
            print(result);
            return;
        }
        for(int state:stateEme){
            result[n] = state;
            //这里不同的state之间是没有任何关系的，单纯的及时因为N有不同的走法。
            //递归要走出所有不同的情况到结果，不能漏掉任何一种情况
            setNState(result,n++);
        }
    }

    public static void print(int[] a){
        for(int t:a){
            System.out.printf(t+"");
        }
        System.out.println("");
    }
}
