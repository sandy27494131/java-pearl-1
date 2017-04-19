package com.robert.dsal.math.app.gcd;

import com.robert.dsal.util.TestUtil;

public class GreatestLeastCommonImplTest {
	public void run() {
		GreatestLeastCommon common = new GreatestLeastCommonDefault();
		int a = (int) (Math.random() * 100) + 1, b = (int) (Math.random() * 100) + 1;
		int g = common.calcGreatestCommonDivisor(a, b);
		int l = common.calcLeastCommonMultiply(a, b);

		System.out.println(a + ":" + b);

		System.out.println("The greatest common divisor is " + g);
		System.out.println("The least common multiple is " + l);

		TestUtil.assertEqual(a % g, 0);
		TestUtil.assertEqual(b % g, 0);

		TestUtil.assertEqual(l % a, 0);
		TestUtil.assertEqual(l % b, 0);
	}

	public static void main(String[] args) {
		new GreatestLeastCommonImplTest().run();
	}
}
