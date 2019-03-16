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
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static io.taciturn.Utility.$;

public class ArrayUtilityTest {

    @Test
    public void testToSet() throws Exception {
        assertThat($((String) null).toSet(), equalTo(new HashSet<>()));
        assertThat($("a").toSet(), instanceOf(Set.class));
        assertThat($("a").toSet().size(), is(1));
        assertThat($("a", "b").toSet().size(), is(2));
    }

    @Test
    public void testToSetUtility() throws Exception {
        assertThat($((String) null).mapToSet().isPresent(), is(false));
        assertThat($("a").mapToSet().get(), instanceOf(Set.class));
        assertThat($("a").mapToSet().get().size(), is(1));
        assertThat($("a", "b").mapToSet().get().size(), is(2));
    }

    @Test
    public void testToHashSetUtility() throws Exception {
        assertThat($((String) null).mapToHashSet().isPresent(), is(false));
        assertThat($("a").mapToHashSet().get(), instanceOf(HashSet.class));
        assertThat($("a").mapToHashSet().get().size(), is(1));
        assertThat($("a", "b").mapToHashSet().get().size(), is(2));
    }

    @Test
    public void testToArrayListUtility() throws Exception {
        assertThat($((String) null).mapToArrayList().isPresent(), is(false));
        assertThat($("a").mapToArrayList().get(), instanceOf(ArrayList.class));
        assertThat($("a").mapToArrayList().get().size(), is(1));
        assertThat($("a", "b").mapToArrayList().get().size(), is(2));
    }

    @Test
    public void testToLinkedListUtility() throws Exception {
        assertThat($((String) null).mapToLinkedList().isPresent(), is(false));
        assertThat($("a").mapToLinkedList().get(), instanceOf(LinkedList.class));
        assertThat($("a").mapToLinkedList().get().size(), is(1));
        assertThat($("a", "b").mapToLinkedList().get().size(), is(2));
    }

    @Test
    public void testToListUtility() throws Exception {
        assertThat($((String) null).mapToList().isPresent(), is(false));
        assertThat($("a").mapToList().get(), instanceOf(List.class));
        assertThat($("a").mapToList().get().size(), is(1));
        assertThat($("a", "b").mapToList().get().size(), is(2));
    }

    @Test
    public void testToPriorityQueueUtility() throws Exception {
        assertThat($((String) null).mapToPriorityQueue().isPresent(), is(false));
        assertThat($("a").mapToPriorityQueue().get(), instanceOf(PriorityQueue.class));
        assertThat($("a").mapToPriorityQueue().get().size(), is(1));
        assertThat($("a", "b").mapToPriorityQueue().get().size(), is(2));
    }

    @Test
    public void testToVectorUtility() throws Exception {
        assertThat($((String) null).mapToVector().isPresent(), is(false));
        assertThat($("a").mapToVector().get(), instanceOf(Vector.class));
        assertThat($("a").mapToVector().get().size(), is(1));
        assertThat($("a", "b").mapToVector().get().size(), is(2));
    }

    @Test
    public void testToArrayUtility() throws Exception {
        assertThat($((String) null).mapToArray().isPresent(), is(false));
        assertThat($("a").mapToArray().get(), instanceOf(String[].class));
        assertThat($("a").mapToArray().get().length, is(1));
        assertThat($("a", "b").mapToArray(String.class).get().length, is(2));
    }

    @Test
    public void testToArrayDequeUtility() throws Exception {
        assertThat($((String) null).mapToArray().isPresent(), is(false));
        assertThat($("a").mapToArrayDeque().get(), instanceOf(ArrayDeque.class));
        assertThat($("a").mapToArrayDeque().get().size(), is(1));
        assertThat($("a", "b").mapToArrayDeque().get().size(), is(2));
    }

    @Test
    public void testToStreamUtility() throws Exception {
        assertThat($((String) null).mapToArray().isPresent(), is(false));
        assertThat($("a").mapToStream().get(), instanceOf(Stream.class));
        assertThat($("a").mapToStream().get().count(), is(1L));
        assertThat($("a", "b").toStream().get().count(), is(2L));
    }
}
