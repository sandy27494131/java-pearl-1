package com.robert.jvm.cocurrent.lock.jenkov.problems;

import java.util.ArrayList;
import java.util.List;

// Nested Monitor Lockout 2

//Fair Lock implementation with nested monitor lockout problem

public class NestedMonitorLockoutFairLock {
	private boolean isLocked = false;
	private Thread lockingThread = null;

	private List<Object> waitingThreads = new ArrayList<Object>();

	public void lock() throws InterruptedException {
		Object queueObject = new Object();

		synchronized (this) {
			waitingThreads.add(queueObject);

			while (isLocked || waitingThreads.get(0) != queueObject) {
				// 自己锁过了，自己也会进行阻塞
				synchronized (queueObject) {
					try {
						queueObject.wait();
					} catch (InterruptedException e) {
						waitingThreads.remove(queueObject);
						throw e;
					}
				}
			}

			waitingThreads.remove(queueObject);
			isLocked = true;
			lockingThread = Thread.currentThread();
		}
	}

	public synchronized void unlock() {
		if (this.lockingThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException(
					"Calling thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		if (waitingThreads.size() > 0) {
			Object queueObject = waitingThreads.get(0);
			synchronized (queueObject) {
				queueObject.notify();
			}
		}
	}
}
