package io.taciturn.utility;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static io.taciturn.Utility.$;

public class StringUtilityTest {

    @Test
    public void thisStringIsEmpty() {
        assertThat($("").isEmpty(), is(true));
    }

    @Test
    public void thisStringIsNotEmpty() {
        assertThat($(" ").isNotEmpty(), is(true));
    }

    @Test
    public void thisStringIsBlank() {
        assertThat($(" ").isBlank(), is(true));
    }

    @Test
    public void thisStringIsNotBlank() {
        assertThat($(" a ").isNotBlank(), is(true));
    }

    @Test
    public void thisStringToArrayList() {
        assertThat($(" a ").toArrayList().get(), instanceOf(ArrayList.class));
    }

}
