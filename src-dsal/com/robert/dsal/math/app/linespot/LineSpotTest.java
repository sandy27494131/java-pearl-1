package com.robert.dsal.math.app.linespot;

import com.robert.dsal.advance.optimumpath.Point;
import com.robert.dsal.util.DataUtil;

public class LineSpotTest {

	public void run() {
		final int N = 10;
		int[] seq = DataUtil.genSeq(N * 2);

		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			Point point = new Point();
			point.x = seq[i];
			point.y = seq[N - 1 - i];

			points[i] = point;
		}

		LineSpot ls = new LineSpotImpl();
		int count = ls.spotLine(points);

		System.out.format("Count: %d", count);
		System.out.println();
	}

	public static void main(String[] args) {
		new LineSpotTest().run();
	}
}
