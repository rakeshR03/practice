package com.dynamicProgramming;

public class CountOfSubsetSumTopdown {
    public static void main(String[] args) {
        int ar[] = {2,3,5,6,8,10};
        int sum = 10;
        int n = ar.length;

        int t[][] = new int[n+1][sum+1];

        for (int i=0; i<n; i++) {
            for (int j=0; j<sum; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum; j++) {
                if (ar[i-1] <= j) {
                    int val1 = t[i-1][j-ar[i-1]];
                    int val2 = t[i-1][j];
                    t[i][j] = val1 + val2;
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        System.out.println("ans : " + t[n][sum]);
    }
}
