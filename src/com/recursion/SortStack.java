package com.recursion;

import java.util.*;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(10);
        stack.push(4);
        stack.push(1);

        sort(stack);
        System.out.println(stack);
    }

    static void sort(Stack<Integer> stack) {
        if (stack.size() == 1) {
            return;
        }
        int val = stack.pop();
        sort(stack);
        insertIntoStack(stack, val);
    }

    static void insertIntoStack(Stack<Integer> stack, int target) {
        if (stack.isEmpty() || stack.peek() <= target) {
            stack.push(target);
            return;
        }
        int val = stack.pop();
        insertIntoStack(stack, target);
        stack.push(val);
    }
}
