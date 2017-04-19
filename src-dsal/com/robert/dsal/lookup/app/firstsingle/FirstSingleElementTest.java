package com.robert.dsal.lookup.app.firstsingle;

/**
 * 
 * Find the first non-repeat elements. The complexity must be O(n).
 * 
 * 
 * It should be hash + linked list to do it.
 * 
 */

public class FirstSingleElementTest {
	public static void main(String[] args) {
		FirstSingleElement fnd = new FirstSingleElementStrictLinear();
		String s = fnd.find(new String[] { "abc", "abc", "d", "d", "ee" });
		System.out.println(s);
	}
}
