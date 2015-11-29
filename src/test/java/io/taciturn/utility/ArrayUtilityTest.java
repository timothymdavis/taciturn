package io.taciturn.utility;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Stream;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static io.taciturn.Utility.$;

public class ArrayUtilityTest {

    @Test
    public void testToSet() throws Exception {
        assertThat($((String) null).toSet().isPresent(), is(false));
        assertThat($("a").toSet().get(), instanceOf(Set.class));
        assertThat($("a").toSet().get().size(), is(1));
        assertThat($("a", "b").toSet().get().size(), is(2));
    }

    @Test
    public void testToHashSet() throws Exception {
        assertThat($((String) null).toHashSet().isPresent(), is(false));
        assertThat($("a").toHashSet().get(), instanceOf(HashSet.class));
        assertThat($("a").toHashSet().get().size(), is(1));
        assertThat($("a", "b").toHashSet().get().size(), is(2));
    }

    @Test
    public void testToArrayList() throws Exception {
        assertThat($((String) null).toArrayList().isPresent(), is(false));
        assertThat($("a").toArrayList().get(), instanceOf(ArrayList.class));
        assertThat($("a").toArrayList().get().size(), is(1));
        assertThat($("a", "b").toArrayList().get().size(), is(2));
    }

    @Test
    public void testToLinkedList() throws Exception {
        assertThat($((String) null).toLinkedList().isPresent(), is(false));
        assertThat($("a").toLinkedList().get(), instanceOf(LinkedList.class));
        assertThat($("a").toLinkedList().get().size(), is(1));
        assertThat($("a", "b").toLinkedList().get().size(), is(2));
    }

    @Test
    public void testToList() throws Exception {
        assertThat($((String) null).toList().isPresent(), is(false));
        assertThat($("a").toList().get(), instanceOf(List.class));
        assertThat($("a").toList().get().size(), is(1));
        assertThat($("a", "b").toList().get().size(), is(2));
    }

    @Test
    public void testToPriorityQueue() throws Exception {
        assertThat($((String) null).toPriorityQueue().isPresent(), is(false));
        assertThat($("a").toPriorityQueue().get(), instanceOf(PriorityQueue.class));
        assertThat($("a").toPriorityQueue().get().size(), is(1));
        assertThat($("a", "b").toPriorityQueue().get().size(), is(2));
    }

    @Test
    public void testToVector() throws Exception {
        assertThat($((String) null).toVector().isPresent(), is(false));
        assertThat($("a").toVector().get(), instanceOf(Vector.class));
        assertThat($("a").toVector().get().size(), is(1));
        assertThat($("a", "b").toVector().get().size(), is(2));
    }

    @Test
    public void testToArray() throws Exception {
        assertThat($((String) null).toArray().isPresent(), is(false));
        assertThat($("a").toArray().get(), instanceOf(String[].class));
        assertThat($("a").toArray().get().length, is(1));
        assertThat($("a", "b").toArray(String.class).get().length, is(2));
    }

    @Test
    public void testToArrayDeque() throws Exception {
        assertThat($((String) null).toArray().isPresent(), is(false));
        assertThat($("a").toArrayDeque().get(), instanceOf(ArrayDeque.class));
        assertThat($("a").toArrayDeque().get().size(), is(1));
        assertThat($("a", "b").toArrayDeque().get().size(), is(2));
    }

    @Test
    public void testToStream() throws Exception {
        assertThat($((String) null).toArray().isPresent(), is(false));
        assertThat($("a").toStream().get(), instanceOf(Stream.class));
        assertThat($("a").toStream().get().count(), is(1L));
        assertThat($("a", "b").toStream().get().count(), is(2L));
    }
}
