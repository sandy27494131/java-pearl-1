package com.robert.design.looputil;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This class is an utility class to generate number in a loop range. It uses factory pattern to
 * provide 2 implementations. One is safe, the other not.
 * 
 * @author Robert Lee
 */

public class LoopNumFactory {
    public interface LoopNum {
        public long next();

        public void reset();
    }

    static class LoopNumImpl implements LoopNum {
        private long number;

        private long start;
        private long end;

        public LoopNumImpl(int end) {
            this(0, end);
        }

        public LoopNumImpl(int start, int end) {
            this.number = this.start = start;
            this.end = end;
        }

        public long next() {
            if (number == end) number = start;

            return number++;
        }

        public void reset() {
            this.number = start;
        }
    }


    static class LoopNumSafe implements LoopNum {
        private AtomicLong number = new AtomicLong();;

        private long start;
        private long end;

        public LoopNumSafe(int end) {
            this(0, end);
        }

        public LoopNumSafe(int start, int end) {
            number.set(start);

            this.start = start;
            this.end = end;
        }

        public long next() {
            if (number.get() == end) {
                // Here the atomic CAS operation is required
                number.compareAndSet(end, start);
            }

            return number.getAndIncrement();
        }

        public void reset() {
            this.number.set(start);
        }
    }

    public static LoopNum newInst(int end) {
        return newInst(0, end);
    }

    public static LoopNum newInst(int start, int end) {
        return new LoopNumImpl(start, end);
    }

    public static LoopNum newSafeInst(int end) {
        return newSafeInst(0, end);
    }

    public static LoopNum newSafeInst(int start, int end) {
        return new LoopNumSafe(start, end);
    }

}
