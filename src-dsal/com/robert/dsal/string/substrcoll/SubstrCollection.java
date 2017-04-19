package com.robert.dsal.string.substrcoll;

/**
 * 
 * 求字符串S中长度为n的字符排列集和，比如 "abc"中长度为2的"ab"， "bc"
 * 
 */
public interface SubstrCollection {
	public char[][] calcAllSubstr(char[] s, int size);
}
