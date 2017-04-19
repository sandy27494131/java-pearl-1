package com.robert.cci.c19.q06;

import java.util.Arrays;

/**
 * 
 * 汉字不像英语，其实比较整齐，除了个位数，就是十百千，然后下一个层次就是万和亿
 * 
 * 1. 通过万和亿按照4位分成一组 
 * 2. 对于每一组进行个百十千构造串 
 * 3. 然后将不同的分组用万和亿来表示
 * 
 */
public class Num2StringChinese implements Num2String {
	static final String zero = "零";

	static final String[] lighter = { "", "一", "二", "三", "四", "五", "六", "七",
			"八", "九" };

	static final String[] weighter = { "", "十", "百", "千" };

	static final String[] more = { "", "万", "亿" };

	public String convert(int num) {
		int[] wans = spit(num);

		StringBuilder sb = new StringBuilder();
		for (int i = wans.length - 1; i >= 0; i--) {
			sb.append(convertWan(wans[i]) + more[i]);
		}

		return trim(sb.toString());
	}

	private int[] spit(int num) {
		int[] results = new int[Integer.MAX_VALUE / 10000];
		int index = 0;

		while (num > 0) {
			results[index++] = num % 10000;

			num = num / 10000;
		}

		return Arrays.copyOf(results, index);
	}

	private String trim(String src) {
		StringBuilder sb = new StringBuilder(src);
		while (sb.charAt(0) == '零')
			sb.delete(0, 1);

		while (sb.charAt(sb.length() - 1) == '零')
			sb.delete(sb.length() - 1, sb.length());

		for (int i = 0; i < sb.length() - 1; i++) {
			if (sb.charAt(i) == sb.charAt(i + 1) && sb.charAt(i) == '零') {
				sb.delete(i, i + 1);
				i--;
			}

		}
		return sb.toString();
	}

	private String convertWan(int num) {
		StringBuilder sb = new StringBuilder();

		sb.append(convertWeighter(num / 1000, 3)); // 千
		sb.append(convertWeighter(num / 100 % 10, 2)); // 百
		sb.append(convertWeighter(num / 10 % 10, 1)); // 十
		sb.append(convertLighter(num % 10)); // 个

		return sb.toString();
	}

	public String convertLighter(int num) {
		return lighter[num];
	}

	public String convertWeighter(int num, int weight) {
		if (num == 0)
			return "零";

		return lighter[num] + weighter[weight];
	}
}
