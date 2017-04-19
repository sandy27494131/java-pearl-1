package com.robert.jvm.cocurrent.lock.jenkov;

// This is conterpart of Locked.isLocked, please note they represents the reversed mechanism

public class MyWaitNotify {
	private Object myMonitorObject = new Object();
	boolean isSignified = false; // Prevent Missed Signals

	public void doWait() {
		synchronized (myMonitorObject) {
			while (!isSignified) { // Prevent Spurious Wakeups
				try {
					myMonitorObject.wait();
				} catch (InterruptedException ie) {
				}
			}
			isSignified = false;
		}
	}

	public void doNotify() {
		synchronized (myMonitorObject) {
			isSignified = true;
			myMonitorObject.notify();
		}
	}
}
