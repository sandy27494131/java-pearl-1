package com.robert.dsal.math.probability.conversion;

import java.util.Date;
import java.util.Random;

/**
 * 
 * 问题定义：已知一个函数均等概率产生0和1,求实现一个函数以均等概率产生0,1和2。
 *
 */
class Random01 {
    private Random rndm = new Random(new Date().getTime());

    public int generate01() {
        int r = rndm.nextInt();
        if (r < 0) r = -r;
        return r % 2;
    }
}


public interface ProbConversion {
    public int generate012(Random01 rndm01);
}
