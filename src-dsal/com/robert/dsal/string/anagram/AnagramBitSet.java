package com.robert.dsal.string.anagram;

import java.util.BitSet;

public class AnagramBitSet implements Anagram {
	public boolean isAnagramPalindrome(char[] str) {

		BitSet bs = new BitSet();

		for (int i = 0; i < str.length; i++) {
			int index = str[i] - 'a';
			bs.set(index, !bs.get(index));
		}

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (bs.get(i))
				count++;
		}

		return count == 0 || count == 1;
	}
}
