package com.recursion;

public class PrintN_bitBinaryNumber {
    public static void main(String[] args) {
        int n = 3;
        solve("", 0, 0, n);
    }

    static void solve (String ans, int countOfOne, int countOfZero, int n) {
        if (ans.length() == n) {
            System.out.println(ans);
            return;
        }
        String ans1 = ans + '1';
        solve(ans1, countOfOne+1, countOfZero, n);
        if (countOfOne > countOfZero) {
            String ans2 = ans + '0';
            solve(ans2, countOfOne, countOfZero+1, n);
        }
    }
}
