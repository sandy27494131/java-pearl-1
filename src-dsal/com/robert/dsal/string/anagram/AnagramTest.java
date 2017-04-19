package com.robert.dsal.string.anagram;

public class AnagramTest {
	public static void main(String[] args) {

		String str = "dooernedeevrvn";
		String str1 = "aabcba";

		Anagram anagram = new AnagramBitSet();
		Anagram anagram1 = new AnagramBitOper();
		Anagram anagram2 = new AnagramSort();
		
		boolean b = anagram.isAnagramPalindrome(str.toCharArray());
		boolean b1 = anagram1.isAnagramPalindrome(str.toCharArray());
		boolean b2 = anagram2.isAnagramPalindrome(str.toCharArray());
		
		boolean b3 = anagram.isAnagramPalindrome(str1.toCharArray());
		boolean b4 = anagram1.isAnagramPalindrome(str1.toCharArray());
		boolean b5 = anagram2.isAnagramPalindrome(str1.toCharArray());

		System.out.println(b + " : " + b1 + ":" + b2);
		System.out.println(b3 + " : " + b4 + ":" + b5);
	}
}
