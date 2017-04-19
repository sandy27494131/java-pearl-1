package com.robert.dsal.list;

import com.robert.dsal.list.ds.LinkedListNode;
import com.robert.dsal.util.DataUtil;

public class RingSpotTest {
	public void run() {
		LinkedListNode p = DataUtil.genRingLinkedList(6, 1);

		RingSpot rs = new RingSpotDefault();
		boolean b = rs.spotRing(p);
		System.out.println(b);
	}

	public static void main(String[] args) {
		new RingSpotTest().run();
	}
}
