package com.robert.cci.c02.q02;

/**
 * 
 * 找到单链表中倒数第n个元素。
 * 
 */

class LinkedListNode {
	LinkedListNode next;
}

public interface Nth2LastElementFinder {
	public LinkedListNode findNth2LastElement(LinkedListNode head, int n);
}
