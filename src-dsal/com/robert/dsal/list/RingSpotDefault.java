package com.robert.dsal.list;

import com.robert.dsal.list.ds.LinkedListNode;

public class RingSpotDefault implements RingSpot {
	public boolean spotRing(LinkedListNode p) {
		LinkedListNode s = p;
		if (s == null || s.next == null || s.next.next == null)
			return false;
		LinkedListNode f = s.next.next;

		while (s != null && f != null && f.next != null) {
			if (s == f)
				return true;

			s = s.next;
			f = f.next.next;
		}

		return false;
	}

	@Override
	public int spotRingSize(LinkedListNode p) {
		// TODO Not Done
		return 0;
	}

	@Override
	public int spotLineSize(LinkedListNode p) {
		// TODO Not Done
		return 0;
	}

	@Override
	public int spotFullSize(LinkedListNode p) {
		// TODO Not Done
		return 0;
	}

}
