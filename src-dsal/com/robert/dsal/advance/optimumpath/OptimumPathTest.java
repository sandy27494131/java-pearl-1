package com.robert.dsal.advance.optimumpath;

import com.robert.dsal.advance.optimumpath.OptimumPathFinder.OptimumPath;
import com.robert.dsal.util.DataUtil;
import com.robert.dsal.util.DisplayUtil;

public class OptimumPathTest {

	public void run() {
		int[][] matrix = DataUtil.genMatrix(3, 3);
		DisplayUtil.printMatrix("The Matrix", matrix);

		OptimumPathFinder opf = new OptimumPathFinderBruteForce();
		OptimumPath op = opf.findOptimumPath(matrix);

		System.out.format("The solution is: [%d] --- ", op.pathValue);
		for (Point p : op.points) {
			System.out.format("(%d, %d) ", p.x, p.y);
		}
		System.out.println();

		OptimumPathFinder opf1 = new OptimumPathFinderByCumulativeSum();
		OptimumPath op1 = opf1.findOptimumPath(matrix);

		System.out.format("The solution is: [%d] --- ", op1.pathValue);
		for (Point p : op1.points) {
			System.out.format("(%d, %d) ", p.x, p.y);
		}

		System.out.println();
	}

	public static void main(String[] args) {
		new OptimumPathTest().run();
	}

}
