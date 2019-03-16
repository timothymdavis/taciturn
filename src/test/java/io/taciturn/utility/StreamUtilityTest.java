package io.taciturn.utility;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Vector;

import org.junit.Test;

import static io.taciturn.Utility.$;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class StreamUtilityTest {

    @Test
    public void testTo() throws Exception {
        assertThat($((Object) null).mapToStream().to(new ArrayList<>()).orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().to(new ArrayList<>()).orElse(null), instanceOf(ArrayList.class));
    }

    @Test
    public void testToArrayUtility() throws Exception {
        assertThat($((Object) null).mapToStream().mapToArray(Object.class).orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().mapToArray(Object.class).orElse(null), instanceOf(Object[].class));
    }

    @Test
    public void testToArrayDequeUtility() throws Exception {
        assertThat($((Object) null).mapToStream().mapToArrayDeque().orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().mapToArrayDeque().orElse(null), instanceOf(ArrayDeque.class));
    }

    @Test
    public void testToSetUtility() throws Exception {
        assertThat($((Object) null).mapToStream().mapToSet().orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().mapToSet().orElse(null), instanceOf(Set.class));
    }

    @Test
    public void testToHashSetUtility() throws Exception {
        assertThat($((Object) null).mapToStream().mapToHashSet().orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().mapToHashSet().orElse(null), instanceOf(HashSet.class));
    }

    @Test
    public void testToLinkedListUtility() throws Exception {
        assertThat($((Object) null).mapToStream().mapToLinkedList().orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().mapToLinkedList().orElse(null), instanceOf(LinkedList.class));
    }

    @Test
    public void testToListUtility() throws Exception {
        assertThat($((Object) null).mapToStream().mapToList().orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().mapToList().orElse(null), instanceOf(List.class));
    }

    @Test
    public void testToArrayListUtility() throws Exception {
        assertThat($((Object) null).mapToStream().mapToArrayList().orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().mapToArrayList().orElse(null), instanceOf(ArrayList.class));
    }

    @Test
    public void testToPriorityQueueUtility() throws Exception {
        assertThat($((Object) null).mapToStream().mapToPriorityQueue().orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().mapToPriorityQueue().orElse(null), instanceOf(PriorityQueue.class));
    }

    @Test
    public void testToVectorUtility() throws Exception {
        assertThat($((Object) null).mapToStream().mapToVector().orElse(null), nullValue());
        assertThat($(new Object()).mapToStream().mapToVector().orElse(null), instanceOf(Vector.class));
    }

}