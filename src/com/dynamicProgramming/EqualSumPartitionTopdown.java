package com.dynamicProgramming;

public class EqualSumPartitionTopdown {
    public static void main(String[] args) {
        int ar[] = {1,5,11,5};
        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        if (sum % 2 != 0) {
            System.out.println("ans : " + false);
            return;
        }

        int n = ar.length;
        int target = sum/2;
        boolean t[][] = new boolean[n+1][target+1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<target; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=target; j++) {
                if (ar[i-1] <= j) {
                    boolean val1 = t[i-1][j - ar[i-1]];
                    boolean val2 = t[i-1][j];
                    t[i][j] = val1 || val2;
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        System.out.println("ans : " + t[n][target]);
    }
}
