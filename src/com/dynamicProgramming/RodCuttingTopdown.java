package com.dynamicProgramming;

public class RodCuttingTopdown {
    public static void main(String[] args) {
        int len[] = {1,2,3,4,5,6,7,8};
        int price[] = {1,5,8,9,10,17,17,20};
        int length = 8;
        int n = len.length;

        int t[][] = new int[n+1][length+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=length; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
                if (i > 0 && j> 0) {
                    if (len[i-1] <= j) {
                        int val1 = price[i-1] + t[i][j-len[i-1]];
                        int val2 = t[i-1][j];
                        t[i][j] = Math.max(val1, val2);
                    } else {
                        t[i][j] = t[i-1][j];
                    }
                }
            }
        }
        System.out.println("ans : " + t[n][length]);
    }
}
