package io.taciturn.utility;

import org.junit.Assert;
import org.junit.Test;

import static io.taciturn.Utility.$;
import static org.hamcrest.core.Is.is;

public class CharacterUtilityTest {

    @Test
    public void testToString() throws Exception {
        Assert.assertThat($('a').toString(), is("a"));
        Assert.assertThat($((Character) null).toString(), is((String) null));
    }

    @Test
    public void testConvertToString() throws Exception {
        Assert.assertThat($('a').convertToString().orElse(null), is("a"));
        Assert.assertThat($((Character) null).convertToString().orElse(null), is((String) null));
    }

    @Test
    public void testAsPrimitive() throws Exception {
        Assert.assertThat($('a').asPrimitive(), is('a'));
        Assert.assertThat($((Character) null).asPrimitive(), is('\u0000'));
    }

    @Test
    public void testAsPrimitive1() throws Exception {
        Assert.assertThat($('a').asPrimitive('z'), is('a'));
        Assert.assertThat($((Character) null).asPrimitive('z'), is('z'));
    }
}