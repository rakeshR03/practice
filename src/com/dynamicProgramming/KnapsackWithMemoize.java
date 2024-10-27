package com.dynamicProgramming;

import java.util.Arrays;

public class KnapsackWithMemoize {
    static int t[][]= new int[5][8];
    public static void main(String[] args) {
        int wt[] = {1,3,4,5};
        int val[] = {1,4,5,6};
        int w = 7;
        for (int[] row: t)
            Arrays.fill(row, -1);
        int ans = solve(wt, val, w, wt.length-1);
        System.out.println("ans : " +ans);
    }
    static int solve(int[] wt, int[] val, int w, int n) {
        if (w==0 || n==0) {
            t[n][w] = 0;
            return t[n][w];
        }
        if (t[n][w] != -1) {
            return t[n][w];
        }

        if (wt[n] <= w){
            int val1 = val[n] + solve(wt,val,w-wt[n], n-1);
            int val2 = solve(wt,val,w,n-1);
            t[n][w] = Math.max(val1, val2);
            return t[n][w];
        } else {
            t[n][w] = solve(wt,val,w,n-1);
            return t[n][w];
        }
    }
}
