package com.robert.dsal.util;

import java.util.Date;
import java.util.Random;

public class MatrixUtil {
	public static int[][] genreateMatrix(int width, int height) {
		int[][] matrix = new int[height][width];

		Random random = new Random(new Date().getTime());
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = random.nextInt(10);
			}
		}

		return matrix;
	}

	public static int[][] genreateMatrix(int div) {
		return genreateMatrix(div, div);
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
