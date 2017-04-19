package com.robert.dsal.tree.binary;

import java.util.LinkedList;
import java.util.List;

import com.robert.dsal.util.CollectionUtil;

public class BinaryTreeIteratorPreOrderRecusion implements BinaryTreeIteratorPreOrder {
    private void iterateBinaryTreePreOrder(BinaryTreeNode root, List<Integer> seq) {
        if (root == null)
            return;

        seq.add(root.value);
        iterateBinaryTreePreOrder(root.left, seq);
        iterateBinaryTreePreOrder(root.right, seq);
    }

    public int[] iterateBinaryTreePreOrder(BinaryTreeNode tree) {
        List<Integer> seq = new LinkedList<Integer>();

        iterateBinaryTreePreOrder(tree, seq);

        return CollectionUtil.convert(seq);
    }
}
