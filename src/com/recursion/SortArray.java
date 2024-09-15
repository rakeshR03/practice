package com.recursion;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        SortArray test = new SortArray();
        int input[] = {2,3,7,6,4,5,9};
        test.sortArray(input, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    void sortArray(int[] arr, int i) {
        if (i == 0) {
            return;
        }
        int temp = arr[i];
        sortArray(arr, i-1);
        insert(arr,i-1, temp);
    }
    void insert(int[] arr, int pos, int temp) {
        if (pos == -1 || arr[pos] <= temp) {
            arr[pos+1] = temp;
            return;
        }
        int val = arr[pos];
        insert(arr, pos-1, temp);
        arr[pos+1] = val;
    }
}
