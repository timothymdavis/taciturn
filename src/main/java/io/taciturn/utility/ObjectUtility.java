package io.taciturn.utility;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;
import java.util.function.Predicate;

import static io.taciturn.Utility.$;

public class ObjectUtility<Item> extends AbstractUtility<Item> {

    public ObjectUtility(Item object) {
        super(object);
    }

    public StreamUtility<FieldUtility> getAllFields(Predicate<Field> filter) {
        return map(Object::getClass)
                .map(Class::getDeclaredFields)
                .map(o -> $(o)
                        .filterEach(filter)
                        .mapEach(f -> new FieldUtility(f, orElse(null))))
                .orElse(null);
    }

    public StreamUtility<FieldUtility> getAllFields() {
        return getAllFields(o -> true);
    }

    public StreamUtility<FieldUtility> getPublicFields() {
        return getAllFields(FieldUtility.IS_PUBLIC_FIELD);
    }

    public StreamUtility<FieldUtility> getPrivateFields() {
        return getAllFields(FieldUtility.IS_PRIVATE_FIELD);
    }

    public StreamUtility<FieldUtility> getProtectedFields() {
        return getAllFields(FieldUtility.IS_PROTECTED_FIELD);
    }

    public StreamUtility<MethodUtility> getMethods(Predicate<Method> filter) {
        return map(Object::getClass)
                .map(Class::getDeclaredMethods)
                .map(o -> $(o)
                        .filterEach(filter)
                        .mapEach(f -> new MethodUtility(f, orElse(null))))
                .orElse(null);
    }

    public StreamUtility<MethodUtility> getAllGetterMethods() {
        return getMethods(MethodUtility.IS_GETTER);
    }

    public StreamUtility<MethodUtility> getPublicGetterMethods() {
        return getMethods(MethodUtility.IS_PUBLIC_METHOD.and(MethodUtility.IS_GETTER));
    }

    public StreamUtility<MethodUtility> getPrivateGetterMethods() {
        return getMethods(MethodUtility.IS_PRIVATE_METHOD.and(MethodUtility.IS_GETTER));
    }

    public StreamUtility<MethodUtility> getProtectedGetterMethods() {
        return getMethods(MethodUtility.IS_PROTECTED_METHOD.and(MethodUtility.IS_GETTER));
    }

    public StreamUtility<MethodUtility> getAllSetterMethods() {
        return getMethods(MethodUtility.IS_SETTER);
    }

    public StreamUtility<MethodUtility> getPublicSetterMethods() {
        return getMethods(MethodUtility.IS_PUBLIC_METHOD.and(MethodUtility.IS_SETTER));
    }

    public StreamUtility<MethodUtility> getPrivateSetterMethods() {
        return getMethods(MethodUtility.IS_PRIVATE_METHOD.and(MethodUtility.IS_SETTER));
    }

    public StreamUtility<MethodUtility> getProtectedSetterMethods() {
        return getMethods(MethodUtility.IS_PROTECTED_METHOD.and(MethodUtility.IS_SETTER));
    }

    @SuppressWarnings({ "unchecked", "ConstantConditions" })
    public ArrayUtility<Item> toArray() {
        Item[] array = isPresent() ? (Item[]) Array.newInstance(get().getClass(), 1) : null;
        map(o -> array[0] = o);
        return $(array);
    }
    
    public CollectionUtility<ArrayDeque<Item>, Item> toArrayDeque() {
        return to(new ArrayDeque<>());
    }

    public CollectionUtility<? extends Set<Item>, Item> toSet() {
        return toHashSet();
    }

    public CollectionUtility<HashSet<Item>, Item> toHashSet() {
        return to(new HashSet<>());
    }

    public CollectionUtility<LinkedList<Item>, Item> toLinkedList() {
        return to(new LinkedList<>());
    }

    public CollectionUtility<? extends List<Item>, Item> toList() {
        return toArrayList();
    }

    public CollectionUtility<ArrayList<Item>, Item> toArrayList() {
        return to(new ArrayList<>());
    }

    @SuppressWarnings("unchecked")
    public <Container extends Collection<Item>> CollectionUtility<Container, Item> to(Container collection) {
        $(collection).mustNotBeNull();
        map(collection::add);
        return (CollectionUtility<Container, Item>) $(collection).filter(o -> !o.isEmpty());
    }

    public CollectionUtility<PriorityQueue<Item>, Item> toPriorityQueue() {
        return to(new PriorityQueue<>());
    }

    public CollectionUtility<Vector<Item>, Item> toVector() {
        return to(new Vector<>());
    }

    public StreamUtility<Item> toStream() {
        return new StreamUtility<>(toArrayList().map(ArrayList::stream).orElse(null));
    }
    
}
