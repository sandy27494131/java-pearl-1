package com.robert.jvm.cocurrent.lock.jenkov.problems;

// Nested Monitor Lockout 1

//Lock implementation with nested monitor lockout problem

public class NestedMonitorLockoutLock {
	protected Object monitorObject = new Object();
	protected boolean isLocked = false;

	public void lock() throws InterruptedException {
		synchronized (this) {
			while (isLocked) {
				// 如果锁了就等待，如果自己锁了也等待，所以，不是重入的
				synchronized (this.monitorObject) {
					this.monitorObject.wait();
				}
			}
			isLocked = true;
		}
	}

	public void unlock() {
		synchronized (this) {
			this.isLocked = false;
			synchronized (this.monitorObject) {
				this.monitorObject.notify();
			}
		}
	}
}
