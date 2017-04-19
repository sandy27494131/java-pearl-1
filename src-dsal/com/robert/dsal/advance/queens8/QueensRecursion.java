package com.robert.dsal.advance.queens8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.robert.dsal.advance.optimumpath.Point;
import com.robert.dsal.util.CollectionUtil;

/**
 * 
 * <b>算法时间复杂度：</b><br>
 * O(2^n)<br>
 * 对于每一个单元格分为存在皇后和不存在皇后的两种情况，所以情况总数是 2^(n*n), 对于8个皇后的情况，结果是 2^64次运算。
 * 
 */
public class QueensRecursion implements Queens {
	private boolean isSameLine(Point o, Point o1) {
		if (o.x == o1.x || o.y == o1.y
				|| Math.abs(o1.x - o.x) == Math.abs(o1.y - o.y))
			return true;

		return false;
	}

	private boolean check(Stack<Point> stack, List<List<Integer>> result, int n) {
		if (stack.size() != n)
			return false;

		for (int i = 0; i < stack.size(); i++) {
			Point o = stack.get(i);
			for (int j = i + 1; j < stack.size(); j++) {
				Point o1 = stack.get(j);
				if (isSameLine(o, o1))
					return false;
			}
		}

		return true;
	}

	private void pushResult(Stack<Point> stack, List<List<Integer>> result) {
		List<Integer> oneResult = new ArrayList<Integer>();
		for (int i = 0; i < stack.size(); i++) {
			Point p = stack.get(i);
			oneResult.add(p.x);
			oneResult.add(p.y);
		}

		result.add(oneResult);
	}

	private void calcPos(int i, int j, int n, Stack<Point> stack,
			List<List<Integer>> result) {
		if (i >= n || j >= n || stack.size() > n)
			return;

		if (check(stack, result, n)) {
			pushResult(stack, result);
		}

		Point p = new Point();
		p.x = i;
		p.y = j;

		stack.push(p);
		calcPos(((j + 1) == n) ? i + 1 : i, ((j + 1) == n) ? 0 : j + 1, n,
				stack, result);
		stack.pop();
		calcPos(((j + 1) == n) ? i + 1 : i, ((j + 1) == n) ? 0 : j + 1, n,
				stack, result);
	}

	public int[][] calcPos(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Stack<Point> stack = new Stack<Point>();

		calcPos(0, 0, n, stack, result);

		return CollectionUtil.convertArray(result);
	}

}