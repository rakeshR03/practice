package com.recursion;

public class LetterCasePermutation {
    public static void main(String[] args) {
        String str = "a1B2";
        solve("", str);
    }
    static void solve(String output, String input) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }
        if (Character.isLetter(input.charAt(0)) || Character.isUpperCase(input.charAt(0))) {
            String output1 = output + Character.toLowerCase(input.charAt(0));
            String output2 = output + Character.toUpperCase(input.charAt(0));
            solve(output1, input.substring(1));
            solve(output2, input.substring(1));
        } else {
            output = output + input.charAt(0);
            solve(output, input.substring(1));
        }
    }
}
