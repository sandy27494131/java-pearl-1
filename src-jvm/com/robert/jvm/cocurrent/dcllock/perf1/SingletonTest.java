package com.robert.jvm.cocurrent.dcllock.perf1;

public class SingletonTest {
    public static long test(int threadCounter, Runnable r) throws InterruptedException {
        Thread[] ts = new Thread[threadCounter];

        for (int i = 0; i < threadCounter; i++) {
            ts[i] = new Thread(r);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < threadCounter; i++) {
            ts[i].start();
        }

        for (int i = 0; i < threadCounter; i++) {
            ts[i].join();
        }

        return System.currentTimeMillis() - start;
    }


    public static void main(String[] args) throws Exception {
        final int threadCounter = 10;
        final int testTimes = 10;
        final int iterTimes = 1000000;

        // Skip the first init method so that it won't cause the deviation of the test result
        SingletonSafe.getSingleton();
        SingletonEarlyInit.getSingleton();

        for (int i = 0; i < testTimes; i++) {
            long safeTime = test(threadCounter, new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < iterTimes; i++) {
                        SingletonSafe.getSingleton();
                    }
                }
            });

            long earlyInitTime = test(threadCounter, new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < iterTimes; i++) {
                        SingletonEarlyInit.getSingleton();
                    }
                }
            });

            System.out.println("Synchronized->" + safeTime + ", EarlyInit->" + earlyInitTime);

        }
    }
}
