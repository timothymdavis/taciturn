package io.taciturn.utility;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
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
    
    @SuppressWarnings("unchecked")
    public <I> Optional<Iterable<I>> asIterable(Class<I> itemType) {
        return map(o -> (Iterable<I>) o);
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

}
