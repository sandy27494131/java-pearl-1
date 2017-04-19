package com.robert.dsal.advance.sumcoll;

import com.robert.dsal.util.DisplayUtil;

public class SumProblemTest{

	public void run() {
		SumProblem bp = new SumProblemBruteForce();

		int[][] result = bp.solveSumProblem(10, 20);

		System.out.println("Num: " + result.length);
		DisplayUtil.printMatrix("Solutions", result);
	}

	public static void main(String[] args) {
		new SumProblemTest().run();
	}
}
