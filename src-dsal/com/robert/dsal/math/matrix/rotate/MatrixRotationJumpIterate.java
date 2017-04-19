package com.robert.dsal.math.matrix.rotate;

public class MatrixRotationJumpIterate implements MatrixRotation {
	public void rotateMatrix(int[][] a) {
		int s = a.length;
		int times = s / 2;

		// 每层开始元素的x,y都是x， 即(0,0)(1,1)(2,2)
		// x表示的行数
		for (int x = 0; x < times; x++) {
			// 对于每层每次减少两个元素，并且每层的列都是从x开始的
			// y表示的是列数
			for (int y = x; y < s - 1 * (x + 1); y++) {
				System.out.println(x + ":" + y);
				int t = a[s - 1 - y][x];
				a[s - 1 - y][x] = a[s - 1 - x][s - 1 - y];
				a[s - 1 - x][s - 1 - y] = a[y][s - 1 - x];
				a[y][s - 1 - x] = a[x][y];
				a[x][y] = t;
			}
		}
	}
}