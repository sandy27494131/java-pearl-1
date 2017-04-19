package com.robert.dsal.string.strrotleft;

/**
 * 
 *  ±º‰∏¥‘”∂»O(size*n)
 * 
 */
public class StrRotateLeftBruteForce1 implements StrRotateLeft {
	public void rotateLeft(char[] source, int size) {
		for (int i = 0; i < size; i++) {
			shiftLeft(source);
		}
	}

	private void shiftLeft(char[] source) {
		char t = source[0];

		for (int i = 1; i <= source.length - 1; i++) {
			source[i - 1] = source[i];
		}

		source[source.length - 1] = t;
	}

}
