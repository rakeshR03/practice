package com.dynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplicationWithMemoization {
    static int t[][] = new int[10][10];
    public static void main(String[] args) {
        int ar[] = {10,20,30};
        int n = ar.length;
        for(int i=0; i<n+1; i++) {
            Arrays.fill(t[i], -1);
        }
        int ans = solve(ar, 1, n-1);
        System.out.println("ans : " + ans);
        for(int i=0; i<n+1; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
    }
    static int solve (int ar[], int i, int j) {
        if (i >= j) {
            return t[i][j] = 0;
        }
        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int val1 = solve(ar, i, k);
            int val2 = solve(ar, k+1, j);
            int val3 = ar[i-1] * ar[k] * ar[j];
            int temp = val1 + val2 + val3;
            if (temp < minCost) {
                minCost = temp;
            }
        }
        t[i][j] = minCost;
        return t[i][j];
    }
}
