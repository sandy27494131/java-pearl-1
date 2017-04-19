package com.robert.dsal.lookup;

public class BinaryChopRecursiveLookup implements Lookup {

	public int lookup(int[] seq, int t) {
		return lookup(seq, 0, seq.length - 1, t);
	}

	private int lookup(int[] seq, int l, int r, int t) {
		int m = (l + r) / 2;

		if (seq[m] == t)
			return m;

		if (seq[m] < t)
			return lookup(seq, l, m - 1, t);
		else
			return lookup(seq, m + 1, r, t);
	}

	public int lookupFirst(int[] seq, int t) {
		return lookupFirst(seq, 0, seq.length - 1, t);
	}

	private int lookupFirst(int[] seq, int i, int j, int t) {
		if (i == j && t == seq[i])
			return i;

		int m = (i + j) / 2;

		if (t <= seq[m])
			j = m;
		else
			i = m + 1;

		return lookupFirst(seq, i, j, t);
	}

	public int lookupLast(int[] seq, int t) {
		return lookupLast(seq, 0, seq.length - 1, t);
	}

	private int lookupLast(int[] seq, int i, int j, int t) {
		if (i == j && t == seq[i])
			return i;

		int m = (i + j + 1) / 2;

		if (t >= seq[m])
			i = m;
		else
			j = m - 1;

		return lookupLast(seq, i, j, t);
	}
}
