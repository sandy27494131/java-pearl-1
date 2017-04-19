package com.robert.dsal.advance.minsumdiff;

// TODO 如何证明 num > 10, 则两组和的最小差是0或者1呢？


/**
 * 
 * 根据蛮力法的求解： 2->7 4->30 6->9 8->4 10->19 12->0 14->1 16->0 18->1 20->0 22->1 24->0 26->1 可以看到，当数字数量超过10，数字平分后的两组和的最小差值是0或者1，
 * 如果整个数组和是偶数，能均分，如果整个数组和是奇数，则两组和最小相差1。
 * 
 * 那这个问题可以转换为寻找25个数字，使他们的和等于sum(x) / 2的某一个组合即可。 
 * 1. 可以用蛮力递归，回溯，分支界定等暴力法求解 
 * 2. 可以用贪婪，看如下:
 * 
 * 贪婪：可以先将数组按照奇数和偶数位分成2组，叫做奇数数组和偶数数组，然后，求出总数组之和的平均数(sum/2)，再求出平均数和偶数数组到之差T(
 * 偶数数组和小于T ，奇数数组和大于T)，接下来找到两数组中一对数字，使之差最接近于差T，然后，交换，以缩小奇偶数组和的差，直到为0或者1。
 * 
 */
public class MinDiffSearch implements MinDiff {

	public Result minDiff(int start, int end, int power) {
		// 数组初始化
		int[] x = new int[end - start + 1];

		for (int i = 0; i < x.length; i++) {
			x[i] = (int) Math.pow(start + i, power);
		}

		// 按照奇偶位置分成2分
		int[] xo = new int[x.length / 2];
		int[] xe = new int[x.length / 2];

		for (int i = 0; i < xe.length; i++) {
			xe[i] = x[i * 2];
			xo[i] = x[i * 2 + 1];
		}

		// 计算数组和
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}

		// 计算平均值
		int avg = sum / 2;

		// 计算偶数数组和
		int sume = 0;
		for (int i = 0; i < xe.length; i++) {
			sume += xe[i];
		}

		// 不需要计算奇数数组和，因为技术数组和可能等于偶数数组和或者偶数数组和加1

		// 计算差， 设置T， 这是不变量
		int diff = avg - sume;

		// 找到一对数字，使之和相差最接近diff的
		while (diff > 1) {
			// 找到奇数数字和偶数数组中某一对数字，这对数字之差最接近于diff
			int min = Integer.MAX_VALUE;
			int xi = 0;
			int xj = 0;
			for (int i = 0; i < xe.length; i++) {
				for (int j = 0; j < xe.length; j++) {
					// 任意一对数字之差
					int tmp = xo[i] - xe[j];
					// 与上面差值T的近似度
					int d = diff - tmp;

					// 如果比上面差值T近似读大于0，而且比之前的还要近似，也就是能够填补差值T，但是还保持偶数数组和小，奇数数组和大
					if (tmp > 0 && d >= 0 && d < diff && d < min) {
						xi = i;
						xj = j;
						min = d;
					}

				}
			}

			
			//TODO 这里不对，还是没法做到
			// 找到则交换
			int tmp = xo[xi];
			xo[xi] = xe[xj];
			xe[xj] = tmp;

			if (xi  == 0 && xj == 0) {
				for (int i = 0; i < xe.length; i++) {
					for (int j = 0; j < xe.length; j++) {
						// 任意一对数字之差
						tmp =  xo[i] - xe[j];
						// 与上面差值T的近似度
						int d = tmp - diff;

						// 如果比上面差值T近似读大于0，而且比之前的还要近似，也就是能够填补差值T，但是还保持偶数数组和小，奇数数组和大
						if (tmp >= 0 && d >= 0 && d < diff && d < min) {
							xi = i;
							xj = j;

							tmp = xo[xi];
							xo[xi] = xe[xj];
							xe[xj] = tmp;
							min = d;
						}

					}
				}		
				
			

				int[] abc = xe;
				xe = xo;
				xo = abc;
			}
			
			// 计算偶数数组和
			sume = 0;
			for (int i = 0; i < xe.length; i++) {
				sume += xe[i];
			}

			// 计算差， 设置T， 这是不变量
			diff = avg - sume;
		}

		// 返回结果
		Result result = new Result();
		result.diff = diff;
		for (int i = 0; i < xe.length; i++) {
			result.c1.add(xe[i]);
			result.c2.add(xo[i]);
		}

		return result;
	}

}
