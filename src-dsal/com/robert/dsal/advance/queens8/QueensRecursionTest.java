package com.robert.dsal.advance.queens8;

import com.robert.dsal.util.DisplayUtil;

public class QueensRecursionTest {
	public void run() {
		Queens queens = new QueensRecursion();

		int[][] result = queens.calcPos(4);
		DisplayUtil.printMatrix("Four Queens: ", result);
	}

	public static void main(String[] args) {
		new QueensRecursionTest().run();
	}
}
