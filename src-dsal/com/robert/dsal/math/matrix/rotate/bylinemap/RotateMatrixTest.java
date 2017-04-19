package com.robert.dsal.math.matrix.rotate.bylinemap;

import com.robert.dsal.util.MatrixUtil;

public class RotateMatrixTest {

	public static void main(String[] args) {
		RotateMatrix rmDefault = new RotateMatrixImpl();

		RotateMatrix rmBy2Reverse = new RotateMatrixBy2Reverse();

		int[][] matrix1 = MatrixUtil.genreateMatrix(8);

		MatrixUtil.printMatrix(matrix1);

		rmDefault.rotateMatrix(matrix1);

		rmBy2Reverse.rotateMatrix(matrix1);

		MatrixUtil.printMatrix(matrix1);
	}

}
