package io.taciturn.utility;

import org.junit.Assert;
import org.junit.Test;

import static io.taciturn.Utility.$;
import static org.hamcrest.core.Is.is;

public class ByteUtilityTest {

    @Test
    public void testToString() throws Exception {
        Assert.assertThat($((byte) 1).toString(), is("1"));
        Assert.assertThat($((Byte) null).toString(), is((String) null));
    }

    @Test
    public void testConvertToString() throws Exception {
        Assert.assertThat($((byte) 1).convertToString().orElse(null), is("1"));
        Assert.assertThat($((Byte) null).convertToString().orElse(null), is((String) null));
    }

    @Test
    public void testAsPrimitive() throws Exception {
        Assert.assertThat($((byte) 1).asPrimitive(), is((byte) 1));
        Assert.assertThat($((Byte) null).asPrimitive(), is((byte) 0));
    }

    @Test
    public void testAsPrimitive1() throws Exception {
        Assert.assertThat($((byte) 1).asPrimitive((byte) -1), is((byte) 1));
        Assert.assertThat($((Byte) null).asPrimitive((byte) -1), is((byte) -1));
    }
}