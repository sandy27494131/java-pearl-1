package com.robert.jvm.gc;

import java.util.Date;
import java.util.Random;

import com.robert.jvm.gc.comm.GcDataObject;

public class CmsVsParallel {

    public static void main(String[] args) {
        Random seed = new Random(new Date().getTime());
        for (int i = 0; i < 1000; i++) {
            int size = seed.nextInt(100);
            GcDataObject gdo = new GcDataObject(size, GcDataObject.SizeUnit.M);
        }
    }

}
