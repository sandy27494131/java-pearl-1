package com.robert.dsal.string.strrotleft;

/**
 * 
 * 1. 通过移动字符实现，如果一次移动一个，那么得多次移动字符，如果一次移动多个，得较大的临时字符空间
 * 
 * 2. 两次反转不管要移动多少字符，只需要移动两次，只需要一个字符的临时空间，完全可以实现
 * 
 */

public interface StrRotateLeft {
	public void rotateLeft(char[] source, int size);
}
