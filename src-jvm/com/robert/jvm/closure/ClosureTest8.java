package com.robert.jvm.closure;

public class ClosureTest8 {

    public static Supplier<Integer> testClosure() {
        int i = 1;
        return () -> {
            return i;
        };
    }

    public interface Supplier<T> {
        T get();
    }

    public static void main(String[] args) {
        System.out.println(testClosure().get());
    }

}
