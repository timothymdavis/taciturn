package io.taciturn.utility;

import org.junit.Assert;
import org.junit.Test;

import static io.taciturn.Utility.$;
import static org.hamcrest.core.Is.is;

public class BooleanUtilityTest {

    @Test
    public void testToString() throws Exception {
        Assert.assertThat($(true).toString(), is("true"));
        Assert.assertThat($(true).toString(), is(Boolean.TRUE.toString()));
        Assert.assertThat($(false).toString(), is("false"));
        Assert.assertThat($(false).toString(), is(Boolean.FALSE.toString()));
        Assert.assertThat($((Boolean) null).toString(), is((String) null));
    }

    @Test
    public void testConvertToString() throws Exception {
        Assert.assertThat($(true).convertToString().orElse(null), is("true"));
        Assert.assertThat($(true).convertToString().orElse(null), is(Boolean.TRUE.toString()));
        Assert.assertThat($(false).convertToString().orElse(null), is("false"));
        Assert.assertThat($(false).convertToString().orElse(null), is(Boolean.FALSE.toString()));
        Assert.assertThat($((Boolean) null).convertToString().orElse(null), is((String) null));
    }

    @Test
    public void testAsPrimitive() throws Exception {
        Assert.assertThat($(true).asPrimitive(), is(true));
        Assert.assertThat($(false).asPrimitive(), is(false));
        Assert.assertThat($((Boolean) null).asPrimitive(), is(false));
    }

    @Test
    public void testAsPrimitive1() throws Exception {
        Assert.assertThat($(true).asPrimitive(true), is(true));
        Assert.assertThat($(false).asPrimitive(true), is(false));
        Assert.assertThat($((Boolean) null).asPrimitive(true), is(true));
    }
}