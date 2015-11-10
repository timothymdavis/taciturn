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
import java.util.stream.Stream;

public class StreamUtility<Container extends Stream<Item>, Item> extends ObjectUtility<Container> {

    public StreamUtility(Container object) {
        super(object);
    }

    public <CollectionType extends Collection<Item>> Optional<CollectionType> to(CollectionType collection) {
        object.ifPresent(o -> o.forEach(collection::add));
        return Optional.ofNullable(collection).filter(o -> !o.isEmpty());
    }

    @SuppressWarnings({ "unchecked", "ConstantConditions" })
    public Optional<Item[]> toArray(Class<? extends Item> itemType) {
        return object.map(o -> o.toArray(i -> (Item[]) Array.newInstance(itemType, i)));
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

    public Optional<PriorityQueue<Item>> toPriorityQueue() {
        return to(new PriorityQueue<>());
    }

    public Optional<Vector<Item>> toVector() {
        return to(new Vector<>());
    }

}
