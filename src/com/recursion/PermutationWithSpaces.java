package com.recursion;
import java.util.*;

public class PermutationWithSpaces {
    public static void main(String[] args) {
        String s = "ABC";
        solve("A", s, 1);
    }

    static void solve(String output, String input, int index) {
        if (index == input.length()) {
            System.out.println(output);
            return;
        }
        String output1 = output + input.charAt(index);
        String output2 = output + "_" + input.charAt(index);

        solve(output1, input, index+1);
        solve(output2, input, index+1);
    }
}
