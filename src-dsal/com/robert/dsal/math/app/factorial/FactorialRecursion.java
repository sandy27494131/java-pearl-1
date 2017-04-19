package com.robert.dsal.math.app.factorial;

public class FactorialRecursion implements Factorial {

	public int calcFactorial(int n) {
		if (n == 1)
			return 1;

		return n * calcFactorial(n - 1);
	}

}
