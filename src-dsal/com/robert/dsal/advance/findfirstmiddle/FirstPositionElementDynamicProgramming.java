package com.robert.dsal.advance.findfirstmiddle;

/*
 * 动态规划过程
 * 
 * 1. 假设第一个元素为标杆元素，第一个元素为最大元素，从第二个元素开始进行循环，每次循环都要做决策
 * 2. 循环的每一步骤
 * 2.1 如果元素递增，标杆元素未失效（标杆之后都是大于标杆的值),所以，标杆不变，但是最大和变化了
 * 2.2 如果出现一个元素比标杆元素小，则标杆元素失效，从标杆元素到当前元素递增，如果当前元素比标杆元素小，那么之前所有元素都作废，因为之前所有元素后面都有个小元素，即当前元素，当前元素因为之前有大元素，所以也作废
 * 2.3 如果标杆元素作废了，没有标杆元素，那么下次需要选择新的标杆元素，标准就是比之前最大值大的就是下一个标杆元素
 *  
 */
public class FirstPositionElementDynamicProgramming implements
		FirstPositionElementFinder {

	public int findFirstPositionElement(int[] seq) {
		// 5, 6, 2, 1, 10, 20, 15

		// 第一个元素左边没元素，初始化为标杆元素，同时初始为当前最大元素---[5]
		int posIndex = 0;
		int curMaxValue = seq[0];

		// 向前推荐， posIndex = -1代表没有标杆元素， posIndex != -1代表着标杆元素后面的值都大于标杆元素
		for (int i = 1; i < seq.length; i++) {

			// 如果元素递增，则标杆元素不变，但是最大元素则改变，这部分逻辑是隐式逻辑
			// if (posIndex != -1 && seq[i] > seq[posIndex]

			// 递增过程中遇到了一个比标杆元素小的元素---[2]
			// 遇到的第3个元素2，比第1个元素5要小，第3个元素之前的元素递增，所以，第3个元素要小于之前所有元素，因此，从第3个包括第3个之前的所有元素都不是目标元素，所以，posIndex=-1
			if (posIndex != -1 && seq[i] < seq[posIndex])
				posIndex = -1;
			// 无标杆状态下遇到了一个大于最大元素的元素，则重新开始查找，并且重新设置标杆元素---[10]
			// 遇到的新的标杆元素可能是目标元素
			else if (posIndex == -1 && seq[i] >= curMaxValue) {
				posIndex = i;
			}

			// 始终要保持追中最大元素
			// 1. 如果递增，只记录当前的最大值---[6][10][15]
			// 2. 如果递减，只记录当前的最大值---[1]
			// 3. 其他情况也只记录当前最大值
			if (seq[i] > curMaxValue)
				curMaxValue = seq[i];
		}

		return (posIndex != -1) ? seq[posIndex] : -1;
	}
}
