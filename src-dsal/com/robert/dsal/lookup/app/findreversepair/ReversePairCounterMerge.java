package com.robert.dsal.lookup.app.findreversepair;

public class ReversePairCounterMerge implements ReversePairCounter {
    private int countReversePairMerge(int[] seq, int start, int middle, int end) {
        int count = 0;

        int[] tmp = new int[end - start + 1];
        int t = 0;

        int i = start;
        int j = middle + 1;

        while (i <= middle && j <= end) {
            if (seq[i] > seq[j]) {
                // The number behind of seq[i] is greater than it
                count += middle - i + 1;
                tmp[t++] = seq[j++];
            } else {
                tmp[t++] = seq[i++];
            }
        }

        while (i <= middle) {
            tmp[t++] = seq[i++];
        }

        while (j <= end) {
            tmp[t++] = seq[j++];
        }

        for (i = 0; i < tmp.length; i++) {
            seq[start + i] = tmp[i];
        }

        return count;
    }

    public int countReversePair(int[] seq, int start, int end) {
        if (start >= end)
            return 0;

        int middle = (start + end) / 2;

        int countLeft = countReversePair(seq, start, middle);
        int countRight = countReversePair(seq, middle + 1, end);

        int count = countReversePairMerge(seq, start, middle, end);

        return count + countLeft + countRight;
    }

    public int countReversePair(int[] seq) {
        return countReversePair(seq, 0, seq.length - 1);
    }
}
