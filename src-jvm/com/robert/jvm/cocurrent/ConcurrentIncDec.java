package com.robert.jvm.cocurrent;

public class ConcurrentIncDec {
	static class ConcurrentOperant {
		private long num = 0;

		public ConcurrentOperant(int num) {
			this.num = num;
		}

		public synchronized void inc() {
			this.num++;
		}

		public synchronized void dec() {
			this.num--;
		}

		public void print() {
			System.out.println(num);
		}
	}

	static class Worker implements Runnable {
		private ConcurrentOperant co;

		private Oper oper;

		private long times;

		private static enum Oper {
			inc, dec
		}

		public Worker(ConcurrentOperant co, Oper oper, int times) {
			this.co = co;
			this.oper = oper;
			this.times = times;
		}

		@Override
		public void run() {
			for (int i = 0; i < times; i++) {
				if (Oper.inc.equals(this.oper)) {
					this.co.inc();
				} else if (Oper.dec.equals(this.oper)) {
					this.co.dec();
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ConcurrentOperant co = new ConcurrentOperant(100);

		Thread t0 = new Thread(new Worker(co, Worker.Oper.inc, 2500));
		Thread t1 = new Thread(new Worker(co, Worker.Oper.dec, 2500));
		Thread t2 = new Thread(new Worker(co, Worker.Oper.inc, 2500));
		Thread t3 = new Thread(new Worker(co, Worker.Oper.dec, 2500));

		t0.start();
		t1.start();
		t2.start();
		t3.start();

		t0.join();
		t1.join();
		t2.join();
		t3.join();

		co.print();
	}
}
