package com.robert.jvm.gc.comm;

public class GcDataObject {
    private static final int[] UNIT_TABLE = {1024, 1024 * 1024, 1024 * 1024 * 1024, 1024 * 1024 * 1024 * 1024,
            1024 * 1024 * 1024 * 1024 * 1024};

    public enum SizeUnit {
        K, M, G, T, P;
    }

    int[] data;

    private int size;
    private SizeUnit unit;

    public GcDataObject(int size, SizeUnit unit) {
        this.size = size;
        this.unit = unit;

        int rawSize = size * UNIT_TABLE[unit.ordinal()];
        this.data = new int[rawSize];
    }

    @Override
    public String toString() {
        return "GcDataObject [size=" + size + ", unit=" + unit + "]";
    }

}
