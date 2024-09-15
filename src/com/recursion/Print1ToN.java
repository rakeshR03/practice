package com.recursion;

public class Print1ToN {
    public static void main(String[] args) {
        Print1ToN print = new Print1ToN();
        print.print1ToN(7);
    }
    void print1ToN(int num) {
        if (num == 0) {
            return;
        }
        print1ToN(num-1);
        System.out.print(num);
    }
}


