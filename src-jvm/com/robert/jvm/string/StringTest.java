package com.robert.jvm.string;

import java.io.UnsupportedEncodingException;

public class StringTest {
    public static void main(String[] args) {
        // 以下两个byte数组分别代表一个中文字符，前一个属于正常字符范围，后一个属于增补码范围。使用utf-8编码来产生字符串。

        // http://www.unicode.org/cgi-bin/GetUnihanData.pl?codepoint=5357
        byte[] b1 = {(byte) 0xE5, (byte) 0x8D, (byte) 0x97};

        // http://www.unicode.org/cgi-bin/GetUnihanData.pl?codepoint=20015
        byte[] b2 = {(byte) 0xF0, (byte) 0xA0, (byte) 0x80, (byte) 0x95};

        try {
            String s1 = new String(b1, "UTF-8");
            String s2 = new String(b2, "UTF-8");


            System.out.println("中文字符：" + s1 + ":" + s2);
            System.out.println("UTF8字节长度" + s1.getBytes("UTF-8").length + ":" + s2.getBytes("UTF-8").length);
            System.out.println("串长度*.length()" + s1.length() + ":" + s2.length());
            System.out.println("字符串CodePointCount" + s1.codePointCount(0, s1.length()) + ":" + s2.codePointCount(0, s2.length()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
