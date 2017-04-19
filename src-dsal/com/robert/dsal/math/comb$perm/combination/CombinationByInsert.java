package com.robert.dsal.math.comb$perm.combination;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 递归次数：目标集合的元素数，每次确定一个元素 
 * 递归行为：每次确定一个元素，这个元素取自当前开始字符到s.length - count + 递归次数，每个元素试验一次，然后递归下一次，递归下一次是从上次选中元素开始到s.length - count + 递归次数个数据，下次递归的开始索引是当前递归的右边开始的，有顺序关系，
 * 例如：abc, 选择了a只能再选b和c，选择了b只能再选c，因此有了bc，永远不会有cb，因此组合就不会重复，这就是和排列的区别
 * 
 */
public class CombinationByInsert implements Combination {

	public List<String> combination(String s, int count) {
		List<String> results = new LinkedList<String>();
		StringBuffer result = new StringBuffer();

		combination(results, result, s, count, 0, 0);

		return results;
	}

	private void combination(List<String> results, StringBuffer buffer,
			String s, int count, int current, int start) {
		// 求N个元素count个元素的组合，每次递归确定一个元素，一共递归count次，因此current = count就是结束条件
		if (current == count) {
			results.add(buffer.toString());
			return;
		}

		// 从每次递归开始元素往后直到s.lengh - count + 递归次数是当前的搜索范围，一次尝试之，尝试之后就固定了一个元素
		for (int i = start; i <= s.length() - count + current; i++) {
			char c = s.charAt(i);
			buffer.insert(0, c);

			// 这里current是count的计数器，到了count为止，也就是目标组合有多少元素就有多少次递归
			// i + 1意味着下次只取当前元素右边的元素，免得组合重复，例如：abc，这样取了a就只能再取b和c，取了b就只能取c，免得ab和ba重复，因为是用来求组合的
			combination(results, buffer, s, count, current + 1, i + 1);

			buffer.deleteCharAt(0);
		}
	}

}
