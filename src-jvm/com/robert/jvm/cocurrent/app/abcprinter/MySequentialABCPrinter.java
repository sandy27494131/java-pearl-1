package com.robert.jvm.cocurrent.app.abcprinter;

import java.util.LinkedList;
import java.util.Queue;

public class MySequentialABCPrinter {
	static class Monitor {

	}

	static class CharPrinter implements Runnable {
		private char cha;
		private Queue<Monitor> q;
		private Monitor monitor;
		int times = 0;
		int maxTimes;

		public CharPrinter(char cha, Queue<Monitor> q, int maxTimes) {
			this.cha = cha;
			this.q = q;
			this.maxTimes = maxTimes;

			this.monitor = new Monitor();
			q.add(this.monitor);
		}

		@Override
		public void run() {

			while (true) {
				synchronized (monitor) {
					System.out.println(this.cha + ":" + "waiting");
					try {
						this.monitor.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(this.cha + ":" + "notified");

				this.q.remove();

				System.out.println(this.cha);

				System.out.println(this.cha + ":" + "go to tail");
				q.add(this.monitor);

				System.out.println(this.cha + ":" + "notify next");
				synchronized (q.peek()) {
					q.peek().notify();
				}

				if (++times > maxTimes)
					break;

				System.out.println(this.cha + ":" + "exit 1 loop");
			}

			System.out.println(this.cha + ":" + "exit thread");
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Queue<Monitor> q = new LinkedList<Monitor>();

		Thread t1 = new Thread(new CharPrinter('A', q, 10));
		Thread t2 = new Thread(new CharPrinter('B', q, 10));
		Thread t3 = new Thread(new CharPrinter('C', q, 10));

		t1.start();
		t2.start();
		t3.start();

		while (!(Thread.State.WAITING.equals(t1.getState())
				&& Thread.State.WAITING.equals(t2.getState()) && Thread.State.WAITING
					.equals(t3.getState()))) {
			Thread.sleep(1);
		}

		synchronized (q.peek()) {
			System.out.println("before start");
			q.peek().notify();
			System.out.println("end start");
		}

		t1.join();
		t2.join();
		t3.join();

	}
}
