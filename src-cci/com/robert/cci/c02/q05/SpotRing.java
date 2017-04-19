package com.robert.cci.c02.q05;

/**
 * 
 * 判断一个单链表是否存在一个环，如果存在返回表头到环头的长度。
 * 
 */
class LinkedListNode {
	int value;
	LinkedListNode next;

	LinkedListNode(int value, LinkedListNode next) {
		this.value = value;
		this.next = next;
	}
}

public interface SpotRing {
	int spotRing(LinkedListNode head);
}
