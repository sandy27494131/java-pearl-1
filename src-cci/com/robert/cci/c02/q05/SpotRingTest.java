package com.robert.cci.c02.q05;

public class SpotRingTest {

	public static void main(String[] args) {
		
		LinkedListNode root = null;
		
		LinkedListNode mid = null;
		LinkedListNode last = null;
		for (int i = 9; i >= 0; i--) {
			root = new LinkedListNode(i, root);
			
			if (i == 3)
				mid = root;
			
			if (i == 9)
				last = root;
		}
		
		last.next = mid;
		
		SpotRing sr = new SpotRingGapPointer();
		
		int length = sr.spotRing(root);
		System.out.println(length);
	}

}
