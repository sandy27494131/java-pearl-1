package com.robert.dsal.list.app.delrange;

import com.robert.dsal.list.ds.LinkedListNode;

/**
 * 
 * 已知线性表中的元素以值递增有序排列，并以单链表作存储结构。试写一高效的算法，删除表中所有值大于mink且小于maxk的元素（若表中存在这样的元素），
 * 同时释放被删结点空间，并分析你的算法的时间复杂度（注意，mink和maxk是给定的两个参变量，它们的值可以和表中的元素相同，也可以不同）。
 * 
 */
public interface DeleteRange {
	LinkedListNode deleteRange(LinkedListNode head, int start, int end);
}
