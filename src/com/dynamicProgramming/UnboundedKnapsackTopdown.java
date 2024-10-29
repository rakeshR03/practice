package com.dynamicProgramming;

public class UnboundedKnapsackTopdown {
    public static void main(String[] args) {
        int wt[] = {1,3,4,5};
        int val[] = {1,4,5,7};
        int w = 7;
        int n = wt.length;

        int t[][] = new int[n+1][w+1];

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=w; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
                if (i >0 && j > 0) {
                    if (wt[i-1] <= j) {
                        int val1 = val[i-1] + t[i][j - wt[i-1]];
                        int val2 = t[i-1][j];
                        t[i][j] = Math.max(val1, val2);
                    } else {
                        t[i][j] = t[i-1][j];
                    }
                }
            }
        }
        System.out.println("ans : " + t[n][w]);
    }
}
