package com.dynamicProgramming;

import java.util.Map;
import java.util.HashMap;

public class ScrambleStringWithMemoization {
    static Map<String, Boolean> map = new HashMap<>();
    public static void main(String[] args) {
        String a = "great";
        String b = "rgate";
        boolean ans = false;
        if (a.length() == b.length()) {
            ans = solve(a, b);
        }
        System.out.println("ans : " + ans);
    }
    static boolean solve(String a, String b) {
        String key = a + "_" + b;
        if (a.length() <= 1) {
            map.put(key, false);
            return false;
        }
        if (a.equals(b)){
            map.put(key, true);
            return true;
        }
        int n = a.length();
        boolean flag = true;
        for (int i=1; i<n; i++) {
            boolean case1 = solve(a.substring(0,i), b.substring(n-i, n)) &&
                    solve(a.substring(i,n), b.substring(0,n-i));
            boolean case2 = solve(a.substring(0,i), b.substring(0,i)) &&
                    solve(a.substring(i, n), b.substring(i, n));
            if (case1 || case2) {
                flag = true;
                break;
            }
        }
        map.put(key, flag);
        return flag;
    }
}
