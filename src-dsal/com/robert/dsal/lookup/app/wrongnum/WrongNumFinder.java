package com.robert.dsal.lookup.app.wrongnum;

/**
 * 
 * 1到n之间的n个数不重复乱序，有一个数x变成了y，求这俩数。例如， 3变成了4，也就是有2个4，但是只有一个3。
 * 
 */
public interface WrongNumFinder {
	public int[] findWrongNum(int[] seq);
}
