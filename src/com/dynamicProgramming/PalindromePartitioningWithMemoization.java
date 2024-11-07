package com.dynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioningWithMemoization {
    static int t[][] = new int[10][10];
    public static void main(String[] args) {
        String s = "nitik";
        int n = s.length();
        for (int i=0; i<n; i++) {
            Arrays.fill(t[i], -1);
        }
        int ans = solve(s, 0, n-1);
        System.out.println("ans : " + ans);
    }
    static int solve(String s, int i, int j) {
        if (i >= j) {
            return t[i][j] = 0;
        }
        if (t[i][j] != -1) {
            return t[i][j];
        }
        if (isPalindrome(s, i, j)) {
            return t[i][j] = 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k=i; k<j; k++) {
            int temp = 1 + solve(s, i, k) + solve(s, k+1, j);
            if (temp < min) {
                min = temp;
            }
        }
        return t[i][j] = min;
    }

    static boolean isPalindrome(String s, int i, int j) {
        while (i<j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
