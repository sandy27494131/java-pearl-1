package com.robert.dsal.math.app.gcd;

import com.robert.dsal.util.AlUtil;

public class GreatestLeastCommonDefault implements GreatestLeastCommon {

	public int calcGreatestCommonDivisor(int a, int b) {
		if (a < b)
			AlUtil.swap(a, b);

		int tmp = a % b;
		while (tmp != 0) {
			a = b;
			b = tmp;
			tmp = a % b;
		}

		return b;
	}

	public int calcLeastCommonMultiply(int a, int b) {
		int greatestCommonDivisor = calcGreatestCommonDivisor(a, b);

		return (a * b) / greatestCommonDivisor;
	}

}
