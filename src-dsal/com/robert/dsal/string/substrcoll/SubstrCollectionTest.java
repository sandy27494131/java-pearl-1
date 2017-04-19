package com.robert.dsal.string.substrcoll;

import java.util.List;

import com.robert.dsal.util.DisplayUtil;

public class SubstrCollectionTest {

	public static void main(String[] args) {
		SubstrCollection substrCollection = new SubstrCollectionImpl();
		char[][] coll = substrCollection.calcAllSubstr("abcde".toCharArray(), 2);

		DisplayUtil.printMatrix("", coll);
	}

}
