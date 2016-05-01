package io.taciturn.function;

@FunctionalInterface
public interface CheckedCallable<T> {

    T apply() throws Throwable;

}
