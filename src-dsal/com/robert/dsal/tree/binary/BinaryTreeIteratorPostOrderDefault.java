package com.robert.dsal.tree.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.robert.dsal.util.CollectionUtil;

public class BinaryTreeIteratorPostOrderDefault implements BinaryTreeIteratorPostOrder {

    private void iterateBinaryTreePostOrder(Stack<BinaryTreeNode> stack, List<Integer> result) {
        BinaryTreeNode last = null;
        while (!stack.isEmpty()) {
            BinaryTreeNode top = stack.pop();

            // 后序和先序是一样的，只不过是什么时候打印根节点，后续是退出时打印，先序是推进时候打印
            if (top.left == null && top.right == null) {
            	//如果当前是叶子节点，保存last是当前节点
                last = top;
                
                //叶子节点无论是后序还是先序，都直接打印
                result.add(top.value);
            } else if (last != null && last == top.right) {
            	//如果是左右子树退回来，保存last是当前节点
                last = top;
                result.add(top.value);
            } else if (last != null && last == top.left) {
            	//如果是左右子树退回来，保存last是当前节点
                last = top;
                result.add(top.value);
            } else {
            	//如果不是，那么就是向前推进，需要先把根节点进栈，然后保存右子树和左子树
                stack.push(top);
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
    }

    public int[] iterateBinaryTreePostOrder(BinaryTreeNode tree) {
        List<Integer> result = new ArrayList<Integer>();

        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(tree);

        iterateBinaryTreePostOrder(stack, result);

        return CollectionUtil.convert(result);
    }
}
