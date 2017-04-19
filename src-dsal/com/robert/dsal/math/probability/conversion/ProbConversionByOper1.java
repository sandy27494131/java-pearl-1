package com.robert.dsal.math.probability.conversion;

import com.robert.design.looputil.LoopNumFactory;
import com.robert.design.looputil.LoopNumFactory.LoopNum;


/**
 * 思路：
 * 
 * 1. 已知函数均等概率产生0和1 2. 通过将已知函数加1可以均等产生1和2 3. 通过将已知函数乘以2可以均等产生0和2
 * 
 * 可得：通过这3个函数轮流产生概率均等的0,1,2
 *
 */
public class ProbConversionByOper1 implements ProbConversion {
    private LoopNum ln = LoopNumFactory.newSafeInst(0, 3);

    public int generate012(Random01 rndm01) {

        switch ((int) ln.next()) {
            case 0:
                return rndm01.generate01();
            case 1:
                return rndm01.generate01() + 1;
            case 2:
                return rndm01.generate01() * 2;
        }

        return -1;
    }

}
