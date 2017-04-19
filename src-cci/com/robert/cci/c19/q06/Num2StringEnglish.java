package com.robert.cci.c19.q06;

import java.util.Arrays;

/**
 * 首先按照三位一组，三位一个组，中间添加thousand, million和billion
 * 
 * 999,999,999,999
 * 
 * 对于每三位分成以下情况，
 * 
 * 例如：999
 * 
 * 分类： 
 * 1. 0 
 * 2. 1 - 19 
 * 3. 20 - 99 
 * 4. 100 - 999
 * 
 * 1类，2类和3类必须单独处理 4类是三位数字，那么低位两位数字重用2类和3类方法，百分位单独计算成几百的表达
 * 
 */
public class Num2StringEnglish implements Num2String {
	static final String word0 = "Zero";

	static final String[] wordsLess20 = { "", "One ", "Two ", "Three ",
			"Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
			"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ",
			"Sixteen ", "Seventeen ", "Eighteen ", "Nineteen " };

	static final String[] words20$100 = { "", "", "Twenty ", "Thirty ",
			"Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety " };

	static final String wordLess1000 = "Hundred ";

	static final String[] wordsLess1000000000 = { "", "Thousand ", "Million ",
			"Billion " };

	public String convert(int num) {
		int[] thousands = split2Thousands(num);

		StringBuilder sb = new StringBuilder(num + ": ");
		for (int i = thousands.length - 1; i >= 0; i--) {
			sb.append(convertThousand(thousands[i]) + wordsLess1000000000[i]);
		}

		return sb.toString();
	}

	private int[] split2Thousands(int num) {
		int maxNumThousands = Integer.MAX_VALUE / 1000 + 1;

		int[] results = new int[maxNumThousands];
		int size = 0;

		while (num > 0) {
			int rest = num % 1000;
			results[size++] = rest;

			num = num / 1000;
		}
		return Arrays.copyOf(results, size);
	}

	public String convertThousand(int num) {
		if (num == 0)
			return word0;

		if (num < 20) {
			return convertWordsLess20(num);
		} else if (num < 100) {
			return convertWordsLess20$100(num);
		} else if (num < 1000) {
			return convertWordsLess1000(num);
		}

		throw new RuntimeException("More than 1000 is not allowed.");
	}

	public String convertWordsLess20(int num) {
		return wordsLess20[num];
	}

	public String convertWordsLess20$100(int num) {
		int lighter = num % 10;
		int weighter = num / 10;

		return words20$100[weighter] + wordsLess20[lighter];
	}

	public String convertWordsLess1000(int num) {
		int lighter = num % 100;
		int weighter = num / 100;

		return (weighter == 0 ? "" : wordsLess20[weighter])
				+ wordLess1000
				+ (lighter < 20 ? convertWordsLess20(lighter)
						: convertWordsLess20$100(lighter));
	}
}
