package com.robert.dsal.math.app.findfactor;

import java.util.ArrayList;
import java.util.List;

import com.robert.dsal.util.CollectionUtil;

public class FactorFinderImpl implements FactorFinder {

    public int[] findFactors(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result.add(i);
                result.add(n / i);
            }
        }
        return CollectionUtil.convert(result);
    }

}
