package com.robert.dsal.math.probability.conversion;

/**
 * 
 * 思路：
 * 
 * 已知函数加上自己，得到1/4的0, 1/4的2, 还有2/4的1,对1再做一次0/1概率，可以去掉一半的概率，因此1也就剩下了1/4
 * 
 * 可得： 去掉的1/4需要再次进行递归求解
 *
 */

public class ProbConversionByPermDiscard implements ProbConversion {
    public int generate012(Random01 rndm01) {
        // 相加得到1/4的0, 1/4的2, 和2/4的1
        int r = rndm01.generate01() + rndm01.generate01();

        // 2/4的1
        if (r == 1) {
            int r1 = rndm01.generate01();
            // 1/4的1抛弃并且递归求解
            if (r1 == 0) return generate012(rndm01);

            // 1/4的1返回
            return r1;
        }

        // 1/4的0和1/4的2返回
        return r;
    }
}
