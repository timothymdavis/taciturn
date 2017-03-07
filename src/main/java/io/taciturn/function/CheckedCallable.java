package io.taciturn.function;

@FunctionalInterface
public interface CheckedCallable<T> {

    T call() throws Throwable;

}
