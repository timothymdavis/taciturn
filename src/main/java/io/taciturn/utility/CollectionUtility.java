package io.taciturn.utility;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Stream;

public class CollectionUtility<Container extends Collection<Item>, Item> extends ObjectUtility<Container> {
    
    private final StreamUtility<Stream<Item>, Item> streamUtility;

    public CollectionUtility(Container o) {
        super(o);
        streamUtility = new StreamUtility<>(map(Collection::stream).orElse(null));
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
    public CollectionUtility<Collection<Item>, Item> asCollection() {
        return (CollectionUtility<Collection<Item>, Item>) this;
    }

}
