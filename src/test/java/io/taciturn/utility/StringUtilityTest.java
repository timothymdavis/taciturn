package io.taciturn.utility;

import java.util.ArrayList;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static io.taciturn.Utility.$;

public class StringUtilityTest {

    @Test
    public void thisStringIsEmpty() {
        assertThat($("").isEmpty().get(), is(true));
    }

    @Test
    public void thisStringIsNotEmpty() {
        assertThat($(" ").isEmpty().get(), is(false));
    }

    @Test
    public void thisStringIsBlank() {
        assertThat($(" ").isBlank().get(), is(true));
    }

    @Test
    public void thisStringIsNotBlank() {
        assertThat($(" a ").isBlank().get(), is(false));
    }

    @Test
    public void thisStringToArrayList() {
        assertThat($(" a ").toArrayList().get(), instanceOf(ArrayList.class));
    }

}
