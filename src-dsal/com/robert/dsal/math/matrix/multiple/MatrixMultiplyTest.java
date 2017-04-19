package com.robert.dsal.math.matrix.multiple;

import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class MatrixMultiplyTest {
	public void run() {
		int[][] a = DataUtil.genMatrix(3, 4);
		int[][] b = DataUtil.genMatrix(4, 5);

		DisplayUtil.printMatrix("a: ", a);
		DisplayUtil.printMatrix("b: ", b);

		MatrixMultiply mm = new MatrixMultiplyImpl();

		int[][] r = mm.multiply(a, b);

		DisplayUtil.printMatrix("r: ", r);

		TestUtil.assertEqual(r.length, a.length);
		TestUtil.assertEqual(r[0].length, b[0].length);
	}

	public static void main(String[] args) {
		new MatrixMultiplyTest().run();
	}

}
