package com.recursion;

import java.util.Stack;

public class DeleteMiddleElementInStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(10);
        stack.push(4);
        stack.push(1);

        int midElement = (stack.size() + 1) / 2;
        if (!stack.isEmpty()) {
            deleteElement(stack, midElement);
        }
        System.out.println(stack);
    }

    static void deleteElement(Stack<Integer> stack, int mid) {
        if (stack.size() <= mid) {
            stack.pop();
            return;
        }
        int val = stack.pop();
        deleteElement(stack, mid);
        stack.push(val);
    }
}
