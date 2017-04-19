package com.robert.jvm.cocurrent.lock.myimpl.lang;

import com.robert.jvm.cocurrent.lock.myimpl.Lock;

/**
 * 
 * 可重入的锁，但是不公平
 * 
 */
public class LockImplReentrant implements Lock {
	private boolean isLocked = false;
	private Thread lockedThread = null;
	private int count = 0;

	public synchronized void lock() {
		while (isLocked && lockedThread != Thread.currentThread()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// Suspicious wakeup, eat it and then make it queue in this lock
			}
		}

		isLocked = true;
		count++;
		lockedThread = Thread.currentThread();
	}

	public void unlock() {
		if (lockedThread != Thread.currentThread())
			throw new IllegalMonitorStateException(
					"The current thead should have obtained this lock.");

		count--;

		if (count == 0) {
			isLocked = false;
			lockedThread = null;
			notify();
		}
	}

}
