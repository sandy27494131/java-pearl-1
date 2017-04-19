package com.robert.dsal.lookup.app.findreversepair;

public class ReversePairCounterDefault implements ReversePairCounter {
    public int countReversePair(int[] seq) {
        int count = 0;

        for (int i = 0; i < seq.length; i++) {
            for (int j = i + 1; j < seq.length; j++) {
                if (seq[i] > seq[j])
                    count++;
            }
        }

        return count;
    }
}
