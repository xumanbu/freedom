package com.feiwang.freedom.dp;

public class StairSolution {
    static int stepCount = 0;
    static int step2Count = 0;

    public static void main(String[] args) {
        System.out.println(step(10) + "==>" + stepCount);
        System.out.println(stepDP(10) + "==>" + step2Count);
    }

    public static int step(int n) {
        int types = 1;
        if (n == 1 || n == 2) {
            return n;
        }
        stepCount++;
        types = step(n - 1) + step(n - 2);
        return types;
    }

    public static int stepDP(int n) {
        //定义dp状态 记录 后一种状态依赖前一种状态
        int[] dp = new int[n+1]; //记录每一个N的可以有的种类
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            step2Count++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
