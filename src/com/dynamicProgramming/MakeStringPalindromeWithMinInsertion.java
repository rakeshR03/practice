package com.dynamicProgramming;

public class MakeStringPalindromeWithMinInsertion {
    public static void main(String[] args) {
        String x = "aebcbda";
        String y = reverse(x);
        int n = x.length();
        int t[][] = new int[n+1][n+1];

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
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
        int lps = t[n][n];
        int minInsertion = n - lps;
        System.out.println("ans : " +minInsertion);
    }

    static String reverse(String x) {
        StringBuffer sb = new StringBuffer(x);
        return sb.reverse().toString();
    }
}
