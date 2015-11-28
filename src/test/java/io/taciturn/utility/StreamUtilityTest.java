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
        assertThat($((Object) null).toStream().to(new ArrayList<>()).orElse(null), nullValue());
        assertThat($(new Object()).toStream().to(new ArrayList<>()).orElse(null), instanceOf(ArrayList.class));
    }

    @Test
    public void testToArray() throws Exception {
        assertThat($((Object) null).toStream().toArray(Object.class).orElse(null), nullValue());
        assertThat($(new Object()).toStream().toArray(Object.class).orElse(null), instanceOf(Object[].class));
    }

    @Test
    public void testToArrayDeque() throws Exception {
        assertThat($((Object) null).toStream().toArrayDeque().orElse(null), nullValue());
        assertThat($(new Object()).toStream().toArrayDeque().orElse(null), instanceOf(ArrayDeque.class));
    }

    @Test
    public void testToSet() throws Exception {
        assertThat($((Object) null).toStream().toSet().orElse(null), nullValue());
        assertThat($(new Object()).toStream().toSet().orElse(null), instanceOf(Set.class));
    }

    @Test
    public void testToHashSet() throws Exception {
        assertThat($((Object) null).toStream().toHashSet().orElse(null), nullValue());
        assertThat($(new Object()).toStream().toHashSet().orElse(null), instanceOf(HashSet.class));
    }

    @Test
    public void testToLinkedList() throws Exception {
        assertThat($((Object) null).toStream().toLinkedList().orElse(null), nullValue());
        assertThat($(new Object()).toStream().toLinkedList().orElse(null), instanceOf(LinkedList.class));
    }

    @Test
    public void testToList() throws Exception {
        assertThat($((Object) null).toStream().toList().orElse(null), nullValue());
        assertThat($(new Object()).toStream().toList().orElse(null), instanceOf(List.class));
    }

    @Test
    public void testToArrayList() throws Exception {
        assertThat($((Object) null).toStream().toArrayList().orElse(null), nullValue());
        assertThat($(new Object()).toStream().toArrayList().orElse(null), instanceOf(ArrayList.class));
    }

    @Test
    public void testToPriorityQueue() throws Exception {
        assertThat($((Object) null).toStream().toPriorityQueue().orElse(null), nullValue());
        assertThat($(new Object()).toStream().toPriorityQueue().orElse(null), instanceOf(PriorityQueue.class));
    }

    @Test
    public void testToVector() throws Exception {
        assertThat($((Object) null).toStream().toVector().orElse(null), nullValue());
        assertThat($(new Object()).toStream().toVector().orElse(null), instanceOf(Vector.class));
    }

}