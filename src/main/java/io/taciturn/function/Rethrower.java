package io.taciturn.function;

/**
 * Checked exceptions are a bit of a pain with functional interfaces. Use the methods of this class to rethrow
 * checked exceptions without reclassifying them as runtime exceptions.
 */
public class Rethrower {

    public static <T> T rethrow(CheckedCallable<T> callable) {
        return rethrowFunction(o -> callable.apply(), null);
    }

    public static <T> void rethrow(CheckedConsumer<T> consumer, T consumerParameter) {
        rethrowFunction(o -> {
            consumer.apply(o);
            return (Void) null;
        }, consumerParameter);
    }
    
    public static <A, B> B rethrow(CheckedFunction<A, B> function, A functionParameter) {
        return Rethrower.rethrowFunction(function::apply, functionParameter);
    }
    
    public static void rethrow(Throwable throwable) {
        Rethrower.<RuntimeException>rethrowCheckedThrowable(throwable);
    }

    private static <A, B> B rethrowFunction(CheckedFunction<A, B> function, A functionParameter) {
        try {
            return function.apply(functionParameter);
        } catch (Throwable e) {
            Rethrower.rethrow(e);
            throw new IllegalStateException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void rethrowCheckedThrowable(Throwable throwable) throws T {
        throw (T) throwable;
    }

}
