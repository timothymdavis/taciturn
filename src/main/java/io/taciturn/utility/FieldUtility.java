package io.taciturn.utility;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;

import io.taciturn.function.CheckedConsumer;
import io.taciturn.function.CheckedFunction;
import io.taciturn.function.Rethrower;

import static io.taciturn.Utility.$;

public class FieldUtility extends ObjectUtility<Field> {

    public static final Predicate<Field> IS_PUBLIC_FIELD = o -> Modifier.isPublic(o.getModifiers());
    public static final Predicate<Field> IS_PRIVATE_FIELD = o -> Modifier.isPrivate(o.getModifiers());
    public static final Predicate<Field> IS_PROTECTED_FIELD = o -> Modifier.isProtected(o.getModifiers());

    private final Object parent;

    public FieldUtility(Field object, Object parent) {
        super(object);
        this.parent = parent;
    }

    /**
     * @see Field#toString()
     */
    @Override
    public String toString() {
        return map(Field::toString).orElse(null);
    }

    /**
     * @see Field#getBoolean(Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public boolean getBoolean() {
        return wrap(o -> o.getBoolean(parent));
    }

    /**
     * @see Field#getByte(Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public byte getByte() {
        return wrap(o -> o.getByte(parent));
    }

    /**
     * @see Field#getChar(Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public char getChar() {
        return wrap(o -> o.getChar(parent));
    }

    /**
     * @see Field#getDouble(Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public double getDouble() {
        return wrap(o -> o.getDouble(parent));
    }

    /**
     * @see Field#getFloat(Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public float getFloat() {
        return wrap(o -> o.getFloat(parent));
    }

    /**
     * @see Field#getInt(Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public int getInt() {
        return wrap(o -> o.getInt(parent));
    }

    /**
     * @see Field#getLong(Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public long getLong() {
        return wrap(o -> o.getLong(parent));
    }

    /**
     * @see Field#get(Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings({ "JavaDoc", "unchecked" })
    public <T> T getObject() {
        return wrap(o -> (T) o.get(parent));
    }

    /**
     * @see Field#getShort(Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public short getShort() {
        return wrap(o -> o.getShort(parent));
    }

    /**
     * @see Field#setBoolean(Object, boolean)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public void setBoolean(boolean primitive) {
        set(o -> o.setBoolean(parent, primitive));
    }

    /**
     * @see Field#setByte(Object, byte)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public void setByte(byte primitive) {
        set(o -> o.setByte(parent, primitive));
    }

    /**
     * @see Field#setChar(Object, char)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public void setChar(char primitive) {
        set(o -> o.setChar(parent, primitive));
    }

    /**
     * @see Field#setDouble(Object, double)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public void setDouble(double primitive) {
        set(o -> o.setDouble(parent, primitive));
    }

    /**
     * @see Field#setFloat(Object, float)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public void setFloat(float primitive) {
        set(o -> o.setFloat(parent, primitive));
    }

    /**
     * @see Field#setInt(Object, int)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public void setInt(int primitive) {
        set(o -> o.setInt(parent, primitive));
    }

    /**
     * @see Field#setLong(Object, long)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public void setLong(long primitive) {
        set(o -> o.setLong(parent, primitive));
    }

    /**
     * @see Field#setShort(Object, short)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public void setShort(short primitive) {
        set(o -> o.setShort(parent, primitive));
    }

    /**
     * @see Field#set(Object, Object)
     * @throws IllegalAccessException This checked exception is thrown by the {@link Rethrower}.
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("JavaDoc")
    public <T> void setObject(T object) {
        set(o -> o.set(parent, object));
    }

    private void set(CheckedConsumer<Field> consumer) {
        wrap(o -> {
            consumer.accept(o);
            return null;
        });
    }
    
    public void makeAccessible() {
        ifPresent(field -> $(field).filter(f -> !Modifier.isPublic(f.getModifiers()) ||
                                                Modifier.isFinal(f.getModifiers()) ||
                                                !Modifier.isPublic(f.getDeclaringClass().getModifiers()))
                                   .filter(f -> !f.isAccessible())
                                   .ifPresent(f -> f.setAccessible(true)));
    }

    private <T> T wrap(CheckedFunction<Field, T> function) {
        makeAccessible();
        return map(o -> Rethrower.rethrow(function, o)).orElse(null);
    }

}
