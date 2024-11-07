package com.dynamicProgramming;

public class PrintShortestCommonSuperSequence {
    public static void main(String[] args) {
        String x = "acbcf";
        String y = "abcdaf";
        int n = x.length();
        int m = y.length();
        int t[][] = new int[n+1][m+1];

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                if (i==0 || j==0) {
                    t[i][j] = 0;
                } else {
                    if (x.charAt(i-1) == y.charAt(j-1)) {
                        t[i][j] = 1 + t[i-1][j-1];
                    } else {
                        t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                    }
                }
            }
        }
        StringBuffer sb =new StringBuffer();
        int i = n; int j = m;
        while (i > 0 && j > 0) {
            if (x.charAt(i-1) == y.charAt(j-1)) {
                sb.append(x.charAt(i-1));
                i--; j--;
            } else {
                if (t[i-1][j] > t[i][j-1]) {
                    sb.append(x.charAt(i-1));
                    i--;
                } else {
                    sb.append(y.charAt(j-1));
                    j--;
                }
            }
        }
        String ans = sb.reverse().toString();
        System.out.println("ans : " + ans);
    }
}
