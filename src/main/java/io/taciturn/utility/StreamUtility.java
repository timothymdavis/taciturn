package io.taciturn.utility;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Spliterator;
import java.util.Vector;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static io.taciturn.Utility.$;

@SuppressWarnings("WeakerAccess")
public class StreamUtility<Item> extends AbstractUtility<Stream<Item>> {

    public StreamUtility(Stream<Item> object) {
        super(object);
    }

    public boolean allMatch(Predicate<? super Item> predicate) {
        return map(s -> s.allMatch(predicate)).orElse(BooleanUtility.DEFAULT_VALUE);
    }

    public boolean anyMatch(Predicate<? super Item> predicate) {
        return map(s -> s.anyMatch(predicate)).orElse(BooleanUtility.DEFAULT_VALUE);
    }

    public void close() {
        ifPresent(BaseStream::close);
    }

    public <R, A> AbstractUtility<R> collect(Collector<? super Item, A, R> collector) {
        return map(s -> s.collect(collector));
    }

    public <R> AbstractUtility<R> collect(Supplier<R> supplier,
                                          BiConsumer<R, ? super Item> accumulator,
                                          BiConsumer<R, R> combiner) {
        return map(s -> s.collect(supplier, accumulator, combiner));
    }

    public long count() {
        return map(Stream::count).orElse(LongUtility.DEFAULT_VALUE);
    }

    public StreamUtility<Item> distinct() {
        return $(map(Stream::distinct).orElse(null));
    }

    public StreamUtility<Item> filterEach(Predicate<? super Item> predicate) {
        return $(map(s -> s.filter(predicate)).orElse(null));
    }

    public AbstractUtility<Item> findAny() {
        return flatMap(Stream::findAny);
    }

    public AbstractUtility<Item> findFirst() {
        return flatMap(Stream::findFirst);
    }

    public <R> StreamUtility<R> flatMapEach(Function<? super Item, ? extends Stream<? extends R>> mapper) {
        return $(map(s -> s.<R>flatMap(mapper)).orElse(null));
    }

    /* This should return a DoubleStreamUtility at some point. */
    public AbstractUtility<DoubleStream> flatMapEachToDouble(Function<? super Item, ? extends DoubleStream> mapper) {
        return map(s -> s.flatMapToDouble(mapper));
    }

    /* This should return a IntStreamUtility at some point. */
    public AbstractUtility<IntStream> flatMapEachToInt(Function<? super Item, ? extends IntStream> mapper) {
        return map(s -> s.flatMapToInt(mapper));
    }

    /* This should return a LongStreamUtility at some point. */
    public AbstractUtility<LongStream> flatMapEachToLong(Function<? super Item, ? extends LongStream> mapper) {
        return map(s -> s.flatMapToLong(mapper));
    }

    public void forEach(Consumer<? super Item> action) {
        ifPresent(s -> s.forEach(action));
    }

    public void forEachOrdered(Consumer<? super Item> action) {
        ifPresent(s -> s.forEachOrdered(action));
    }

    public boolean isParallel() {
        return map(BaseStream::isParallel).orElse(BooleanUtility.DEFAULT_VALUE);
    }

    public AbstractUtility<Iterator<Item>> iterator() {
        return map(Stream::iterator);
    }

    public StreamUtility<Item> limit(long maxSize) {
        return $(map(s -> s.limit(maxSize)).orElse(null));
    }

    public <R> StreamUtility<R> mapEach(Function<? super Item, ? extends R> mapper) {
        return $(map(s -> s.<R>map(mapper)).orElse(null));
    }

    /* This should return a DoubleStreamUtility at some point. */
    public AbstractUtility<DoubleStream> mapToDouble(ToDoubleFunction<? super Item> mapper) {
        return map(s -> s.mapToDouble(mapper));
    }

    /* This should return a IntStreamUtility at some point. */
    public AbstractUtility<IntStream> mapToInt(ToIntFunction<? super Item> mapper) {
        return map(s -> s.mapToInt(mapper));
    }

    /* This should return a LongStreamUtility at some point. */
    public AbstractUtility<LongStream> mapToLong(ToLongFunction<? super Item> mapper) {
        return map(s -> s.mapToLong(mapper));
    }

    public AbstractUtility<Item> max(Comparator<? super Item> comparator) {
        return flatMap(s -> s.max(comparator));
    }

    public AbstractUtility<Item> min(Comparator<? super Item> comparator) {
        return flatMap(s -> s.min(comparator));
    }

    public boolean noneMatch(Predicate<? super Item> predicate) {
        return map(s -> s.noneMatch(predicate)).orElse(BooleanUtility.DEFAULT_VALUE);
    }

    public StreamUtility<Item> onClose(Runnable closeHandler) {
        return $(map(s -> s.onClose(closeHandler)).orElse(null));
    }

    public StreamUtility<Item> parallel() {
        return $(map(BaseStream::parallel).orElse(null));
    }

    public StreamUtility<Item> peek(Consumer<? super Item> action) {
        return $(map(s -> s.peek(action)).orElse(null));
    }

    public AbstractUtility<Item> reduce(BinaryOperator<Item> accumulator) {
        return flatMap(s -> s.reduce(accumulator));
    }

    public AbstractUtility<Item> reduce(Item identity, BinaryOperator<Item> accumulator) {
        return map(s -> s.reduce(identity, accumulator));
    }

    public <U> AbstractUtility<U> reduce(U identity,
                                         BiFunction<U, ? super Item, U> accumulator,
                                         BinaryOperator<U> combiner) {
        return map(s -> s.reduce(identity, accumulator, combiner));
    }

    public StreamUtility<Item> sequential() {
        return $(map(BaseStream::sequential).orElse(null));
    }

    public StreamUtility<Item> skip(long n) {
        return $(map(s -> s.skip(n)).orElse(null));
    }

    public StreamUtility<Item> sorted() {
        return $(map(Stream::sorted).orElse(null));
    }

    public StreamUtility<Item> sorted(Comparator<? super Item> comparator) {
        return $(map(s -> s.sorted(comparator)).orElse(null));
    }

    public AbstractUtility<Spliterator<Item>> spliterator() {
        return map(Stream::spliterator);
    }

    public Item[] toArray(Class<? extends Item> itemType) {
        return mapToArray(itemType).orElse($(itemType).newArray());
    }

    @SuppressWarnings({ "unchecked", "ConstantConditions" })
    public ArrayUtility<Item> mapToArray(Class<? extends Item> itemType) {
        $(itemType).mustNotBeNull("Cannot create an array without class.");
        return $(map(o -> o.toArray(i -> (Item[]) Array.newInstance(itemType, i))).orElse(null));
    }

    public ArrayDeque<Item> toArrayDeque() {
        return mapToArrayDeque().orElse(new ArrayDeque<>());
    }

    public CollectionUtility<ArrayDeque<Item>, Item> mapToArrayDeque() {
        return to(new ArrayDeque<>());
    }

    public LinkedList<Item> toLinkedList() {
        return mapToLinkedList().orElse(new LinkedList<>());
    }

    public CollectionUtility<LinkedList<Item>, Item> mapToLinkedList() {
        return to(new LinkedList<>());
    }

    public List<Item> toList() {
        return toArrayList();
    }

    public CollectionUtility<? extends List<Item>, Item> mapToList() {
        return mapToArrayList();
    }

    public ArrayList<Item> toArrayList() {
        return mapToArrayList().orElse(new ArrayList<>());
    }

    public CollectionUtility<ArrayList<Item>, Item> mapToArrayList() {
        return to(new ArrayList<>());
    }

    public PriorityQueue<Item> toPriorityQueue() {
        return mapToPriorityQueue().orElse(new PriorityQueue<>());
    }

    public CollectionUtility<PriorityQueue<Item>, Item> mapToPriorityQueue() {
        return to(new PriorityQueue<>());
    }

    public Set<Item> toSet() {
        return toHashSet();
    }

    public CollectionUtility<? extends Set<Item>, Item> mapToSet() {
        return mapToHashSet();
    }

    public HashSet<Item> toHashSet() {
        return mapToHashSet().orElse(new HashSet<>());
    }

    public CollectionUtility<HashSet<Item>, Item> mapToHashSet() {
        return to(new HashSet<>());
    }

    public Vector<Item> toVector() {
        return mapToVector().orElse(new Vector<>());
    }

    public CollectionUtility<Vector<Item>, Item> mapToVector() {
        return to(new Vector<>());
    }

    public <CollectionType extends Collection<Item>> CollectionUtility<CollectionType, Item> to(CollectionType collection) {
        ifPresent(o -> o.forEach(collection::add));
        return (CollectionUtility<CollectionType, Item>) $(collection).filter(o -> !o.isEmpty());
    }

    public StreamUtility<Item> unordered() {
        return $(map(BaseStream::unordered).orElse(null));
    }
}
