package com.robert.jvm.cocurrent.dcllock.wrongdcl;

import java.util.concurrent.atomic.AtomicLong;

public class Singleton {
    private static Singleton singleton;

    private static AtomicLong counter = new AtomicLong(0);

    private Singleton() {
        counter.incrementAndGet();
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                /* if (singleton == null) */singleton = new Singleton();
            }
        }
        return singleton;
    }

    public static long getCoutner() {
        return counter.get();
    }


    public static void reset() {
        singleton = null;
        counter.set(0);
    }
}
