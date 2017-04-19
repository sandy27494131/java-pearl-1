package com.robert.dsal.math.app.findprime;

import java.util.ArrayList;
import java.util.List;

import com.robert.dsal.util.CollectionUtil;

/**
 * 
 * <b>时间复杂度：</b><br>
 * O(n^2)<br>
 * <p>
 * 第1次执行0次<br>
 * 第2次执行1次<br>
 * 第3次执行3次<br>
 * ........<br>
 * 第n次执行n - 1次<br>
 * 0 + 1 + 2 + 3 + （n - 1） = n*(n-1)/2
 * 
 */
public class PrimeFinderImpl implements PrimeFinder {
	public int[] findPrime(int n) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++)
				if (i % j == 0)
					isPrime = false;
			if (isPrime)
				result.add(i);
		}

		return CollectionUtil.convert(result);
	}

}
