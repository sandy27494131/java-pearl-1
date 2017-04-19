package com.robert.dsal.math.app.findprime;

import com.robert.dsal.util.DisplayUtil;

public class PrimeFinderTest {
	public void run() {
		PrimeFinder pf = new PrimeFinderImpl();
		int[] primesIn100 = pf.findPrime(100);

		DisplayUtil.printSeq("Primes among 100", primesIn100);
	}

	public static void main(String[] args) {
		new PrimeFinderTest().run();
	}
}
