package com.dynamicProgramming;

public class MaximumPathSum {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(10);
        node.left.left = new Node(20);
        node.left.right = new Node(1);
        node.right.right = new Node(-25);
        node.right.right.left = new Node(3);
        node.right.right.right = new Node(4);
        int[] res = new int[1];

        findMaxPathSum(node, res);
        System.out.println("ans : " + res[0]);
    }

    static int findMaxPathSum(Node root, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftVal = findMaxPathSum(root.left, res);
        int rightVal = findMaxPathSum(root.right, res);

        int temp = Math.max(root.val + Math.max(leftVal, rightVal), root.val);
        int pathSum = root.val + leftVal + rightVal;
        if (res[0] < pathSum) {
            res[0] = pathSum;
        }
        return temp;
    }
}

