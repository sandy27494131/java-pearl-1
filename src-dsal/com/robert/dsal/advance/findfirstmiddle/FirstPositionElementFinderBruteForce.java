package com.robert.dsal.advance.findfirstmiddle;

import java.util.ArrayList;
import java.util.List;

public class FirstPositionElementFinderBruteForce implements FirstPositionElementFinder {

    public int findFirstPositionElement(int[] seq) {
        List<Integer> result = new ArrayList<Integer>();
        outer: for (int i = 0; i < seq.length; i++) {
            for (int j = 0; j < i; j++)
                if (seq[j] > seq[i])
                    continue outer;

            for (int k = i + 1; k < seq.length; k++)
                if (seq[k] < seq[i])
                    continue outer;

            result.add(seq[i]);
        }

        // Get All, return one
        if (result.size() > 0)
            return result.get(0);

        return -1;
    }

}
