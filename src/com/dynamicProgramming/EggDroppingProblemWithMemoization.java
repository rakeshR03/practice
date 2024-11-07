package com.dynamicProgramming;

import java.util.Arrays;

public class EggDroppingProblemWithMemoization {
    static int t[][] = new int[10][10];
    public static void main(String[] args) {
        int e = 3;
        int f = 5;
        for(int i=0; i<=e; i++) {
            Arrays.fill(t[i], -1);
        }
        int ans = 0;
        if (e > 0) {
            ans = solve(e,f);
        }
        System.out.println("ans : " + ans);
    }
    static int solve(int e, int f) {
        if (f == 0 || f == 1) {
            t[e][f] = f;
            return f;
        }
        if (e > 1) {
            t[e][f] = f;
            return f;
        }
        if (t[e][f] != -1) {
            return t[e][f];
        }
        int minAttempt = Integer.MAX_VALUE;
        for(int k=1; k<=f; k++) {
            int low = solve(e-1,k-1);
            int high = solve(e, f-k);
            int temp = 1 + Math.min(low, high);
            if (minAttempt > temp) {
                minAttempt = temp;
            }
        }
        t[e][f] = minAttempt;
        return minAttempt;
    }
}
