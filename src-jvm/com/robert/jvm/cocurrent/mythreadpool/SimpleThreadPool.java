package com.robert.jvm.cocurrent.mythreadpool;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleThreadPool<T> implements ThreadPool<T> {
	private int threadNum;

	private BlockingQueue<Task<T>> bq = new LinkedBlockingQueue<Task<T>>();

	private List<WorkerThread> workers = new CopyOnWriteArrayList<WorkerThread>();

	class WorkerThread extends Thread {
		private boolean stopped = false;

		public void run() {
			while (true) {
				if (stopped)
					break;

				Task<T> t;
				try {
					t = bq.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}

				T result = t.run();

				if (t instanceof ResultTask<?>) {
					ResultTask<T> rt = (ResultTask<T>) t;
					rt.setResult(result);
				}
			}
		}

		public void stopWorker() {
			this.stopped = true;
		}
	}

	public SimpleThreadPool(int threadNum) {
		this.threadNum = threadNum;
		
		for (int i = 0; i < this.threadNum; i++) {
			this.workers.add(new WorkerThread());
		}
	}

	@Override
	public void runTask(Task<T> t) {
		try {
			this.bq.put(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void startup() {
		for (int i = 0; i < this.threadNum; i++) {
			this.workers.get(i).start();
		}
	}

	@Override
	public void shutdown() {
		for (int i = 0; i < this.threadNum; i++) {
			this.workers.get(i).stopWorker();
		}
	}

}
