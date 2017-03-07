package io.taciturn.function;

import lombok.NonNull;

/**
 * Checked exceptions are a bit of a pain with functional interfaces. Use the methods of this class to rethrow
 * checked exceptions without reclassifying them as runtime exceptions.
 */
@SuppressWarnings("WeakerAccess")
public class Rethrower {

    public static <T> T rethrow(CheckedCallable<T> callable) {
        return rethrowFunction(o -> callable.call(), null);
    }

    public static <T> void rethrow(CheckedConsumer<T> consumer, T consumerParameter) {
        rethrowFunction(o -> {
            consumer.accept(o);
            return (Void) null;
        }, consumerParameter);
    }
    
    public static <A, B> B rethrow(CheckedFunction<A, B> function, A functionParameter) {
        return Rethrower.rethrowFunction(function, functionParameter);
    }
    
    public static void rethrow(Throwable throwable) {
        Rethrower.rethrowCheckedThrowable(throwable);
    }

    @SuppressWarnings("ConstantConditions")
    private static <A, B> B rethrowFunction(CheckedFunction<A, B> function, A functionParameter) {
        try {
            return function.apply(functionParameter);
        } catch (Throwable e) {
            Rethrower.rethrow(e);
            throw new IllegalStateException(e);
        }
    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    private static <T extends Throwable> void rethrowCheckedThrowable(@NonNull Throwable throwable) throws T {
        throw (T) throwable;
    }

}
