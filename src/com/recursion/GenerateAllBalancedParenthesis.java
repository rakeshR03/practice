package com.recursion;

public class GenerateAllBalancedParenthesis {
    public static void main(String[] args) {
        int n=3;
        solve("", 3, 3);
    }

    static void solve(String ans, int open, int close) {
        if (open == 0 && close == 0) {
            System.out.println(ans);
            return;
        }
        if (open > 0 ) {
            String output = ans + '(';
            solve(output, open-1, close);
        }
        if (close > open) {
            String output = ans + ')';
            solve(output, open, close-1);
        }


    }
}
