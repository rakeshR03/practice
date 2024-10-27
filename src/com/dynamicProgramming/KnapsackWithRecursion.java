package com.dynamicProgramming;

public class KnapsackWithRecursion {
    public static void main(String[] args) {
        int wt[] = {1,3,4,5};
        int val[] = {1,4,5,6};
        int w = 7;

        int ans = solve(wt, val, w, wt.length-1);
        System.out.println("ans : " +ans);
    }
    static int solve(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }
        if (wt[n] <= w) {
            int val1 = val[n] + solve(wt, val, w-wt[n], n-1);
            int val2 = solve(wt, val, w, n-1);
            return Math.max(val1, val2);
        } else {
            return solve(wt, val, w, n-1);
        }
    }
}
