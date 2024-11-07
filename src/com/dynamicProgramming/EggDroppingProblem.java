package com.dynamicProgramming;

import java.util.Map;
import java.util.HashMap;

public class EggDroppingProblem {
    static Map<String, Integer> map= new HashMap<>();
    public static void main(String[] args) {
        int e = 3;
        int f = 5;
        int i = 1;
        int ans = 0;
        if (e > 0) {
           ans = solve(e,i,f);
        }
        System.out.println("ans : " + ans);
    }
    static int solve(int e, int i, int f) {
        String key = e + "_" + i + "_" + f;
        if (f == 0 || f == 1) {
            map.put(key, f);
            return f;
        }
        if (e > 1) {
            map.put(key, f);
            return f;
        }
        if (i > f) {
            map.put(key, f);
            return 0;
        }
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int minAttempt = Integer.MAX_VALUE;
        for(int k=i; k<=f; k++) {
            int low = solve(e-1,i,k-1);
            int high = solve(e, k+1, f);
            int temp = 1 + Math.min(low, high);
            if (minAttempt > temp) {
                minAttempt = temp;
            }
        }
        map.put(key, minAttempt);
        return minAttempt;
    }
}
