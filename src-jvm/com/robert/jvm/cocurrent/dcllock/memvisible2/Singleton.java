package com.robert.jvm.cocurrent.dcllock.memvisible2;

import java.util.concurrent.atomic.AtomicLong;

public class Singleton {
    private static Singleton singleton;

    private static AtomicLong counter = new AtomicLong(0);

    private StringBuffer data;

    private Singleton() {
        counter.incrementAndGet();
        data = new StringBuffer("inited");
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) singleton = new Singleton();
            }
        }
        return singleton;
    }

    public StringBuffer getData() {
        return data;
    }

    public static long getCoutner() {
        return counter.get();
    }


    public static void reset() {
        singleton = null;
        counter.set(0);
    }

}
