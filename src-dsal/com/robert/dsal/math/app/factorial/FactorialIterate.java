package com.robert.dsal.math.app.factorial;

public class FactorialIterate implements Factorial {

	public int calcFactorial(int n) {
		int result = 1;

		for (int i = 2; i <= n; i++)
			result *= i;

		return result;
	}

}
