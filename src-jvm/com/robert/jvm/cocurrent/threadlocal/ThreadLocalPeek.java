package com.robert.jvm.cocurrent.threadlocal;

public class ThreadLocalPeek {
    private static final ThreadLocal<String> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        tl.set("this thread");

        String s = tl.get();

        System.out.println(s);
    }
}
