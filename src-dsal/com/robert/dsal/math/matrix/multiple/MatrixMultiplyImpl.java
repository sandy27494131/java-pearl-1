package com.robert.dsal.math.matrix.multiple;

/**
 * <b>算法描述:</b><br>
 * 1. a[x][y] * b[y][z] = r[x][z], 矩阵a的列数必须等于矩阵b的行数。<br>
 * 2. 某一个元素r[i][j]等于矩阵a所在i行的元素乘以矩阵b所在j列的所有元素乘积之和。
 * <p>
 * <b>算法时间复杂度:</b><br>
 * O(N^3)
 * 
 */
public class MatrixMultiplyImpl implements MatrixMultiply {
	public int[][] multiply(int[][] a, int[][] b) {
		int arow = a.length, acol = a[0].length;
		int brow = b.length, bcol = b[0].length;
		if (acol != brow)
			return null;
		int rrow = arow, rcol = bcol;

		int[][] r = new int[rrow][rcol];
		for (int i = 0; i < rrow; i++)
			for (int j = 0; j < rcol; j++) {
				r[i][j] = 0;
				for (int k = 0; k < acol; k++)
					r[i][j] += a[i][k] * b[k][j];
			}

		return r;
	}

}
