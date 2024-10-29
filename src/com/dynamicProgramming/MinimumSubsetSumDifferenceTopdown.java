package com.dynamicProgramming;

import java.util.Arrays;

public class MinimumSubsetSumDifferenceTopdown {
    public static void main(String[] args) {
        int ar[] = {1,6,11,5};
        int n = ar.length;
        // find range
        int sum = 0;
        for(int i: ar) {
            sum += i;
        }
//        // reducing the sum to half
//        sum = sum/2;
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
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum; j++) {
                if (ar[i-1] <= j) {
                    boolean val1 = t[i-1][j-ar[i-1]];
                    boolean val2 = t[i-1][j];
                    t[i][j] = val1 || val2;
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
//        System.out.println("last row : " + Arrays.toString(t[n]));

        int minDiff = -1;
//        for (int k = sum; k>=0; k--) {
        for (int k = sum/2; k>=0; k--) {
            if (t[n][k]) {
//                    minDiff = 2*sum - (2 * k);
                minDiff = sum - (2 * k);
                break;
            }

        }
        System.out.println("ans : " + minDiff);
    }
}
