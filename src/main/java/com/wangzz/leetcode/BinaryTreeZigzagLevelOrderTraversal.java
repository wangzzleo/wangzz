package com.wangzz.leetcode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode rootL = new TreeNode(2);
        TreeNode rootR = new TreeNode(1);
        TreeNode rootLL = new TreeNode(3);
        TreeNode rootLR = new TreeNode(4);
        TreeNode rootRL = new TreeNode(5);
        TreeNode rootRR = new TreeNode(6);
        root.left = rootL;
        root.right = rootR;
        rootL.left = rootLL;
        rootL.right = rootLR;
        rootR.left = rootRL;
        rootR.right = rootRR;
        BinaryTreeZigzagLevelOrderTraversal traversal = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(traversal.zigzagLevelOrder(root));
        System.out.println(traversal.count);
        System.out.println(traversal.zigzagLevelOrder_leetcode(root));
        System.out.println(traversal.count);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        SeqStack<TreeNode> stack = new SeqStack<>();
        stack.push(root);
        boolean toRight = false;
        ret.add(Arrays.asList(root.val));
        while (!stack.empty()) {
            SeqStack<TreeNode> tempStack = stack;
            stack = new SeqStack<>();
            List<Integer> innerList = new LinkedList<>();
            // 往右
            while (!tempStack.empty()) {
                count++;
                TreeNode node = tempStack.pop();
                if (toRight) {
                    addIfNotNull(innerList, stack, node.left);
                    addIfNotNull(innerList, stack, node.right);
                } else {
                    addIfNotNull(innerList, stack, node.right);
                    addIfNotNull(innerList, stack, node.left);
                }
            }
            if (!stack.empty()) {
                ret.add(innerList);
            }
            toRight = !toRight;
        }
        return ret;
    }

    public void addIfNotNull(List<Integer> list, Stack<TreeNode> stack, TreeNode node) {
        if (node != null) {
            list.add(node.val);
            stack.push(node);
        }
    }

    int count = 0;

    // 我就是想看下官方的表现
    public List<List<Integer>> zigzagLevelOrder_leetcode(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                count++;
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

}
