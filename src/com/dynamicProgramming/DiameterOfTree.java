package com.dynamicProgramming;

public class DiameterOfTree {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        int[] res = new int[1];
        int ans = findDiameter(node, res);
        System.out.println("ans : " + res[0]);
    }
    static int findDiameter(Node node, int[] res) {
        if (node == null) {
            return 0;
        }
        int leftHeight = findDiameter(node.left, res);
        int rightHeight = findDiameter(node.right, res);

        int diameter = 1 + leftHeight + rightHeight;
        int height = 1 + Math.max(leftHeight, rightHeight);
        if (res[0] < diameter) {
            res[0] = diameter;
        }
        return height;
    }
}

