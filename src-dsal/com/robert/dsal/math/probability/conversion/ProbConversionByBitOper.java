package com.robert.dsal.math.probability.conversion;

/**
 * 
 * 思路：
 * 
 * 1. 已知均等概率产生0和1,容易想到位操作 
 * 2. 通过位操作可以产生0-15共16个数字，并且概率相等 
 * 3. 3的倍数是15, 所以，应该抛弃其中的一个数字15，剩下一共0-14共15个数字
 * 
 * 可得：再除3取模可得均等的0,1,2
 *
 */

public class ProbConversionByBitOper implements ProbConversion {
    public int generate012(Random01 rndm01) {
        int i = 0;

        // 产生0-F 16个数字，去掉15, 就是0-14共15个数字，每个数字的几率是均等的，因为每个位上是0和1的概率都是50%
        while ((i = ((rndm01.generate01() << 3) + (rndm01.generate01() << 2) + (rndm01.generate01() << 1) + rndm01.generate01())) == 15);

        // 然后除以3就产生均等的0,1,2
        return i % 3;
    }
}
