package com.recursion;

public class KthGrammar {
    public static void main(String[] args) {
        int i=0;
        int ans = solve(2,3);
        System.out.println("ans : " + ans);
    }
    static int solve(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        int mid = (int)Math.pow(2, n)/2;
        if (k < mid) {
            return solve(n-1, k);
        } else {
            return (solve(n-1, k-mid) == 0 ? 1 : 0);
        }
    }
}
