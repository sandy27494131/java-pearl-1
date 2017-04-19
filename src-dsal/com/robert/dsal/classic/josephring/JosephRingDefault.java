package com.robert.dsal.classic.josephring;

public class JosephRingDefault implements JosephRing {
    public int findLastOut(int n, int m) {
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            data[i] = 1;
        }

        int j = 0;

        int k = 1;
        int count = 1;
        while (true) {
            if (data[j] != 0) {
                if (k == m) {
                    data[j] = 0;
                    // System.out.print(j + " ");

                    k = 1;
                    if (count == n) {
                        return j;
                    }
                    count++;
                } else {
                    k++;
                }
            }

            if (++j == n)
                j = 0;
        }
    }
}
