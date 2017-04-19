package com.robert.jvm.cocurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class ForkJoinTaskSum extends RecursiveTask<Integer> {
	private static final int THRESH_HOLD = 2;

	private int s;
	private int e;

	public ForkJoinTaskSum(int s, int e) {
		this.s = s;
		this.e = e;
	}

	protected Integer compute() {
		if (s > e)
			return 0;

		if (e - s < THRESH_HOLD) {
			int sum = 0;
			for (int i = s; i <= e; i++)
				sum += i;
			return sum;
		} else {
			int m = (s + e) / 2;
			RecursiveTask<Integer> rtl = new ForkJoinTaskSum(s, m);
			RecursiveTask<Integer> rtr = new ForkJoinTaskSum(m + 1, e);

			rtl.fork();
			rtr.fork();

			int l = rtl.join();
			int r = rtr.join();

			return l + r;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ForkJoinTaskSum sum = new ForkJoinTaskSum(0, 100);

		ForkJoinPool fjp = new ForkJoinPool();
		fjp.execute(sum);

		fjp.shutdown();
		while (!fjp.awaitTermination(1, TimeUnit.NANOSECONDS))
			;

		System.out.println(sum.getRawResult());
	}
}
