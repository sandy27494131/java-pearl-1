package com.robert.dsal.math.probability.conversion;

import java.util.HashMap;
import java.util.Map;

public class ProbConversionTest {
    public static void main(String[] args) {
        final int times = 1000000;
        Random01 random01 = new Random01();

        // Test 1
        ProbConversion perm50233 = new ProbConversionByBitOper();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < times; i++) {
            int key = perm50233.generate012(random01);
            if (map.containsKey(key))
                map.put(key, (Integer) map.get(key) + 1);
            else
                map.put(key, 1);
        }

        System.out.println(map.get(0));
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println();

        map.clear();

        // Test 2
        perm50233 = new ProbConversionByPermDiscard();

        for (int i = 0; i < times; i++) {
            int key = perm50233.generate012(random01);
            if (map.containsKey(key))
                map.put(key, (Integer) map.get(key) + 1);
            else
                map.put(key, 1);
        }

        System.out.println(map.get(0));
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println();

        map.clear();

        // Test 3
        perm50233 = new ProbConversionByOper();

        for (int i = 0; i < times; i++) {
            int key = perm50233.generate012(random01);
            if (map.containsKey(key))
                map.put(key, (Integer) map.get(key) + 1);
            else
                map.put(key, 1);
        }

        System.out.println(map.get(0));
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println();
        
        map.clear();
        
        // Test 4
        perm50233 = new ProbConversionByOper1();

        for (int i = 0; i < times; i++) {
            int key = perm50233.generate012(random01);
            if (map.containsKey(key))
                map.put(key, (Integer) map.get(key) + 1);
            else
                map.put(key, 1);
        }

        System.out.println(map.get(0));
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println();
    }
}
