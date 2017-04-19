package com.robert.dsal.tree.binary;

import java.util.LinkedList;
import java.util.List;

import com.robert.dsal.util.CollectionUtil;

public class BinaryTreeIteratorPostOrderRecusion implements BinaryTreeIteratorPostOrder {
    public int[] iterateBinaryTreePostOrder(BinaryTreeNode tree) {
        List<Integer> seq = new LinkedList<Integer>();

        iterateBinaryTreeInOrder(tree, seq);

        return CollectionUtil.convert(seq);

    }

    private void iterateBinaryTreeInOrder(BinaryTreeNode root, List<Integer> seq) {
        if (root == null)
            return;

        iterateBinaryTreeInOrder(root.left, seq);
        iterateBinaryTreeInOrder(root.right, seq);
        seq.add(root.value);
    }
}
