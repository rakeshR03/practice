package com.dynamicProgramming;

public class PrintingLongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "abcde";
        String y = "abfce";
        int n = x.length();
        int m = y.length();
        int t[][] = new int[n+1][m+1];
        StringBuffer sb = new StringBuffer();
        String ans = "";

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else {
                    if (x.charAt(i-1) == y.charAt(j-1)) {
                        sb.append(x.charAt(i-1));
                        t[i][j] = 1 + t[i-1][j-1];
                    } else {
                        t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                    }
                }
            }
        }
        ans = sb.toString();
        System.out.println("ans : " + ans);
        getSubsequence(t, x, y, n, m);
    }
    public static void getSubsequence(int t[][], String x, String y, int n, int m) {
        int i = n;
        int j = m;
        StringBuffer sb = new StringBuffer();
        while (i > 0 && j> 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                sb.append(x.charAt(i-1));
                i--; j--;
            } else {
                if (t[i-1][j] > t[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        String ans = sb.reverse().toString();
        System.out.println("ans1 : " +ans);
    }
}
