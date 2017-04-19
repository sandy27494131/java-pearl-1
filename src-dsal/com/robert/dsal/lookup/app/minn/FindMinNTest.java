package com.robert.dsal.lookup.app.minn;

import com.robert.dsal.util.DisplayUtil;

public class FindMinNTest {
	public static void main(String[] args) {
		FindMInN fmn = new FindMInNImpl();
		FindMInN fmn1 = new FindMinNImpl1();

		int[] r = fmn.findMInN(new int[] { 1, 2, 3, 4, 5, 1, 1, 2 });
		DisplayUtil.printSeq("Default:", r);

		int[] r1 = fmn1
				.findMInN(new int[] { 1, -2, -3, 4, 5, 1, -2, -3 });
		DisplayUtil.printSeq("Good:", r1);

	}
}
