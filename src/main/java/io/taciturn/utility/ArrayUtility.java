package io.taciturn.utility;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.taciturn.Utility.$;

public class ArrayUtility<Item> extends ObjectUtility<Item[]> {

    private final StreamUtility<Stream<Item>, Item> streamUtility;

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

    public StreamUtility<Stream<Item>, Item> toStream() {
        return streamUtility;
    }

    @SuppressWarnings("unchecked")
    @SafeVarargs
    private static <Item> Item[] toArray(Item first, Item... rest) {
        $(first).mustNotBeNull();
        $(rest).mustNotBeNull();
        $(first).mustBe(o -> $(rest).toList()
                                    .map(Collection::stream)
                                    .map(c -> c.allMatch(i -> i.getClass() == o.getClass()))
                                    .orElse(false),
                        "The type of the first item must match the rest.");
        CollectionUtility<ArrayList<Item>, Item> items = new NonIterableUtility<>(first).toArrayList();
        items.map(o -> o.addAll(Arrays.stream(rest).collect(Collectors.toList())));
        return $(items.orElse(null)).toArray((Class<? extends Item>) first.getClass()).orElse(null);
    }

}
