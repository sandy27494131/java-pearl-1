package com.robert.dsal.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.robert.dsal.util.CollectionUtil;

public class BinaryTreeIteratorInOrderDefault implements BinaryTreeIteratorInOrder {

    private void iterateBinaryTreeInOrder(Stack<BinaryTreeNode> stack, List<Integer> result) {
        BinaryTreeNode p = stack.pop();
        if (p == null)
            return;

        while (true) {
            if (p != null) {
            	// 如果p有左子树则p进栈，知道没有左子树了
                stack.push(p);
                p = p.left;
            } else if (!stack.isEmpty()) {
            	//直到没有左子树了，则从栈中取出一个，打印，这是中间节点，并且把p转为右子树
                p = stack.pop();
                result.add(p.value);
                p = p.right;
            } else {
                return;
            }
        }

    }

    public int[] iterateBinaryTreeInOrder(BinaryTreeNode tree) {
        List<Integer> result = new ArrayList<Integer>();

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(tree);

        iterateBinaryTreeInOrder(stack, result);

        return CollectionUtil.convert(result);
    }
}
