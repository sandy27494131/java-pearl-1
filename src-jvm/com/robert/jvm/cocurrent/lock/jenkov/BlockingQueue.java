package com.robert.jvm.cocurrent.lock.jenkov;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

	private List queue = new LinkedList();
	private int limit = 10;

	public BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		// 当前队列为空，在要插入之前，通知所有出队列线程去竞争出列，因为同步，所以，可以先通知
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		// 当前队列满，在要出队列一个元素前，通知入队准备好去入元素
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

}
