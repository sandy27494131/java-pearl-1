package com.robert.jvm.cocurrent;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class PriorityBlockingTest {

	static class FIFOElement implements Comparable<FIFOElement> {
		static final private AtomicLong al = new AtomicLong(0);
		private long seq = 0;

		public FIFOElement() {
			seq = this.al.incrementAndGet();
		}

		@Override
		public int compareTo(FIFOElement o) {
			long seqOther = o.getSeq();
			return seq < seqOther ? -1 : 1;
		}

		public long getSeq() {
			return seq;
		}

	}

	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueue<FIFOElement> pbq = new PriorityBlockingQueue<FIFOElement>();

		pbq.put(new FIFOElement());
		pbq.put(new FIFOElement());
		pbq.put(new FIFOElement());
		
		System.out.println(pbq.take().getSeq());
		System.out.println(pbq.take().getSeq());
		System.out.println(pbq.take().getSeq());
		
		// Priority Blocking Queue是按照升序排列的
	}

}
