package me.joan.internal;

public class ThreadFactory {
    @FunctionalInterface
    public interface ThreadGenerator {
        Thread create(Runnable runnable);
    }

    public static ThreadGenerator withName(String name) {
        return runnable -> new Thread(runnable, name);
    }
}
