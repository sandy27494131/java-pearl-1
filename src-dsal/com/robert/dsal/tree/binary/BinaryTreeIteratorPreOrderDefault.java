package com.robert.dsal.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.robert.dsal.util.CollectionUtil;

public class BinaryTreeIteratorPreOrderDefault implements BinaryTreeIteratorPreOrder {

    private void iterateBinaryTreePreOrder(Stack<BinaryTreeNode> stack, List<Integer> result) {
        BinaryTreeNode last = null;
        while (!stack.isEmpty()) {
            BinaryTreeNode top = stack.pop();

            if (top.left == null && top.right == null) {
                last = top;
                result.add(top.value);
            } else if (last != null && last == top.right) {
                last = top;
            } else if (last != null && last == top.left) {
                last = top;
            } else {
                stack.push(top);
                result.add(top.value);
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
    }

    public int[] iterateBinaryTreePreOrder(BinaryTreeNode tree) {
        List<Integer> result = new ArrayList<Integer>();

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(tree);

        iterateBinaryTreePreOrder(stack, result);

        return CollectionUtil.convert(result);
    }
}
