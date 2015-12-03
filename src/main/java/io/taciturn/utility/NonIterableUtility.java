package io.taciturn.utility;

import java.lang.reflect.Array;
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

import static io.taciturn.Utility.$;

public class NonIterableUtility<Item> extends ObjectUtility<Item> {

    public NonIterableUtility(Item object) {
        super(object);
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
