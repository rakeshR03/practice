package com.dynamicProgramming;

public class CountNoOfSubsetWithGivenDifferenceTopdown {
    public static void main(String[] args) {
        int ar[] = {1,1,2,3};
        int diff = 1;
        int n = ar.length;
        int sum = 0;
        for(int i : ar) {
            sum += i;
        }
        int target = (diff + sum)/2;

        int t[][] = new int[n+1][target+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=target; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
                if (i > 0 && j > 0) {
                    if (ar[i-1] <= j) {
                        int val1 = t[i-1][j-ar[i-1]];
                        int val2 = t[i-1][j];
                        t[i][j] = val1 + val2;
                    } else {
                        t[i][j] = t[i-1][j];
                    }
                }
            }
        }
//        for (int i=1; i<=n; i++) {
//            for (int j=1; j<=sum; j++) {
//
//            }
//        }
        System.out.println("ans : " + t[n][target]);
    }
}
