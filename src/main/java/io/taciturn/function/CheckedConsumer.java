package io.taciturn.function;

@FunctionalInterface
public interface CheckedConsumer<T> {

    void apply(T t) throws Throwable;

}
