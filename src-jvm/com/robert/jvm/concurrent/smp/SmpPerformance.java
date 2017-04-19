package com.robert.jvm.concurrent.smp;

public class SmpPerformance {
    public int computationNum;

    private int threadNum;

    private Thread[] threads;

    public SmpPerformance(int threadNum, int computationNum) {
        this.threadNum = threadNum;
        threads = new Thread[this.threadNum];

        this.computationNum = computationNum;

        for (int i = 0; i < threads.length; i++)
            threads[i] = new ComputationThread();
    }

    public void startThreads() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    public void waitThreads() {
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    private class ComputationThread extends Thread {
        public void run() {
            for (int i = 0; i < computationNum; i++) {
                double result = Integer.MAX_VALUE / (i + 1);
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 1;
        int computationNum = 1000000000;

        for (int i = 0; i < 8; i++)
            runTest(threadNum * (int) Math.pow(2, i), computationNum);
    }

    private static void runTest(int threadNum, int computationNum) {
        SmpPerformance smpPerformance = new SmpPerformance(threadNum, computationNum);
        long ts = System.currentTimeMillis();
        smpPerformance.startThreads();
        smpPerformance.waitThreads();
        long te = System.currentTimeMillis();
        System.out.println(threadNum + " threads used " + (te - ts) / threadNum + " to run " + computationNum + " division.");
    }
}
