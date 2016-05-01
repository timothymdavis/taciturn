package io.taciturn.utility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;

import io.taciturn.function.CheckedFunction;
import io.taciturn.function.Rethrower;

public class MethodUtility extends ObjectUtility<Method> {

    public static final Predicate<Method> IS_PUBLIC_METHOD = o -> Modifier.isPublic(o.getModifiers());
    public static final Predicate<Method> IS_PRIVATE_METHOD = o -> Modifier.isPrivate(o.getModifiers());
    public static final Predicate<Method> IS_PROTECTED_METHOD = o -> Modifier.isProtected(o.getModifiers());
    public static final Predicate<Method> IS_GETTER = o -> o.getParameterCount() == 0 && o.getName().startsWith("get");
    public static final Predicate<Method> IS_SETTER = o -> o.getParameterCount() == 1 && o.getName().startsWith("set");

    private final Object parent;

    public MethodUtility(Method object, Object parent) {
        super(object);
        this.parent = parent;
    }

    /**
     * @see Method#toString()
     */
    @Override
    public String toString() {
        return map(Method::toString).orElse(null);
    }

    /**
     * @see Method#invoke(Object, Object...)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     * @throws InvocationTargetException This checked exception is thrown by the {@link Rethrower}.
     */
    @SuppressWarnings({ "JavaDoc", "unchecked" })
    public <T> T invoke(Object... arguments) {
        return wrap(o -> (T) o.invoke(parent, arguments));
    }
    
    private <T> T wrap(CheckedFunction<Method, T> function) {
        return map(o -> Rethrower.rethrow(function, o)).orElse(null);
    }

}
