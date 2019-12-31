package com.wangzz.struct.binarytree;


import java.util.LinkedList;
import java.util.List;

/**
 * @author wangzz
 * @date 2019年12月23日11:26:44
 */
public class Traversal {

    public static void main(String[] args) {
      TreeNode root = new TreeNode(6);
      TreeNode treeNode1 = new TreeNode(5);
      TreeNode treeNode11 = new TreeNode(3);
      treeNode1.left = treeNode11;
      treeNode11.left = new TreeNode(2);
      treeNode1.right = new TreeNode(4);
      TreeNode treeNode2 = new TreeNode(7);
      treeNode2.right = new TreeNode(8);
      root.left = treeNode1;
      root.right = treeNode2;

      List<TreeNode> preLinked = new LinkedList<>();
      List<TreeNode> inLinked = new LinkedList<>();
      List<TreeNode> postLinked = new LinkedList<>();
      preOrder(root, preLinked);
      inOrder(root, inLinked);
      postOrder(root, postLinked);
      System.out.println(preLinked);
      System.out.println(inLinked);
      System.out.println(postLinked);
    }

    public static void preOrder(TreeNode root, List<TreeNode> linkedList) {
        if (root != null) {
            linkedList.add(root);
            preOrder(root.left, linkedList);
            preOrder(root.right, linkedList);
        }
    }

    public static void inOrder(TreeNode root, List<TreeNode> linkedList) {
        if (root != null) {
            inOrder(root.left, linkedList);
            linkedList.add(root);
            inOrder(root.right, linkedList);
        }
    }

    public static void postOrder(TreeNode root, List<TreeNode> linkedList) {
        if (root != null) {
            postOrder(root.left, linkedList);
            postOrder(root.right, linkedList);
            linkedList.add(root);
        }
    }

    protected static class TreeNode {
        Integer value;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value.toString();
        }
    }

}
