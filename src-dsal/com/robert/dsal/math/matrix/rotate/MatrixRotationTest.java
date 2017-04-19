package com.robert.dsal.math.matrix.rotate;

import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.MatrixUtil;

public  class MatrixRotationTest {
	public static void main(String[] args) {
		int[][] m = MatrixUtil.genreateMatrix(5, 5);
		
		MatrixRotation mr = new MatrixRotationJumpIterate();
		
		DisplayUtil.printMatrix("Before", m);
		mr.rotateMatrix(m);
		DisplayUtil.printMatrix("After", m);
	}
}
