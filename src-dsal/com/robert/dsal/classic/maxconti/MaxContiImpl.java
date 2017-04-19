package com.robert.dsal.classic.maxconti;

public class MaxContiImpl implements MaxConti {
	public int maxConti(char[] s) {
		if (s == null || s.length == 0)
			return 0;

		int max = 1;

		int start = 0;
		int length = 1;

		int i = 1;
		while (i < s.length) {
			if (s[i] == s[i - 1]) {
				length++;
			} else {
				if (length > max) {
					max = length;
				}
				start = i;
				length = 1;

			}

			i++;
		}

		if (length > max)
			max = length;

		return max;
	}
}
