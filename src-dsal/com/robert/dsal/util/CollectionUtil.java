package com.robert.dsal.util;

import java.util.List;

public class CollectionUtil {
    public static int[] convert(List<Integer> seq) {
        int[] tmp = new int[seq.size()];

        for (int i = 0; i < tmp.length; i++)
            tmp[i] = seq.get(i);
        return tmp;
    }

    public static Integer[] convert(int[] seq) {
        Integer[] tmp = new Integer[seq.length];

        for (int i = 0; i < tmp.length; i++)
            tmp[i] = seq[i];

        return tmp;
    }

    public static int[][] convertArray(List<List<Integer>> seq) {
        int[][] tmp = new int[seq.size()][];

        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = convert(seq.get(i));
        }

        return tmp;
    }
}
