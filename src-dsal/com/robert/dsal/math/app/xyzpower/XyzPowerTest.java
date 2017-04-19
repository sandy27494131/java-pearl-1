package com.robert.dsal.math.app.xyzpower;

import com.robert.dsal.util.DisplayUtil;

public class XyzPowerTest {
	public static void main(String[] args) {
		XyzPower xyzPower = new XyzPowerBruteForce();

		int[][] results = xyzPower.find(100);

		DisplayUtil.printMatrix("Result ", results);
	}
}
