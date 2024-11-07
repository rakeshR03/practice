package com.dynamicProgramming;

public class ConvertStringAToBWithMinimumInsertionAndDeletion {
    public static void main(String[] args) {
        String x = "heap";
        String y = "pea";
        int n = x.length();
        int m = y.length();
        int t[][] = new int[n+1][m+1];
        for (int i=0; i<=n; i++) {
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
        int deletion = n - lcs;
        int insertion = m - lcs;
        System.out.println("deletion : " + deletion + ", insertion : " + insertion);
    }
}
