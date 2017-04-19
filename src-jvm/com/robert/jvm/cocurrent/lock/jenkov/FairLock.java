package com.robert.jvm.cocurrent.lock.jenkov;

import java.util.ArrayList;
import java.util.List;

public class FairLock {
	private boolean isLocked = false;
	private Thread lockingThread = null;

	// Fairness for Starvation
	private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();

	public void lock() throws InterruptedException {
		QueueObject queueObject = new QueueObject();
		synchronized (this) {
			waitingThreads.add(queueObject);
		}

		boolean isLockedForThisThread = true;
		while (isLockedForThisThread) {
			synchronized (this) { // Prevent Slipped Conditions = Race Condition = Make check&action atomic
				isLockedForThisThread = isLocked
						|| waitingThreads.get(0) != queueObject;
				if (!isLockedForThisThread) {
					isLocked = true;
					waitingThreads.remove(queueObject);
					lockingThread = Thread.currentThread();
					return;
				}
			}

			try {
				// Prevent Nested Monitor Lockout by removing synchronizing this, lock on this, then lock on queueObject, when queueObject.wait, release lock on queueObject, but still holds the lock in this
				queueObject.doWait();
			} catch (InterruptedException e) {
				synchronized (this) {
					waitingThreads.remove(queueObject);
				}

				// Handle Spurious Wakeups, it is better to continue to make it wait
				throw e;
			}
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
			waitingThreads.get(0).doNotify();
		}
	}
}

class QueueObject {

	private boolean isNotified = false;

	public synchronized void doWait() throws InterruptedException {
		while (!isNotified) { // Prevent Missed Signals
			this.wait();
		}
		this.isNotified = false;
	}

	public synchronized void doNotify() {
		this.isNotified = true;
		this.notify();
	}

	public boolean equals(Object o) {
		return this == o;
	}
}