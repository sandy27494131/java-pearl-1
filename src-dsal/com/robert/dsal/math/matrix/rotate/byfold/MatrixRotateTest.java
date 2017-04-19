package com.robert.dsal.math.matrix.rotate.byfold;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;

public class MatrixRotateTest {

	public void run() {
		int[][] m = DataUtil.genMatrix(4, 4);
		MatrixRotate mrl = new MatrixRotateByFold();
		int[][] result = mrl.rotateLeft(m);
		int[][] result1 = mrl.rotateRight(m);

		DisplayUtil.printMatrix("Before Rotate", m);
		DisplayUtil.printMatrix("After Rotate", result);
		DisplayUtil.printMatrix("After Rotate", result1);
	}

	public static void main(String[] args) {
		new MatrixRotateTest().run();
	}

}
