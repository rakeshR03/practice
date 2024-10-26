package com.recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(10);
        stack.push(4);
        stack.push(1);

        reverse(stack);
        System.out.println(stack);
    }

    static void reverse(Stack<Integer> stack) {
        if (stack.size() <= 1) {
            return;
        }
        int val = stack.pop();
        reverse(stack);
        insert(stack, val);
    }

    static void insert(Stack<Integer> stack, int target) {
        if (stack.isEmpty()) {
            stack.push(target);
            return;
        }
        int val = stack.pop();
        insert(stack, target);
        stack.push(val);
    }
}
