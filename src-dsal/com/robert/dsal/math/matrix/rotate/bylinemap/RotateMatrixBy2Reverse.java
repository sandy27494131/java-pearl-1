package com.robert.dsal.math.matrix.rotate.bylinemap;

public class RotateMatrixBy2Reverse extends RotateMatrixAbstract {
	protected void rotateLineByMap(int[][] matrix, Point[] lineMap) {
		reverse(matrix, lineMap, 0, lineMap.length);
		reverse(matrix, lineMap, 1, lineMap.length);
	}

	private void reverse(int[][] matrix, Point[] lineMap, int i, int j) {
		for (int k = i; k < (j - i) / 2; k++) {
			Point p1 = lineMap[k];
			Point p2 = lineMap[(j - 1) - (k - i)];

			// y is the row number and the x is the row number
			int temp = matrix[p1.y][p1.x];

			matrix[p1.y][p1.x] = matrix[p2.y][p2.x];

			matrix[p2.y][p2.x] = temp;
		}
	}

}
