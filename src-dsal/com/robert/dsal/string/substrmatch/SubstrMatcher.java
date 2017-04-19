package com.robert.dsal.string.substrmatch;

/*
 * 在源串中查找目标串，如果存在则返回目标串在源串中的开始索引，如果不存在返回null或者-1
 */
public interface SubstrMatcher {

	public int[] indexesOf(char[] source, char[] target);

	public int indexOf(char[] source, char[] target);

}
