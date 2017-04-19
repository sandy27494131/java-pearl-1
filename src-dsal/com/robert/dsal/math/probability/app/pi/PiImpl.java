package com.robert.dsal.math.probability.app.pi;

import java.util.Date;
import java.util.Random;

/**
 * 
 * (PI * r * r / 4) / (r * r) = PI / 4, 也就是说在第一像限，有PI/4的点落在圆的里面。
 * 
 * PI*r^2是圆的面积，除以4，是第一像限圆的面积，r^2是第一像限所在正方形的面积， PI/4就是 1/4圆所在的面积比上正方形面积的比例ratio
 * 
 * PI = ratio * 4
 * 
 * 
 */
public class PiImpl implements Pi {
	public double calcPi() {
		final int nums = 10000000;

		int numsin = 0;
		Random ran = new Random(new Date().getTime());

		for (int i = 0; i < nums; i++) {
			double x = ran.nextDouble();
			double y = ran.nextDouble();

			// 在圆内则统计数量
			if (x * x + y * y < 1 * 1)
				numsin++;
		}

		// ratio * 4
		return ((double) numsin / nums) * 4;
	}
}
