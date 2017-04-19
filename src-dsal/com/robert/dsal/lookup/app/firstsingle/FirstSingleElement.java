package com.robert.dsal.lookup.app.firstsingle;
// TODO to implement more option
/**
 * 
 * Find the first non-repeat element. The complexity must be O(n).
 * 
 * 1. If it requires O(n), then bitmap and hashtable can be used. At the first
 * scan, set the bitmap or hashtable, the value is 0, 1, 2. The 0 means the
 * element is not there. The 1 means it appears 1 time. The 2 means it appears
 * >=2 times. At the second time, scan the bitmap or hashtable, output the first
 * value 1.
 * 
 * But strictly, the conmplexity is O(2n).
 * 
 * 2. If the strict O(n) is required, it should be hash + linked list to do it.
 * 
 * 在hash中存储出现次数，将所有出现一次的使用一个双链表来存储
 * 
 * 3. 可以进行排序，然后找到一个重复的O(nlog2n)
 * 
 */

public interface FirstSingleElement {
	public int find(int[] x);

	public String find(String[] strs);
}
