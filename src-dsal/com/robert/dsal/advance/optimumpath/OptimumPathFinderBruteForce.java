package com.robert.dsal.advance.optimumpath;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * O(2^(n*n)), 指数级
 * 
 */
public class OptimumPathFinderBruteForce implements OptimumPathFinder {

	private void checkSolution(int[][] matrix, List<Point> solutionPool,
			OptimumPath solution) {
		int sum = 0;
		for (Point point : solutionPool) {
			sum += matrix[point.x][point.y];
		}

		if (sum > solution.pathValue) {
			solution.pathValue = sum;
			solution.points = solutionPool.toArray(new Point[0]);
		}
	}

	private void findOptimumPath(int[][] matrix, int x, int y,
			List<Point> solutionPool, OptimumPath solution) {
		// 1.先把当前状态添加 2.检查解决方案 3.递归下一步 4.清除当前状态，退回上一部

		Point self = new Point();
		self.x = x;
		self.y = y;
		solutionPool.add(self);

		// 进入的点到达了最后一个点，则是解决方案
		if (x == matrix.length - 1 && y == matrix[0].length - 1) {
			checkSolution(matrix, solutionPool, solution);
			solutionPool.remove(self);
			return;
		}

		// 往下走
		if (x != matrix.length - 1) {
			findOptimumPath(matrix, x + 1, y, solutionPool, solution);
		}

		// 往右走
		if (y != matrix[0].length - 1) {
			findOptimumPath(matrix, x, y + 1, solutionPool, solution);
		}

		// 一定要清除当前状态，退回到上一步
		solutionPool.remove(self);
	}

	public OptimumPath findOptimumPath(int[][] matrix) {
		OptimumPath solution = new OptimumPath();
		List<Point> solutionPool = new ArrayList<Point>();

		findOptimumPath(matrix, 0, 0, solutionPool, solution);

		return solution;
	}

}
