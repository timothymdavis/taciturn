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
import java.util.function.Consumer;
import java.util.stream.Stream;

import static io.taciturn.Utility.$;

public class StreamUtility<Container extends Stream<Item>, Item> extends ObjectUtility<Container> {

    public StreamUtility(Container object) {
        super(object);
    }

    public <CollectionType extends Collection<Item>> CollectionUtility<CollectionType, Item> to(CollectionType collection) {
        ifPresent(o -> o.forEach(collection::add));
        return (CollectionUtility<CollectionType, Item>) $(collection).filter(o -> !o.isEmpty());
    }

    @SuppressWarnings({ "unchecked", "ConstantConditions" })
    public ArrayUtility<Item> toArray(Class<? extends Item> itemType) {
        return $(map(o -> o.toArray(i -> (Item[]) Array.newInstance(itemType, i))).orElse(null));
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

    public CollectionUtility<PriorityQueue<Item>, Item> toPriorityQueue() {
        return to(new PriorityQueue<>());
    }

    public CollectionUtility<Vector<Item>, Item> toVector() {
        return to(new Vector<>());
    }

    public void forEach(Consumer<? super Item> action) {
        ifPresent(o -> o.forEach(action));
    }

}
