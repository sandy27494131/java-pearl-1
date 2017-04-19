package com.robert.jvm.io.support;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

public class CharsetTest {
	public static void main(String[] args) {
		SortedMap<String, Charset> sortMap = Charset.availableCharsets();

		for (Map.Entry<String, Charset> entry : sortMap.entrySet()) {
			// System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		Charset utf8 = Charset.forName("UTF-8");
		ByteBuffer bb = utf8.encode("中国");

		System.out.println(bb.position() + ":" + bb.limit());

		// 为了测试，把UTF-8转成GB
		Charset gb2312 = Charset.forName("GB2312");
		CharBuffer cb = gb2312.decode(bb);

		System.out.println(cb.position() + ":" + cb.limit() + ":"
				+ cb.toString());
	}
}
