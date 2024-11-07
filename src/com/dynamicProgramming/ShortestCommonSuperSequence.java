package com.dynamicProgramming;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String x = "geek";
        String y = "eke";
        int n = x.length();
        int m = y.length();
        int t[][] = new int[n+1][m+1];
        for (int i = 0; i<= n; i++) {
            for (int j=0; j<=m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
                else {
                    if (x.charAt(i-1) == y.charAt(j-1)) {
                        t[i][j] = 1 + t[i-1][j-1];
                    } else {
                        t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                    }
                }
            }
        }
        int lcs = t[n][m];
        int ans = n + m - lcs;
        System.out.println("ans : " + ans);
    }
}
