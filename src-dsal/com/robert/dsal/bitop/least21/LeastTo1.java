package com.robert.dsal.bitop.least21;

// TODO Not Implemented

/*

 问题：实现一个函数，对一个正整数n，算得到1需要的最少操作次数。操作规则为：如果n为偶数，将其除以2；如果n为奇数，可以加1或减1；一直处理下去。

 方法一：

 二进制法：http://blog.csdn.net/chinaren69fy/article/details/3568115

 例如：        111100111
 +1右移：	 5 2  5    
 -1左移：	 6 2  6
 可见：+1右移步骤少，也就是+1除以2步骤少		    

 右移操作就是除以2，例如10，右移1位，变成了1

 为了去掉连续的1，对比两种情况：+1右移多位 和 -1右移一位然后重复对比，通过二进制位数来计算


 方法二：

 动态规划
 1 2 3 4 5 6 7 8 9 10
 0 1 2 2 3 3 4 3 4  4

 */
public interface LeastTo1 {
	public int calcLeastTo1(int num);
}
