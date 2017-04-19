package com.robert.dsal.math.app.findfactor;

import com.robert.dsal.sort.QuickSort;
import com.robert.dsal.sort.Sort;
import com.robert.dsal.util.DisplayUtil;

public class FactorFinderTest {

	public void run() {
		FactorFinder ff = new FactorFinderImpl();
		int[] factors = ff.findFactors(1000);

		Sort sort = new QuickSort();
		sort.sort(factors);

		DisplayUtil.printSeq("All Factors", factors);
	}

	public static void main(String[] args) {
		new FactorFinderTest().run();
	}

}
