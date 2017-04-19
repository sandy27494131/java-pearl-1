package com.robert.dsal.math.matrix.rotate.bylinemap;

public abstract class RotateMatrixAbstract implements RotateMatrix {
	class Point implements Cloneable {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Object clone() {
			try {
				return super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	public void rotateMatrix(int[][] matrix) {
		for (int l = 0; l < matrix.length / 2; l++) {
			rotateLine(matrix, l);
		}
	}

	private void rotateLine(int[][] matrix, int l) {
		Point[] lineMap = createLineMap(matrix, l);

		rotateLineByMap(matrix, lineMap);
	}

	protected abstract void rotateLineByMap(int[][] matrix, Point[] lineMap);

	private Point[] createLineMap(int[][] matrix, int l) {
		Point[] result = new Point[(matrix.length - 2 * l - 1) * 4];

		int n = matrix.length;
		int count = 0;
		for (int i = l; i < n - 1 - l; i++) {
			result[count++] = new Point(i, l);

		}

		for (int i = l; i < n - 1 - l; i++) {
			result[count++] = new Point(n - 1 - l, i);

		}

		for (int i = n - 1 - l; i > l; i--) {
			result[count++] = new Point(i, n - 1 - l);

		}

		for (int i = n - 1 - l; i > l; i--) {
			result[count++] = new Point(l, i);

		}

		return result;
	}

}