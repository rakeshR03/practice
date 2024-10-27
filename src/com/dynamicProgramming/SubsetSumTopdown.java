package com.dynamicProgramming;

public class SubsetSumTopdown {
    public static void main(String[] args) {
        int ar[] = {2,3,7,8,10};
        int sum = 13;
        int n = ar.length;
        boolean t[][] = new boolean[n+1][sum+1];

        for (int i=0; i<n; i++) {
            for (int j=0; j<sum; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                if (ar[i-1] <= j) {
                    boolean val1 = t[i-1][j-ar[i-1]];
                    boolean val2 = t[i-1][j];
                    t[i][j] = val1 || val2;
                }
                 else {
                     t[i][j] = t[i-1][j];
                }
            }
        }

        System.out.println("ans : " + t[n][sum]);
    }
}
