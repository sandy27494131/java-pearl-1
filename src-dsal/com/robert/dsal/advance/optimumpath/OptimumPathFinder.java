package com.robert.dsal.advance.optimumpath;

/**
 * 
 * 从矩阵的左上角往右下角走，每次只能往下或者往右走一步，没走过一步，都有一个权值，怎么走最后的权值最大？
 * 
 * 1.蛮力法 2.累加和法
 * 
 */

public interface OptimumPathFinder {
	public static class OptimumPath {
		public Point[] points;
		public int pathValue;
	}

	public OptimumPath findOptimumPath(int[][] matrix);
}
