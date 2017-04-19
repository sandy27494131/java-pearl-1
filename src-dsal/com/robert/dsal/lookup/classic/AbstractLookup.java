package com.robert.dsal.lookup.classic;

public abstract class AbstractLookup implements Lookup {
	protected int[] seq;

	public void setup(int[] seq) {
		this.seq = seq;
	}

	public abstract int lookup(int t);
}
