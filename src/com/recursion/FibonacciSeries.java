package com.recursion;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }

    static int fibonacci(int num) {
        if (num <= 2) {
//            System.out.println(1);
            return 1;
        }
        int val = fibonacci(num-1) + fibonacci(num-2);
//        System.out.println(val);
        return val;
    }
}
