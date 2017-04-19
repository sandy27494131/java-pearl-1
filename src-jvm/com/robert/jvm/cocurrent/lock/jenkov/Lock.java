package com.robert.jvm.cocurrent.lock.jenkov;

// 请注意这个不是可重入的锁

public class Lock {
	private boolean isLocked = false;
	private Thread lockedThread = null;

	private Object monitor = new Object();

	public void lock() {
		synchronized (monitor) {
			while (isLocked) {
				try {
					monitor.wait();
				} catch (Exception e) {
				}
			}
			isLocked = true;
			lockedThread = Thread.currentThread();
		}
	}

	public void unlock() {
		synchronized (monitor) {
			if (Thread.currentThread() != lockedThread)
				throw new IllegalMonitorStateException(
						"Calling thread never locked this lock");

			isLocked = false;
			lockedThread = null;
			monitor.notify();
		}
	}
}
