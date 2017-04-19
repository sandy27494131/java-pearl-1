package com.robert.dsal.advance.sumcoll;

import java.util.ArrayList;
import java.util.List;

import com.robert.dsal.util.CollectionUtil;

// TODO 如何用动态规划？

/* 解题思路： 
 * 
 * 这道题的思路参考0-1背包：定义函数F(n,m)来求解这个问题，那么F(n,m)可以分解为两个子问题F(n-1,m)和F(n-1,m-n).
 * 由于题目要求列出所有的组合，使用类似动态规划的方法比较复杂，我在这里直接使用递归来解决这个问题。
 * 虽然效率可能不是很好，但是代码的可读性还是比较好的。
 * 
 */

public class SumProblemBruteForce implements SumProblem {

	private static void printSolution(int[] flags, List<List<Integer>> result) {
		List<Integer> solution = new ArrayList<Integer>();

		for (int i = 0; i < flags.length; i++) {
			if (flags[i] == 1)
				solution.add(i + 1);
		}

		result.add(solution);
	}

	private static void solveBagProblem(int n, int m, int[] flags,
			List<List<Integer>> result) {
		if (n < 1 || m < 1)
			return;

		if (m < n)
			n = m;

		if (m == n) {
			flags[n - 1] = 1;
			printSolution(flags, result);

			flags[n - 1] = 0;
			solveBagProblem(n - 1, m, flags, result);
			return;
		}

		flags[n - 1] = 1;
		solveBagProblem(n - 1, m - n, flags, result);

		flags[n - 1] = 0;
		solveBagProblem(n - 1, m, flags, result);
	}

	public int[][] solveSumProblem(int n, int m) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] flags = new int[n];

		solveBagProblem(n, m, flags, result);

		return CollectionUtil.convertArray(result);
	}
}
