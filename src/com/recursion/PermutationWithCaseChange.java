package com.recursion;

public class PermutationWithCaseChange {
    public static void main(String[] args) {
        String str = "ab";
        solve("", str, 0);
    }

    static void solve(String output, String input, int index) {
        if (index == input.length()) {
            System.out.println(output);
            return;
        }
        String output1 = output + input.charAt(index);
        String output2 = output + Character.toUpperCase(input.charAt(index));
        solve(output1, input, index+1);
        solve(output2, input, index+1);
    }
}
