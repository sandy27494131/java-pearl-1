package com.robert.dsal.advance.findfirstmiddle;

/**
 * 
 * 给定一个数组A,它的长度为L， 找出一个这样的数组元素，比如他的下标是P， 其中0<=P<=L， 对于任意的T和R下标来说。 0<=T<=p<=R<=L,
 * A[T] < A[p] 并且 A[P] <= A[R]
 * 
 */

public interface FirstPositionElementFinder {
	public int findFirstPositionElement(int[] seq);
}
