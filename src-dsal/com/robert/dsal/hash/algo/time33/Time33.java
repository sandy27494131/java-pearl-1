package com.robert.dsal.hash.algo.time33;

public class Time33 {
	public int hash(String s) {
		int hash = 0;

		for (int i = 0; i < s.length(); i++) {
			// Sometimes it is 31
			hash += hash * 33 + s.charAt(i);
		}

		return hash;
	}

	public static void main(String[] args) {
		int hash1 = new Time33().hash("ABC");
		int hash2 = new Time33().hash("ABCD");

		System.out.println(hash1 + ":" + hash2);
	}
}
