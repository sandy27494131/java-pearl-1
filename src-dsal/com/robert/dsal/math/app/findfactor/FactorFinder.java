package com.robert.dsal.math.app.findfactor;

/**
 * 
 * 给定一个正整数，求所有因子的个数。如6的因子是1,2,3,6，个数为4;
 * 
 */
public interface FactorFinder {
    public int[] findFactors(int n);
}
