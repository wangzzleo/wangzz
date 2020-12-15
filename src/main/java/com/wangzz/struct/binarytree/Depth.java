package com.wangzz.struct.binarytree;

public class Depth {

    static class TreeNode {

        int value;

        TreeNode left;
        TreeNode right;

        TreeNode (int value) {
            this.value = value;
        }
    }

    static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(maxDepth(root));
        System.out.println("请求栈的次数：" + count);
    }

    public static int maxDepth (TreeNode root) {
        count++;
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
