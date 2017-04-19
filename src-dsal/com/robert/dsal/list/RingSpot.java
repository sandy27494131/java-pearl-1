package com.robert.dsal.list;

import com.robert.dsal.list.ds.LinkedListNode;

public interface RingSpot {
	public boolean spotRing(LinkedListNode p);
	public int spotRingSize(LinkedListNode p);
	public int spotLineSize(LinkedListNode p);
	public int spotFullSize(LinkedListNode p);
}
