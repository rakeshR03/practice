package com.practice;

public class FindSecondHighestNumber {
    public static void main(String[] args) {
        int ar[] = {-1,-2,-3,-4,-5};
        int secondMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i=0; i<ar.length; i++) {
            System.out.println("max : " + max+", min : " + secondMax);
            if (max < ar[i]) {
                secondMax = max;
                max = ar[i];
            } else if (secondMax < ar[i]) {
                secondMax = ar[i];
            }
        }
        System.out.println("second maximum : " + secondMax);
    }
}
