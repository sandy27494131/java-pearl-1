package com.robert.dsal.lookup;

public interface Lookup {
	public int lookup(int[] seq, int t);

	public int lookupFirst(int[] seq, int t);

	public int lookupLast(int[] seq, int t);
}
