package com.robert.jvm.cocurrent.dcllock.perf1;


public class SingletonSafe {
    private static SingletonSafe singleton;

    private SingletonSafe() {}

    public static synchronized SingletonSafe getSingleton() {
        if (singleton == null) singleton = new SingletonSafe();

        return singleton;
    }
}
