package com.robert.dsal.lookup.app.findreversepair;

/**
 * 
 * 若数组中某个下标值大的元素值小于某个下标值比它小的元素值，称这是一个反序。给定一个数组，要求写一个函数，计算出这个数组里所有反序的个数。时间复杂度n*
 * log2n
 * 
 */
public interface ReversePairCounter {
    public int countReversePair(int[] seq);
}
