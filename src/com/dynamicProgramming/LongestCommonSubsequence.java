package com.dynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abedfhr";
        int n = x.length();
        int m = y.length();
        int t[][] = new int[n+1][m+1];

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
                if (i > 0 && j > 0) {
                    if (x.charAt(i-1) == y.charAt(j-1)) {
                        t[i][j] = 1 + t[i-1][j-1];
                    } else {
                        int val1 = t[i-1][j];
                        int val2 = t[i][j-1];
                        t[i][j] = Math.max(val1, val2);
                    }
                }
            }
        }
        System.out.println("ans : " + t[n][m]);
    }
}
