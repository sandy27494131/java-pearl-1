package com.robert.dsal.advance.minsumdiff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/**
 * 双向搜索:
 * 
 * 把50个数先分成两组A和B，每组25个，生成这A组和B组子集长度为1-25的子集的和，都做成hash表，然后用对于A的长度i的集合的元素之和k，sum/2
 * -k看是否在B长度为25-i的子集中。
 * 
 * 假设：我们已经证明1-50个数字的立方，平分后和相差0或者1
 * 
 */
public class MinDiffDoubleWaySearch implements MinDiff {

	public Result minDiff(int start, int end, int power) {
		// 数组初始化
		int[] x = new int[end - start + 1];

		for (int i = 0; i < x.length; i++) {
			x[i] = (int) Math.pow(start + i, power);
		}

		// 按照奇偶位置分成2分
		int[] xe = new int[x.length / 2];
		int[] xo = new int[x.length / 2];

		for (int i = 0; i < xe.length; i++) {
			xe[i] = x[i * 2];
			xo[i] = x[i * 2 + 1];
		}

		// 计算数组和
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}

		// 计算hash和，数组有25个元素，表示从1个数到25个数的和的集合，集合中的key是和，value是构成这个和的那些数字列表
		HashMap<Integer, List<Integer>>[] hos = map(xo);
		HashMap<Integer, List<Integer>>[] hes = map(xe);

		// 对于1个数到25个数的集合
		for (int i = 0; i < hos.length; i++) {
			HashMap<Integer, List<Integer>> ho = hos[i];
			Iterator<Entry<Integer, List<Integer>>> iter = ho.entrySet()
					.iterator();

			// 对于具有i个数字的集合
			while (iter.hasNext()) {
				Entry<Integer, List<Integer>> entryo = iter.next();
				// 取得此集合的和和集合元素个数
				int sumo = entryo.getKey();
				int numo = i + 1;

				// 找到另外一个25个数字数组里的和这些数组合并能够25个的集合
				int nume = 25 - numo;
				HashMap<Integer, List<Integer>> he = hes[nume - 1];
				Iterator<Entry<Integer, List<Integer>>> iter1 = he.entrySet()
						.iterator();
				while (iter1.hasNext()) {
					Entry<Integer, List<Integer>> entrye = iter1.next();

					int sume = entrye.getKey();

					if (sumo + sume == sum / 2) {
						// 如何两个集合合并正好等于总和的一般，就是答案
						Result result = new Result();
						result.diff = ((sum % 2 == 0) ? 0 : 1);
						result.c1.addAll(entryo.getValue());
						result.c1.addAll(entrye.getValue());

						for (int j = 0; j < x.length; j++) {
							if (!result.c1.contains(x[j]))
								result.c2.add(x[j]);
						}
						return result;
					}

				}
			}

		}

		return null;
	}

	private HashMap<Integer, List<Integer>>[] map(int[] xo) {
		HashMap<Integer, List<Integer>>[] results = new HashMap[xo.length];

		// 1 - 25个
		for (int i = 0; i < results.length; i++) {
			results[i] = doMap(xo, i + 1);
		}

		return results;
	}

	private HashMap<Integer, List<Integer>> doMap(int[] xo, int count) {
		HashMap<Integer, List<Integer>> results = new HashMap<Integer, List<Integer>>();
		List<Integer> buffer = new ArrayList<Integer>();

		// 插入法求组和
		doMap(xo, count, results, buffer, 0, 0);

		return results;
	}

	private void doMap(int[] xo, int count,
			HashMap<Integer, List<Integer>> result, List<Integer> buffer,
			int current, int start) {
		if (current == count) {
			// 找到一个解
			int sum = sum(buffer);

			List<Integer> coll = new ArrayList<Integer>();
			coll.addAll(buffer);

			result.put(sum, coll);
			return;
		}

		// 循环加递归
		for (int i = start; i < xo.length - count + current; i++) {
			buffer.add(xo[i]);

			doMap(xo, count, result, buffer, current + 1, i + 1);

			buffer.remove(new Integer(xo[i]));
		}

	}

	private int sum(List<Integer> buffer) {
		int sum = 0;
		for (int i = 0; i < buffer.size(); i++) {
			sum += buffer.get(i);
		}
		return sum;
	}

}
