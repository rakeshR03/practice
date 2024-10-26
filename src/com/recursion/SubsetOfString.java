package com.recursion;

public class SubsetOfString {
    public static void main(String[] args) {
        String s = "ab";
        char[] charArr = s.toCharArray();
        subset("", charArr, 0);
    }

    static void subset(String output, char[] input, int index) {
        if (index == input.length) {
            System.out.println(output);
            return;
        }
        String output1 = output;
        String output2 = output + input[index];
        subset(output1, input, index+1);
        subset(output2, input, index+1);
    }
}
