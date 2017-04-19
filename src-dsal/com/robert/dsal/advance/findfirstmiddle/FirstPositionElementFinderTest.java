package com.robert.dsal.advance.findfirstmiddle;

import com.robert.dsal.util.DisplayUtil;
import com.robert.dsal.util.TestUtil;

public class FirstPositionElementFinderTest {

	public void run() {
		int[] seq = { 3, 2, 3, 2, 5, 8, 9 };
		DisplayUtil.printSeq("Seq", seq);

		FirstPositionElementFinder sef = new FirstPositionElementFinderBruteForce();
		int sortedElement = sef.findFirstPositionElement(seq);

		System.out.format("Brute Force: %d", sortedElement);
		System.out.println();


		FirstPositionElementFinder sef2 = new FirstPostionElementFinderCumulativeSum();
		int sortedElement2 = sef2.findFirstPositionElement(seq);
		System.out.format("Cumulative Sum: %d",
				sortedElement2);
		System.out.println();

		FirstPositionElementFinder sef3 = new FirstPositionElementDynamicProgramming1();
		int sortedElement3 = sef3.findFirstPositionElement(seq);
		System.out.format("Dynamic Programming: %d", sortedElement3);
		System.out.println();

		TestUtil.assertEqual(sortedElement, sortedElement2);
		TestUtil.assertEqual(sortedElement2, sortedElement3);
	}

	public static void main(String[] args) {
		new FirstPositionElementFinderTest().run();
	}

}
