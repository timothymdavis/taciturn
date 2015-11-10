package io.taciturn.utility;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.taciturn.Utility;

public class ArrayUtility<Item> extends ObjectUtility<Item[]> {

    private final StreamUtility<Stream<Item>, Item> streamUtility;

    public ArrayUtility(Item[] o) {
        super(o);
        streamUtility = new StreamUtility<>(object.map(Arrays::stream).orElse(null));
    }

    @SafeVarargs
    public ArrayUtility(Item first, Item... rest) {
        this(toArray(first, rest));
    }
    
    public Optional<? extends Set<Item>> toSet() {
        return streamUtility.toSet();
    }

    public Optional<HashSet<Item>> toHashSet() {
        return streamUtility.toHashSet();
    }

    public Optional<ArrayList<Item>> toArrayList() {
        return streamUtility.toArrayList();
    }

    public Optional<LinkedList<Item>> toLinkedList() {
        return streamUtility.toLinkedList();
    }

    public Optional<? extends List<Item>> toList() {
        return streamUtility.toList();
    }

    public Optional<PriorityQueue<Item>> toPriorityQueue() {
        return streamUtility.toPriorityQueue();
    }

    public Optional<Vector<Item>> toVector() {
        return streamUtility.toVector();
    }

    public Optional<Item[]> toArray(Class<? extends Item> itemType) {
        return streamUtility.toArray(itemType);
    }

    public Optional<ArrayDeque<Item>> toArrayDeque() {
        return streamUtility.toArrayDeque();
    }

    @SuppressWarnings("unchecked")
    @SafeVarargs
    private static <Item> Item[] toArray(Item first, Item... rest) {
        Optional<ArrayList<Item>> items = new NonIterableUtility<>(first).toArrayList();
        items.map(o -> o.addAll(Arrays.stream(new ArrayUtility<>(rest).mustNotBeNull()).collect(Collectors.toList())));
        return Utility.$(items.orElse(null)).toArray((Class<? extends Item>) first.getClass()).orElse(null);
    }

}
