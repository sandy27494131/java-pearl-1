package com.robert.jvm.cocurrent.lock.myimpl.lang;

import java.util.LinkedList;
import java.util.Queue;

import com.robert.jvm.cocurrent.lock.myimpl.Lock;

/**
 * 
 * 公平锁，不可重入
 * 
 */
public class LockImplFaireness implements Lock {
	private boolean isLocked = false;
	private Thread lockedThread = null;

	// 也可以用BlockingQueue, 就不用外同步了
	private Queue<MonitorObject> waitingThreads = new LinkedList<MonitorObject>();

	public void lock() {

		// 这个对象放这里，让syncrhonized(this)能访问，让 monitor.wait也能访问
		MonitorObject monitor = new MonitorObject();
		// 锁当前对象，为了更改变量
		synchronized (this) {
			waitingThreads.add(monitor);

			// 这个死循环是为了阻止Nested Monitor Lockup Issue,
			// 就是锁父，锁子，然后解锁子，但是父仍然在锁，因此就无法unlock, 因为unlock无法获得父锁
			while (true) {
				// 锁当前对象，为了更改变量
				synchronized (this) {
					if (!isLocked && monitor == waitingThreads.peek()) {
						// 一个线程获得锁了
						waitingThreads.remove();
						isLocked = true;
						lockedThread = Thread.currentThread();
						return;
					}
				}

				try {
					// 进入子对象的等待
					monitor.wait();
				} catch (InterruptedException e) {
					// Suspicious wakeup， eat it and have it queue again
				}
			}
		}
	}

	public synchronized void unlock() {
		if (lockedThread != Thread.currentThread())
			throw new IllegalMonitorStateException(
					"The current thead should have obtained this lock.");

		isLocked = false;
		lockedThread = null;

		waitingThreads.peek().doNotify();
	}

}

class MonitorObject {
	private boolean isNotified = false;

	public synchronized void doWait() {
		while (!isNotified)
			try {
				wait();
			} catch (InterruptedException e) {
				// Suspicious Wakeup
			}

		isNotified = false;
	}

	public synchronized void doNotify() {
		isNotified = true;
		notify();
	}
}
