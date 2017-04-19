package com.robert.dsal.advance.optimumpath;

import java.util.ArrayList;
import java.util.List;

// TODO 同样用动态规划，如果从右下角往左上角推，一次选择左边或者上面最大的，那么只需要O(n)空间复杂度

/**
 * 
 * O(n^2), 对于矩阵中的所有元素，正比于线性, 空间复杂度O(n^2)
 * 
 */
public class OptimumPathFinderByCumulativeSum implements OptimumPathFinder {
	public OptimumPath findOptimumPath(int[][] matrix) {
		OptimumPath solution = new OptimumPath();
		int[][] sum = matrix.clone();

		// 到达矩阵中某一点有两种可能，一种就是从左边过来，一种是从上边过来，左边和上边取最大的加到当前元素，最后一个元素的累加和就是最有路径的权值之和
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum.length; j++) {
				int max = 0;
				if (i - 1 >= 0 && sum[i - 1][j] > max)
					max = sum[i - 1][j];

				if (j - 1 >= 0 && sum[i][j - 1] > max)
					max = sum[i][j - 1];

				sum[i][j] += max;
			}
		}

		// 最后一个元素的累加和就是最优路径的权值之和
		List<Point> points = new ArrayList<Point>();
		int x = sum.length - 1;
		int y = sum[0].length - 1;
		solution.pathValue = sum[x][y];

		// 从最后一个元素开始回退，左边元素和上边元素哪个大就推到哪去
		while (x >= 0 && y >= 0) {
			Point p = new Point();
			p.x = x;
			p.y = y;
			points.add(p);

			if (x == 0)
				y--;
			else if (y == 0)
				x--;
			else if (sum[x - 1][y] > sum[x][y - 1])
				x--;
			else {
				y--;
			}
		}

		solution.points = points.toArray(new Point[0]);

		return solution;
	}
}
