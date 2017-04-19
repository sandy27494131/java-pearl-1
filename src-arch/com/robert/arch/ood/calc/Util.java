package com.robert.arch.ood.calc;

public class Util {
	public static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	public static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	public static boolean isControl(char c) {
		return c == 'c' || c == '=';
	}

	public static boolean isNumber(String c) {
		try {
			Integer.valueOf(c);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static boolean isOperator(String s) {
		return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
	}
	
	public static boolean isGreaterEqual(String o1, String o2) {
		if ("*".equals(o1) || "/".equals(o1))
			return true;
		
		if ("+".equals(o2) || "-".equals(o2))
			return true;
		return false;
	}

}
