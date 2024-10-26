package com.recursion;

import java.util.ArrayList;
import java.util.List;


public class JosephusProblem {
    public static void main(String[] args) {
        int n = 40, k = 7;
        List<Integer> list = new ArrayList<>();
        for( int i=1; i<=n; i++) {
            list.add(i);
        }
        solve(list, k-1, 0);
    }

    static void solve(List<Integer> list, int k, int index) {
        if (list.size() == 1) {
            System.out.println(list.get(0));
            return;
        }
        int ind = (index + k) % list.size();
        list.remove(ind);
        solve(list, k, ind);
    }
}
