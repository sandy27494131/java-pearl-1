package com.robert.design.looputil;

import java.util.ArrayList;
import java.util.List;

import com.robert.design.looputil.LoopNumFactory.LoopNum;

/**
 * This is test cases for LoopNum implementation. It firstly verify the functionality and then the
 * performance.
 * 
 * @author Robert Lee
 */

public class LoopNumTest {
    public static void main(String[] args) {
        // Init
        LoopNum ln = LoopNumFactory.newInst(0, 5);
        LoopNum lns = LoopNumFactory.newSafeInst(0, 5);

        // Functional Test
        List<Long> result = new ArrayList<Long>() {
            public String toString() {
                StringBuffer sb = new StringBuffer("[");
                for (int i = 0; i < this.size(); i++) {
                    if (i != 0) sb.append(",");

                    sb.append(this.get(i));
                }
                sb.append("]");
                return sb.toString();
            }
        };

        for (int i = 0; i < 30; i++) {
            long n;
            if ((n = ln.next()) != lns.next()) {
                throw new RuntimeException("Function Wrong!");
            }
            result.add(n);
        }
        System.out.println(result);

        // Performance Test
        final int times = 1000000;

        ln.reset();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            ln.next();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("LoopNum uses: " + (t2 - t1) + " ms");


        lns.reset();
        t1 = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            lns.next();
        }
        t2 = System.currentTimeMillis();
        System.out.println("Safe LoopNum uses: " + (t2 - t1) + " ms");
    }
}
