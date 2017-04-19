package com.robert.jvm.closure;

public class ClosureTest7 {

    public static Supplier testClosure() {
        final int i = 1;
        return new Supplier() {
            @Override
            public Integer get() {
                return i;
            }
        };
    }

    public interface Supplier<T> {
        T get();
    }

    public static void main(String[] args) {
        System.out.println(testClosure().get());
    }
}
