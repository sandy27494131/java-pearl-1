package com.robert.dsal.math.matrix.rotate.bylinemap;


public class RotateMatrixImpl extends RotateMatrixAbstract{
	protected void rotateLineByMap(int[][] matrix, Point[] lineMap) {
		int temp = matrix[lineMap[lineMap.length - 1].y][lineMap[lineMap.length - 1].x];

		for (int i = lineMap.length - 1; i > 0; i--) {
			Point p1 = lineMap[i];
			Point p2 = lineMap[i - 1];

			matrix[p1.y][p1.x] = matrix[p2.y][p2.x];
		}

		Point point0 = lineMap[0];
		matrix[point0.y][point0.x] = temp;
	}

}
