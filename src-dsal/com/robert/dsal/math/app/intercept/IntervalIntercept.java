package com.robert.dsal.math.app.intercept;

import java.util.List;

/**
	Given a set of intervals - [a0,b0] [a1,b1] [a2,b2] [a3,b3] ......
	Let¡¯s assume the first interval [a0,b0] to be set A, and the union of all the rest intervals to be set B. Please write a program to calculate the intersection of A and B.
	 
	1. All intervals are finite closed intervals, their boundaries are integers. e.g. [2,17] [-9,0]
	2. Input: the given intervals are in the format like [3,5] [5,17] [1,6] [-2,0]. intervals are separated by a space, the boundaries are separated by a comma. please note there are no spaces inside the brackets []. The intervals are unordered and may overlap with one another.
	3. Output: the intersection should be printed in the same format as the input. when the intersection includes more than one intervals, the intervals must NOT overlap and they should be sorted in ascending order. when the intersection is an empty set, please print empty. If the input is invalid, please print invalid.

	Sample:
	
	1. input:
	[6,27] [5,7] [21,34] [13,25]
	output:
	[6,7] [13,27]
	
	2. input:
	[24,35] [3,20] [-2,9] [37,40]
	output:
	empty
 */
public interface IntervalIntercept {
	List<Interval> intercept(Interval i1, List<Interval> c2);
}
