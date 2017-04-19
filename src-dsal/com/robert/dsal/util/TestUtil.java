package com.robert.dsal.util;

import com.robert.dsal.list.ds.LinkedListNode;
import com.robert.dsal.sort.QuickSort;
import com.robert.dsal.sort.Sort;

public class TestUtil {
    public static void assertEqual(LinkedListNode m, LinkedListNode n) {
        while (m != null && n != null) {
            if (m.value != n.value)
				throw new RuntimeException("Not Equal!");

            m = m.next;
            n = n.next;
        }

        if (m != null || n != null)
            throw new RuntimeException("Not Equal!");

    }

    public static void assertEqual(int a, int b) {
        if (a != b)
            throw new RuntimeException("Not equal!");
    }

    public static void assertEqual(String a, String b) {
        if (!a.equals(b))
            throw new RuntimeException("Not equal!");
    }

    public static void assertLessOrEqual(int a, int b) {
        if (a > b)
            throw new RuntimeException("Not Less or Equal!");
    }

    public static void assertEqual(int[] a, int[] b) {
        if (a.length != b.length)
            throw new RuntimeException("Not Equal!");

        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                throw new RuntimeException("Not Equal!");

    }

    public static void assertElementsEqual(int[] a, int[] b) {
        if (a.length != b.length)
            throw new RuntimeException("Not Equal!");

        Sort sort = new QuickSort();
        sort.sort(a);
        sort.sort(b);

        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i])
                throw new RuntimeException("Not Equal!");

    }
    
    public static void assertContains(int[] a, int b) {
        boolean bContains = false;
        for(int i = 0; i < a.length; i ++) {
        	if (a[i] == b)
        		bContains = true;
        }
        if (!bContains)
        	throw new RuntimeException("Not In!");
    }

    public static void assertTrue(boolean b) {
    	if (!b)
    		throw new RuntimeException("Not True!");
    }

    public static void assertFalse(boolean b) {
    	if (b)
			throw new RuntimeException("Not False!");
    }
}
