package io.taciturn.utility;

import java.lang.reflect.Array;
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

import static io.taciturn.Utility.$;

public class NonIterableUtility<Item> extends ObjectUtility<Item> {

    public NonIterableUtility(Item object) {
        super(object);
    }

    @SuppressWarnings({ "unchecked", "ConstantConditions" })
    public Optional<Item[]> toArray() {
        Item[] array = isPresent() ? (Item[]) Array.newInstance(mustNotBeNull().getClass(), 1) : null;
        object.map(o -> array[0] = o);
        return Optional.ofNullable(array);
    }
    
    public Optional<ArrayDeque<Item>> toArrayDeque() {
        return to(new ArrayDeque<>());
    }

    public Optional<? extends Set<Item>> toSet() {
        return toHashSet();
    }

    public Optional<HashSet<Item>> toHashSet() {
        return to(new HashSet<>());
    }

    public Optional<LinkedList<Item>> toLinkedList() {
        return to(new LinkedList<>());
    }

    public Optional<? extends List<Item>> toList() {
        return toArrayList();
    }

    public Optional<ArrayList<Item>> toArrayList() {
        return to(new ArrayList<>());
    }

    public <Container extends Collection<Item>> Optional<Container> to(Container collection) {
        object.map($(collection).mustNotBeNull()::add);
        return Optional.ofNullable(!collection.isEmpty() ? collection : null);
    }

    public Optional<PriorityQueue<Item>> toPriorityQueue() {
        return to(new PriorityQueue<>());
    }

    public Optional<Vector<Item>> toVector() {
        return to(new Vector<>());
    }
    
}
