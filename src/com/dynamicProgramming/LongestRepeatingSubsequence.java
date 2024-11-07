package com.dynamicProgramming;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "AABEBCDD";
        String str1 = str;
        int n = str.length();
        int t[][] = new int[n+1][n+1];

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                if (i==0 || j==0) {
                    t[i][j] = 0;
                } else{
                    if (str.charAt(i-1) == str1.charAt(j-1) && i != j) {
                        t[i][j] = 1 + t[i-1][j-1];
                    } else {
                        t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                    }
                }
            }
        }
        System.out.println("ans : " + t[n][n]);
    }
}
