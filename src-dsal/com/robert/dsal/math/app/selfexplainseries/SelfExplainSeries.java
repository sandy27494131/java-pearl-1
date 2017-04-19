package com.robert.dsal.math.app.selfexplainseries;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelfExplainSeries implements Series{
	private List<Element> series = new ArrayList<Element>();

	private boolean extensible = false;

	private int extendNum = (int) Math.pow(2, 8);

	class SESIterator implements Iterator<Element> {
		int current;

		SESIterator() {
			current = 0;
		}

		public boolean hasNext() {
			if (extensible)
				return true;

			if (current != series.size() - 1)
				return true;

			return false;
		}

		public Element next() {
			if (current == series.size())
				extend();

			return series.get(current++);
		}

		private void extend() {
			Element see = series.get(series.size() - 1);
			for (int i = 0; i < extendNum; i++) {
				see = see.next();
				series.add(see);
			}

			extendNum *= 2;
		}

		public void remove() {
			throw new RuntimeException("Not supported!");
		}

	}

	public SelfExplainSeries(byte[] init) {
		this(new SelfExplainElement(init), 10, true);
	}

	public SelfExplainSeries(Element init) {
		this(init, 10, true);
	}

	public SelfExplainSeries(byte[] init, int limit) {
		this(new SelfExplainElement(init), limit, false);
	}

	public SelfExplainSeries(Element init, int limit) {
		this(init, limit, false);
	}

	public SelfExplainSeries(Element init, int n, boolean extendable) {
		this.extensible = extendable;

		initSeries(init, n);
	}

	protected void initSeries(Element init, int n) {
		int count = 1;
		do {
			series.add(init);
			init = init.next();
		} while (count++ < n);
	}

	public Iterator<Element> iterator() {
		return new SESIterator();
	}
}
