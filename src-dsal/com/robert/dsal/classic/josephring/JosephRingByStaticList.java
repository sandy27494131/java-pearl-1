package com.robert.dsal.classic.josephring;

public class JosephRingByStaticList implements JosephRing {
    public int findLastOut(int n, int m) {
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = (i + 1) % n;
        }

        int j = 0;
        while (data[j] != j) {
            for (int k = 0; k < m - 2; k++)
                j = data[j];

            // System.out.print(data[j] + " ");
            data[j] = data[data[j]];
            j = data[j];
        }

        return j;
    }
}
