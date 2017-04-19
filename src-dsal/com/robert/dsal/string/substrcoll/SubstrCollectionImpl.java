package com.robert.dsal.string.substrcoll;

public class SubstrCollectionImpl implements SubstrCollection {

	public char[][] calcAllSubstr(char[] s, int size) {
		char[][] coll = new char[s.length - size + 1][size];

		for (int i = 0; i < s.length - size + 1; i++) {
			for (int j = 0; j < size; j++) {
				coll[i][j] = s[i + j];
			}
		}

		return coll;
	}

}
