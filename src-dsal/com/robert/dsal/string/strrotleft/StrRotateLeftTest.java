package com.robert.dsal.string.strrotleft;

public class StrRotateLeftTest {
	public static void main(String[] args) {
		char[] s = "abcdefg".toCharArray();
		char[] s1 = "abcdefg".toCharArray();
		char[] s2 = "abcdefg".toCharArray();
		char[] s3 = "abcdefg".toCharArray();

		StrRotateLeft srl = new StrRotateLeftBruteForce();
		StrRotateLeft srl1 = new StrRotateLeftBruteForce1();
		StrRotateLeft srl2 = new StrRotateLeftJumpIterate();
		StrRotateLeft srl3 = new StrRotateLeftJumpIterate();

		srl.rotateLeft(s, 2);
		srl1.rotateLeft(s1, 2);
		srl2.rotateLeft(s2, 2);
		srl3.rotateLeft(s3, 2);

		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
