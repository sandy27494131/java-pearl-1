package com.robert.jvm.cocurrent.lock.jenkov;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 线程池的构成要素
 * 
 * 1. Container of PooledThread 2. PooledThread 3. BlockingQueue 4. Task
 * Abstraction
 * 
 */
public class ThreadPool {

	private BlockingQueue taskQueue = null;
	private List<PoolThread> threads = new ArrayList<PoolThread>();

	private boolean isStopped = false;

	public ThreadPool(int noOfThreads, int maxNoOfTasks) {
		taskQueue = new BlockingQueue(maxNoOfTasks);

		for (int i = 0; i < noOfThreads; i++) {
			threads.add(new PoolThread(taskQueue));
		}
		for (PoolThread thread : threads) {
			thread.start();
		}
	}

	public synchronized void execute(Runnable task) throws InterruptedException {
		if (this.isStopped)
			throw new IllegalStateException("ThreadPool is stopped");

		this.taskQueue.enqueue(task);
	}

	public synchronized void stop() {
		this.isStopped = true;
		for (PoolThread thread : threads) {
			thread.stop1();
		}
	}

}

class PoolThread extends Thread {

	private BlockingQueue taskQueue = null;
	private boolean isStopped = false;

	public PoolThread(BlockingQueue queue) {
		taskQueue = queue;
	}

	public void run() {
		while (!isStopped) {
			try {
				Runnable runnable = (Runnable) taskQueue.dequeue();
				runnable.run();
			} catch (Exception e) {
				// log or otherwise report exception,
				// but keep pool thread alive.
			}
		}
	}

	public synchronized void stop1() {
		isStopped = true;
		this.interrupt(); // break pool thread out of dequeue() call.
	}

	public synchronized boolean isStopped() {
		return isStopped;
	}
}
