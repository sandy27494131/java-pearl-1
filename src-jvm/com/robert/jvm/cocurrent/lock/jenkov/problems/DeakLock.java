package com.robert.jvm.cocurrent.lock.jenkov.problems;

public class DeakLock {
	private Object myMonitorObject1 = new Object();
	private Object myMonitorObject2 = new Object();

	public void doLockObject1() {
		synchronized (myMonitorObject1) {
			synchronized (myMonitorObject2) {
				System.out.println("1 -> 2");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void doLockObject2() {
		synchronized (myMonitorObject2) {
			synchronized (myMonitorObject1) {
				System.out.println("2 -> 1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		final DeakLock dl1 = new DeakLock();
		for (int i = 0; i < 100; i++) {
			new Thread() {
				public void run() {
					dl1.doLockObject1();
				}
			}.start();
		}
		for (int i = 0; i < 100; i++) {
			new Thread() {
				public void run() {
					dl1.doLockObject2();
				}
			}.start();
		}
	}
}
