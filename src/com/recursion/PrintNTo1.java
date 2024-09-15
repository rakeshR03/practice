package com.recursion;

public class PrintNTo1 {
    public static void main(String[] args) {
//        PrintNTo1 test = new PrintNTo1();
//        test.printNTo1(7);
        printNTo1(7);
    }

    static void printNTo1(int num) {
        if (num == 0) {
            return;
        }
        System.out.print(num);
        printNTo1(num-1);
    }
}
