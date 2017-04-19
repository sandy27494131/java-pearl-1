package com.robert.jvm.cocurrent.dcllock.perf1;


public class SingletonEarlyInit {
    private static SingletonEarlyInit singleton = new SingletonEarlyInit();

    private SingletonEarlyInit() {}

    public static SingletonEarlyInit getSingleton() {
        return singleton;
    }
}
