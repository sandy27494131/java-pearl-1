package com.robert.jvm.cocurrent.app.abcprinter;

public class SequentialABCPrinterNewImpl {
	static class Printer extends Thread {
		private String waitAndPrint;
		private String notify;

		private int count;

		public Printer(String waitAndPrint, String notify) {
			this.waitAndPrint = waitAndPrint;
			this.notify = notify;
		}

		public void run() {
			while (count++ < 10) {
				try {
					synchronized (waitAndPrint) {
						waitAndPrint.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println(waitAndPrint);

				synchronized (notify) {
					notify.notify();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		String sa = "A";
		String sb = "B";
		String sc = "C";

		Thread ta = new Printer(sa, sb);
		Thread tb = new Printer(sb, sc);
		Thread tc = new Printer(sc, sa);

		ta.start();
		tb.start();
		tc.start();

		while (!(Thread.State.WAITING.equals(ta.getState())
				&& Thread.State.WAITING.equals(tb.getState()) && Thread.State.WAITING
					.equals(tc.getState()))) {
			Thread.sleep(1);
		}

		synchronized (sa) {
			sa.notify();
		}
	}
}
