package com.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        solve(3, 1,3,2);
    }
    static void solve (int i, int src, int dest, int help) {
        if (i == 0) {
//            System.out.println(String.format("if: move %1s plate from %2s to %3s",i, src, dest));
            return;
        }
        solve(i-1, src, help, dest);
        System.out.println(String.format("move %1s plate from %2s to %3s", i, src, dest));
        solve(i-1, help, dest, src);
    }
}
