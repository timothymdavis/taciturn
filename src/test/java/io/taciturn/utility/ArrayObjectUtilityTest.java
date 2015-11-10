package io.taciturn.utility;

import java.util.HashSet;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static io.taciturn.Utility.$;

public class ArrayObjectUtilityTest {

    @Test
    public void thisObjectToArray() {
        assertThat($("Value").toArray().get().length, is(1));
        assertThat($((String) null).toArray().isPresent(), is(false));
    }

    @Test
    public void thisObjectToHashSet() {
        assertThat($((String[]) null).toHashSet().isPresent(), is(false));
        assertThat($(new String[] { "Value" }).toHashSet().get(), IsInstanceOf.instanceOf(HashSet.class));
        assertThat($(new String[] { "Value" }).toHashSet().map(HashSet::size).get(), is(1));
    }

}
