package com.robert.dsal.tree.binary;



public class BinaryTreeRotatorDefault implements BinaryTreeRotator{
    public BinaryTreeNode rotateLeft(BinaryTreeNode root) {
        if (root == null || root.left == null)
            return null;

        BinaryTreeNode left = root.left;
        root.left = left.right;
        left.right = root;

        return left;
    }

    public BinaryTreeNode rotateRight(BinaryTreeNode root) {
        if (root == null || root.right == null)
            return null;

        BinaryTreeNode right = root.right;
        root.right = right.left;
        right.left = root;

        return right;
    }
}
