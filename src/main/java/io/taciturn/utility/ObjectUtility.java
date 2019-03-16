package io.taciturn.utility;

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
import java.util.stream.Stream;

import static io.taciturn.Utility.$;

/**
 * Utility functions that apply to all objects.
 *
 * @param <Item> The type of object to augment.
 */
public class ObjectUtility<Item> extends AbstractUtility<Item> {

    /**
     * Constructor for the utility object.
     *
     * @param object The object to augment.
     */
    public ObjectUtility(Item object) {
        super(object);
    }

    /**
     * Retrieves the fields for a particular object, limited by the predicate provided.
     * @param filter The {@link Predicate} that limits what fields to retrieve.
     * @return the utility that wraps the collection of {@link FieldUtility} objects.
     */
    public StreamUtility<FieldUtility> getFields(Predicate<Field> filter) {
        return map(Object::getClass)
                .map(Class::getDeclaredFields)
                .map(o -> $(o)
                        .filterEach(filter)
                        .mapEach(f -> new FieldUtility(f, orElse(null))))
                .orElse(null);
    }

    /**
     * Retrieves all of the fields for a particular object.
     * @return the utility that wraps the collection of {@link FieldUtility} objects.
     */
    public StreamUtility<FieldUtility> getAllFields() {
        return getFields(o -> true);
    }

    /**
     * Retrieves all public fields for a particular object.
     * @return the utility that wraps the collection of {@link FieldUtility} objects.
     */
    public StreamUtility<FieldUtility> getPublicFields() {
        return getFields(FieldUtility.IS_PUBLIC_FIELD);
    }

    /**
     * Retrieves all private fields for a particular object.
     * @return the utility that wraps the collection of {@link FieldUtility} objects.
     */
    public StreamUtility<FieldUtility> getPrivateFields() {
        return getFields(FieldUtility.IS_PRIVATE_FIELD);
    }

    /**
     * Retrieves all protected fields for a particular object.
     * @return the utility that wraps the collection of {@link FieldUtility} objects.
     */
    public StreamUtility<FieldUtility> getProtectedFields() {
        return getFields(FieldUtility.IS_PROTECTED_FIELD);
    }

    /**
     * Retrieves the methods for a particular object, limited by the predicate provided.
     * @param filter The {@link Predicate} that limits what methods to retrieve.
     * @return the utility that wraps the collection of {@link MethodUtility} objects.
     */
    public StreamUtility<MethodUtility> getMethods(Predicate<Method> filter) {
        return map(Object::getClass)
                .map(Class::getDeclaredMethods)
                .map(o -> $(o)
                        .filterEach(filter)
                        .mapEach(f -> new MethodUtility(f, orElse(null))))
                .orElse(null);
    }

    /**
     * Retrieves all of the getter methods for a particular object.
     * @return the utility that wraps the collection of {@link MethodUtility} objects.
     */
    public StreamUtility<MethodUtility> getAllGetterMethods() {
        return getMethods(MethodUtility.IS_GETTER);
    }

    /**
     * Retrieves the public getter methods for a particular object.
     * @return the utility that wraps the collection of {@link MethodUtility} objects.
     */
    public StreamUtility<MethodUtility> getPublicGetterMethods() {
        return getMethods(MethodUtility.IS_PUBLIC_METHOD.and(MethodUtility.IS_GETTER));
    }

    /**
     * Retrieves the private getter methods for a particular object.
     * @return the utility that wraps the collection of {@link MethodUtility} objects.
     */
    public StreamUtility<MethodUtility> getPrivateGetterMethods() {
        return getMethods(MethodUtility.IS_PRIVATE_METHOD.and(MethodUtility.IS_GETTER));
    }

    /**
     * Retrieves the protected getter methods for a particular object.
     * @return the utility that wraps the collection of {@link MethodUtility} objects.
     */
    public StreamUtility<MethodUtility> getProtectedGetterMethods() {
        return getMethods(MethodUtility.IS_PROTECTED_METHOD.and(MethodUtility.IS_GETTER));
    }

    /**
     * Retrieves all of the setter methods for a particular object.
     * @return the utility that wraps the collection of {@link MethodUtility} objects.
     */
    public StreamUtility<MethodUtility> getAllSetterMethods() {
        return getMethods(MethodUtility.IS_SETTER);
    }

    /**
     * Retrieves the public setter methods for a particular object.
     * @return the utility that wraps the collection of {@link MethodUtility} objects.
     */
    public StreamUtility<MethodUtility> getPublicSetterMethods() {
        return getMethods(MethodUtility.IS_PUBLIC_METHOD.and(MethodUtility.IS_SETTER));
    }

    /**
     * Retrieves the private setter methods for a particular object.
     * @return the utility that wraps the collection of {@link MethodUtility} objects.
     */
    public StreamUtility<MethodUtility> getPrivateSetterMethods() {
        return getMethods(MethodUtility.IS_PRIVATE_METHOD.and(MethodUtility.IS_SETTER));
    }

    /**
     * Retrieves the protected setter methods for a particular object.
     * @return the utility that wraps the collection of {@link MethodUtility} objects.
     */
    public StreamUtility<MethodUtility> getProtectedSetterMethods() {
        return getMethods(MethodUtility.IS_PROTECTED_METHOD.and(MethodUtility.IS_SETTER));
    }

    /**
     * Converts an object to a typed array of length one.
     * <p/>
     * Due to the nature of Arrays in Java, an object's type can't be inferred from a null. This is why the type is a
     * required parameter.
     * <dl>
     *     <dt><b>Example:</b></dt>
     *     <dd><pre>Integer[] integers = $(1).toArray();</pre></dd>
     * </dl>
     * @param type The type of array to create.
     * @return the single entry array of the desired type
     */
    @SuppressWarnings("unchecked")
    public Item[] toArray(Class<Item> type) {
        Item[] array = $(type).newArray(isPresent() ? 1 :0);
        ifPresent(o -> array[0] = o);
        return array;
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     ArrayUtility< Item > arrayUtility = $(1).mapToArray();
     * </pre>
     * @return the single entry {@link ArrayUtility} of the desired type.
     */
    @SuppressWarnings({ "unchecked", "ConstantConditions" })
    public ArrayUtility<Item> mapToArray() {
        Item[] array = map(o -> (Item[]) $(o.getClass()).newArray(1)).orElse(null);
        ifPresent(o -> array[0] = o);
        return $(array);
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     ArrayDeque< String > arrayDeque = $("b").mapToArrayDeque();
     * </pre>
     * @return the single entry {@link ArrayDeque} of the desired generic type, or an empty {@link ArrayDeque} if the
     * provided object was null.
     */
    public ArrayDeque<Item> toArrayDeque() {
        return mapToArrayDeque().orElse(new ArrayDeque<>());
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     CollectionUtility< ArrayDeque< Item > > arrayUtility = $(1).mapToArrayDeque();
     * </pre>
     * @return the single entry {@link CollectionUtility} of the desired type.
     */
    public CollectionUtility<ArrayDeque<Item>, Item> mapToArrayDeque() {
        return to(new ArrayDeque<>());
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     ArrayList< Character > integers = $('b').mapToArrayList();
     * </pre>
     * @return the single entry {@link ArrayList} of the desired generic type.
     */
    public ArrayList<Item> toArrayList() {
        return mapToArrayList().orElse(new ArrayList<>());
    }

    public CollectionUtility<ArrayList<Item>, Item> mapToArrayList() {
        return to(new ArrayList<>());
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     HashSet< Long > longs = $(2L).mapToHashSet();
     * </pre>
     * @return the single entry {@link HashSet} of the desired generic type.
     */
    public HashSet<Item> toHashSet() {
        return mapToHashSet().orElse(new HashSet<>());
    }

    public CollectionUtility<HashSet<Item>, Item> mapToHashSet() {
        return to(new HashSet<>());
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     LinkedList< Double > doubles = $(5.2D).mapToLinkedList();
     * </pre>
     * @return the single entry {@link LinkedList} of the desired generic type.
     */
    public LinkedList<Item> toLinkedList() {
        return mapToLinkedList().orElse(new LinkedList<>());
    }

    public CollectionUtility<LinkedList<Item>, Item> mapToLinkedList() {
        return to(new LinkedList<>());
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     List< Float > floats = $(2.5F).mapToList();
     * </pre>
     * @return the single entry {@link List} of the desired generic type.
     */
    public List<Item> toList() {
        return mapToArrayList().orElse(new ArrayList<>());
    }

    public CollectionUtility<? extends List<Item>, Item> mapToList() {
        return mapToArrayList();
    }

    public PriorityQueue<Item> toPriorityQueue() {
        return mapToPriorityQueue().orElse(new PriorityQueue<>());
    }

    public CollectionUtility<PriorityQueue<Item>, Item> mapToPriorityQueue() {
        return to(new PriorityQueue<>());
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     Set< Byte > bytes = $((byte) 0).mapToSet();
     * </pre>
     * @return the single entry {@link Set} of the desired generic type.
     */
    public Set<Item> toSet() {
        return mapToHashSet().orElse(new HashSet<>());
    }

    public CollectionUtility<? extends Set<Item>, Item> mapToSet() {
        return mapToHashSet();
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     Stream< Long > longs = $(2L).mapToStream();
     * </pre>
     * @return the single entry {@link HashSet} of the desired generic type.
     */
    public Stream<Item> toStream() {
        return mapToStream().orElse(Stream.empty());
    }

    public StreamUtility<Item> mapToStream() {
        return new StreamUtility<>(mapToArrayList().map(ArrayList::stream).orElse(null));
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     Vector< Byte > bytes = $((byte) 0).mapToVector();
     * </pre>
     * @return the single entry {@link Set} of the desired generic type.
     */
    public Vector<Item> toVector() {
        return mapToVector().orElse(null);
    }

    public CollectionUtility<Vector<Item>, Item> mapToVector() {
        return to(new Vector<>());
    }

    @SuppressWarnings("unchecked")
    public <Container extends Collection<Item>> CollectionUtility<Container, Item> to(Container collection) {
        $(collection).mustNotBeNull();
        map(collection::add);
        return (CollectionUtility<Container, Item>) $(collection).filter(o -> !o.isEmpty());
    }

}
