package com.robert.dsal.math.probability.randomnlines;

import java.util.Iterator;

// TODO 再看编程珠玑，看看概率相关的求值方法，编程珠玑上都是已知集合数量的

/**
 
给你一个函数 int rd()， 这个函数50%返回 0 , 50%返回1. 让你写一个新函数， 25%返回0 ， 75%返回1

rand() + rand() * 2  % 4 == 0 

Robert Lee 6/18/2014 3:22:21 PM
这个就是1/4的概率

Robert Lee 6/18/2014 3:22:41 PM
取反，就是rand() + rand() * 2 % 4 != 0

Robert Lee 6/18/2014 3:22:48 PM
这个就是3/4的概率

rd*rd != 0

*/

/**
 * 
 * 还有一种方法就是每次选出一个，然后减去这个元素，再sample
 * 
 */
public interface SampleN {
	public int[] sample(Iterator<Integer> x, int n);
}
