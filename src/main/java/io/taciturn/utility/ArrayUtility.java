package io.taciturn.utility;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static io.taciturn.Utility.$;

public class ArrayUtility<Item> extends AbstractUtility<Item[]> {

    private final StreamUtility<Item> streamUtility;

    public ArrayUtility(Item[] o) {
        super(o);
        streamUtility = new StreamUtility<>(map(Arrays::stream).orElse(null));
    }

    @SafeVarargs
    public ArrayUtility(Item first, Item... rest) {
        this(toArray(first, rest));
    }
    
    public CollectionUtility<? extends Set<Item>, Item> toSet() {
        return streamUtility.toSet();
    }

    public CollectionUtility<HashSet<Item>, Item> toHashSet() {
        return streamUtility.toHashSet();
    }

    public CollectionUtility<ArrayList<Item>, Item> toArrayList() {
        return streamUtility.toArrayList();
    }

    public CollectionUtility<LinkedList<Item>, Item> toLinkedList() {
        return streamUtility.toLinkedList();
    }

    public CollectionUtility<? extends List<Item>, Item> toList() {
        return streamUtility.toList();
    }

    public CollectionUtility<PriorityQueue<Item>, Item> toPriorityQueue() {
        return streamUtility.toPriorityQueue();
    }

    public CollectionUtility<Vector<Item>, Item> toVector() {
        return streamUtility.toVector();
    }

    public ArrayUtility<Item> toArray(Class<? extends Item> itemType) {
        return streamUtility.toArray(itemType);
    }

    public CollectionUtility<ArrayDeque<Item>, Item> toArrayDeque() {
        return streamUtility.toArrayDeque();
    }

    public StreamUtility<Item> toStream() {
        return streamUtility;
    }

    @SuppressWarnings("unchecked")
    @SafeVarargs
    private static <Item> Item[] toArray(Item first, Item... rest) {
        $(first).mustNotBeNull();
        $(rest).mustNotBeNull();
        $(first).mustBe(o -> $(rest).toList()
                                    .map(Collection::stream)
                                    .map(c -> c.allMatch(i -> i != null && i.getClass() == o.getClass()))
                                    .orElse(false),
                        "The type of the first item must match the rest.");
        CollectionUtility<ArrayList<Item>, Item> items = new ObjectUtility<>(first).toArrayList();
        items.map(o -> o.addAll(Arrays.stream(rest).collect(Collectors.toList())));
        return $(items.orElse(null)).toArray((Class<? extends Item>) first.getClass()).orElse(null);
    }

    public boolean allMatch(Predicate<? super Item> predicate) {
        return streamUtility.allMatch(predicate);
    }

    public AbstractUtility<Item> min(Comparator<? super Item> comparator) {
        return streamUtility.min(comparator);
    }

    public <R, A> AbstractUtility<R> collect(Collector<? super Item, A, R> collector) {
        return streamUtility.collect(collector);
    }

    public long count() {
        return streamUtility.count();
    }

    public boolean noneMatch(Predicate<? super Item> predicate) {
        return streamUtility.noneMatch(predicate);
    }

    public boolean anyMatch(Predicate<? super Item> predicate) {
        return streamUtility.anyMatch(predicate);
    }

    public AbstractUtility<Item> findAny() {
        return streamUtility.findAny();
    }

    public <R> StreamUtility<R> mapEach(Function<? super Item, ? extends R> mapper) {
        return streamUtility.mapEach(mapper);
    }

    public void forEach(Consumer<? super Item> action) {
        streamUtility.forEach(action);
    }

    public StreamUtility<Item> sequential() {
        return streamUtility.sequential();
    }

    public <U> AbstractUtility<U> reduce(U identity,
                                         BiFunction<U, ? super Item, U> accumulator,
                                         BinaryOperator<U> combiner) {
        return streamUtility.reduce(identity, accumulator, combiner);
    }

    public AbstractUtility<Item> reduce(Item identity, BinaryOperator<Item> accumulator) {
        return streamUtility.reduce(identity, accumulator);
    }

    public StreamUtility<Item> filterEach(Predicate<? super Item> predicate) {
        return streamUtility.filterEach(predicate);
    }

    public AbstractUtility<DoubleStream> mapToDouble(ToDoubleFunction<? super Item> mapper) {
        return streamUtility.mapToDouble(mapper);
    }

    public AbstractUtility<IntStream> mapToInt(ToIntFunction<? super Item> mapper) {
        return streamUtility.mapToInt(mapper);
    }

    public AbstractUtility<Spliterator<Item>> spliterator() {
        return streamUtility.spliterator();
    }

    public StreamUtility<Item> distinct() {
        return streamUtility.distinct();
    }

    public AbstractUtility<LongStream> mapToLong(ToLongFunction<? super Item> mapper) {
        return streamUtility.mapToLong(mapper);
    }

    public <R> AbstractUtility<R> collect(Supplier<R> supplier,
                                          BiConsumer<R, ? super Item> accumulator,
                                          BiConsumer<R, R> combiner) {
        return streamUtility.collect(supplier, accumulator, combiner);
    }

    public StreamUtility<Item> sorted(Comparator<? super Item> comparator) {
        return streamUtility.sorted(comparator);
    }

    public StreamUtility<Item> onClose(Runnable closeHandler) {
        return streamUtility.onClose(closeHandler);
    }

    public StreamUtility<Item> skip(long n) {
        return streamUtility.skip(n);
    }

    public StreamUtility<Item> limit(long maxSize) {
        return streamUtility.limit(maxSize);
    }

    public void close() {
        streamUtility.close();
    }

    public AbstractUtility<LongStream> flatMapToLong(Function<? super Item, ? extends LongStream> mapper) {
        return streamUtility.flatMapToLong(mapper);
    }

    public AbstractUtility<Item> max(Comparator<? super Item> comparator) {
        return streamUtility.max(comparator);
    }

    public AbstractUtility<Item> reduce(BinaryOperator<Item> accumulator) {
        return streamUtility.reduce(accumulator);
    }

    public StreamUtility<Item> parallel() {
        return streamUtility.parallel();
    }

    public <CollectionType extends Collection<Item>> CollectionUtility<CollectionType, Item> to(CollectionType collection) {
        return streamUtility.to(collection);
    }

    public <R> StreamUtility<R> flatMapItems(Function<? super Item, ? extends Stream<? extends R>> mapper) {
        return streamUtility.flatMapItems(mapper);
    }

    public void forEachOrdered(Consumer<? super Item> action) {
        streamUtility.forEachOrdered(action);
    }

    public AbstractUtility<Iterator<Item>> iterator() {
        return streamUtility.iterator();
    }

    public StreamUtility<Item> sorted() {
        return streamUtility.sorted();
    }

    public AbstractUtility<IntStream> flatMapToInt(Function<? super Item, ? extends IntStream> mapper) {
        return streamUtility.flatMapToInt(mapper);
    }

    public AbstractUtility<DoubleStream> flatMapToDouble(Function<? super Item, ? extends DoubleStream> mapper) {
        return streamUtility.flatMapToDouble(mapper);
    }

    public AbstractUtility<Item> findFirst() {
        return streamUtility.findFirst();
    }

    public StreamUtility<Item> peek(Consumer<? super Item> action) {
        return streamUtility.peek(action);
    }

    public boolean isParallel() {
        return streamUtility.isParallel();
    }

    public StreamUtility<Item> unordered() {
        return streamUtility.unordered();
    }
}
