package com.robert.dsal.math.app.selfexplainseries;

import java.util.Arrays;

public class SelfExplainElement implements Element {
	byte[] data;

	public SelfExplainElement(byte[] data) {
		this.data = data;
		Arrays.sort(this.data);
	}

	public Element next() {
		byte[] nextTempData = new byte[data.length * 2];
		int num = -1;

		byte current = data[0];
		byte count = 1;

		int i = 1;
		while (i < data.length) {
			if (data[i] == current) {
				count++;
			} else {
				nextTempData[++num] = count;
				nextTempData[++num] = current;

				current = data[i];
				count = 1;
			}

			i++;
		}

		if (i == data.length && count > 0) {
			nextTempData[++num] = count;
			nextTempData[++num] = current;
		}

		byte[] nextData = (byte[]) Arrays.copyOfRange(nextTempData, 0, num + 1);

		return new SelfExplainElement(nextData);
	}

	public int compareTo(Element o) {
		SelfExplainElement other = (SelfExplainElement) o;

		if (data.length != other.data.length)
			return data.length - other.data.length;

		int i = 0;

		while (i < data.length && data[i] == other.data[i])
			i++;

		if (i == data.length)
			return 0;

		return data[i] - other.data[i];
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < data.length; i++) {

			System.out.print((i == 0 ? "(" : ",") + data[i]
					+ (i == data.length - 1 ? ")" : ""));
		}

		return sb.toString();
	}

}
