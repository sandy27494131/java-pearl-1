package com.robert.dsal.string.strrotleft;

/**
 * 
 * ½»»»´ÎÊýO(n)
 */
public class StrRotateLeftReverseTwice implements StrRotateLeft {
	public void rotateLeft(char[] source, int size) {
		// ×ó±ÕÓÒ±Õ
		reverse(source, 0, source.length - 1);
		reverse(source, 0, source.length - size - 1);
		reverse(source, source.length - size, source.length - 1);
	}

	private void reverse(char[] source, int i, int j) {
		while (i < j) {
			swap(source, i++, j--);
		}
	}

	private void swap(char[] source, int i, int j) {
		char t = source[i];
		source[i] = source[j];
		source[j] = t;
	}

}
