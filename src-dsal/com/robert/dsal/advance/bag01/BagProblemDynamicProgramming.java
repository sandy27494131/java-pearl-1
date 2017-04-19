package com.robert.dsal.advance.bag01;

/**
 * 
 * O(n * v), n是物品的数量， v是背包的容量，这是因为需要填二维表
 * 
 * 对象表：
		ID W V
		0  3  8
		1 10  5
		2  2  3
		3  8 20

      背包重量是： 13
      动态规划表：
 *  0  0  8  8  8  8  8  8  8  8  8  8  8 
 *  5  5  8  8  8  8  8  8  8  8  8  8 13 
 *  5  5  8  8 11 11 11 11 11 11 11 11 13 
 *  20 20 20 20 20 20 20 20 25 25 28 28 31 
 * 
 */
public class BagProblemDynamicProgramming implements BagProblem {
	public BagSolution bestSolution(Object[] objects, int volume) {
		int[][] matrix = new int[objects.length][volume];

		// 初始化第一排
		for (int i = 0; i < matrix[0].length; i++) {
			// i表示重量i + 1
			if (i + 1 < objects[0].weight)
				matrix[0][i] = 0;
			else
				matrix[0][i] = objects[0].value;
		}

		// 计算动态规划表
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				// 动态规划函数
				// matrix[i][j]= max(matrix[i-1][j-objects[i].weight] +
				// objects[i].value, matrix[i-1][j])
				matrix[i][j] = Math.max(includeCurrent(matrix, objects, i, j),
						excludeCurrent(matrix, i, j));
			}
		}

		// 调试输出
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.format("%2d ", matrix[i][j]);
			}
			System.out.println();
		}

		// 从右下角开始往左上角计算结构，如果某个值和前一个元素那个值相等，则不包含
		// 否则包含
		int i = matrix.length - 1;
		int j = matrix[0].length - 1;

		boolean[] vector = new boolean[matrix.length];
		while (i - 1 >= 0) {
			if (matrix[i][j] != matrix[i - 1][j]) {
				// 如果包含当前元素，那么下一行元素选取要跳跃当前元素的重量
				vector[i] = true;
				j -= objects[i].weight;
			}
			i--;
		}

		// 计算第一个个元素
		if (matrix[i][j] > 0)
			vector[0] = true;

		return new BagSolution(objects, vector, volume,
				matrix[matrix.length - 1][matrix[0].length - 1]);
	}

	private int includeCurrent(int[][] matrix, Object[] objects, int i, int j) {
		// 越界就返回当前值
		if (i - 1 < 0 || j - objects[i].weight < 0)
			return objects[i].value;

		// 不越界就返回从前i-1个物体里面选出不包括当前物体的价值，加上当前物体的价值，也就是计算出包含当前物体的价值
		return matrix[i - 1][j - objects[i].weight] + objects[i].value;
	}

	private int excludeCurrent(int[][] matrix, int i, int j) {
		// 越界返回0
		if (i - 1 < 0 || j < 0)
			return 0;

		// 返回前i-1个物理能够产生的最大值，也就是不包含当前物体
		return matrix[i - 1][j];
	}
}
