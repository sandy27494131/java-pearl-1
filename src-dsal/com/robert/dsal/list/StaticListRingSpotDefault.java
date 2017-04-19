package com.robert.dsal.list;

public class StaticListRingSpotDefault implements StaticListRingSpot {
	public boolean spotRing(int[] seq) {
		if (seq == null || seq.length == 0)
			return false;
		int s = 0;

		if (seq[0] < 0 || seq[0] > seq.length - 1)
			return false;

		int f = seq[seq[0]];
		while (s >= 0 && s <= seq.length - 1 && f >= 0 && f <= seq.length - 1
				&& s != f) {
			s = seq[s];
			f = seq[seq[f]];
		}

		return s == f;
	}

	public int spotRingSize(int[] seq) {
		int s = 0;
		int f = seq[seq[0]];
		while (s != f) {
			s = seq[s];
			f = seq[seq[f]];
		}

		// 现在相遇点一定在环上，那么只走s，到下一次遇见自己就是环的长度
		f = seq[seq[s]];
		int count = 1;
		while (s != f) {
			count++;

			s = seq[s];
			f = seq[seq[f]];
		}

		return count;
	}
}
