package com.robert.jvm.cocurrent.lock.myimpl.lang;

import com.robert.jvm.cocurrent.lock.myimpl.Lock;

/**
 * 
 * 简单的锁实现，不可重入，非公平锁
 * 
 */
public class LockImpl implements Lock {
	private boolean isLocked = false;
	private Thread lockedThread = null;

	public synchronized void lock() {
		while (isLocked) {
			try {
				wait();
			} catch (InterruptedException e) {
				// Suspicious wakeup, eat it and then make it queue in this lock
			}
		}

		isLocked = true;
		lockedThread = Thread.currentThread();
	}

	public synchronized void unlock() {
		if (lockedThread != Thread.currentThread())
			throw new IllegalMonitorStateException(
					"The current thead should have obtained this lock.");

		isLocked = false;
		lockedThread = null;
		notify();
	}

}
