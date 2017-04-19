package com.robert.jvm.cocurrent.dcllock.perf2;

import com.robert.jvm.cocurrent.dcllock.memvisible1.Singleton;


public class SingletonDcl {
    private static SingletonDcl singleton = new SingletonDcl();

    private SingletonDcl() {}

    public static SingletonDcl getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) singleton = new SingletonDcl();
            }
        }
        return singleton;

    }
}
