package io.taciturn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import static io.taciturn.Utility.$;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.nullValue;

public class UtilityTest {

    @Test
    public void test$ClassUtility() throws Exception {
        Assert.assertThat($(String.class).get(), instanceOf(Class.class));
        Assert.assertThat($(String.class).newArray(5).length, equalTo(5));
    }

    @Test
    public void test$NonIterableUtility() throws Exception {
        Assert.assertThat($(new Object()).get(), instanceOf(Object.class));
        Assert.assertThat($((Object) null).orElse(null), nullValue());
    }

    @Test
    public void test$ArrayUtility() throws Exception {
        Assert.assertThat($(new Object[0]).get(), instanceOf(Object[].class));
        Assert.assertThat($((Object[]) null).orElse(null), nullValue());
    }

    @Test
    public void test$Collection() throws Exception {
        Assert.assertThat($(new ArrayList<>()).get(), instanceOf(Collection.class));
        Assert.assertThat($((Collection<Object>) null).orElse(null), nullValue());
    }

    @Test
    public void test$BooleanUtility() throws Exception {
        Assert.assertThat($(true).get(), instanceOf(Boolean.class));
        Assert.assertThat($((Boolean) null).orElse(null), nullValue());
    }

    @Test
    public void test$CharacterUtility() throws Exception {
        Assert.assertThat($('a').get(), instanceOf(Character.class));
        Assert.assertThat($((Character) null).orElse(null), nullValue());
    }

    @Test
    public void test$ByteUtility() throws Exception {
        Assert.assertThat($((byte) 1).get(), instanceOf(Byte.class));
        Assert.assertThat($((Byte) null).orElse(null), nullValue());
    }

    @Test
    public void test$DoubleUtility() throws Exception {
        Assert.assertThat($(1D).get(), instanceOf(Double.class));
        Assert.assertThat($((Double) null).orElse(null), nullValue());
    }

    @Test
    public void test$FloatUtility() throws Exception {
        Assert.assertThat($(1F).get(), instanceOf(Float.class));
        Assert.assertThat($((Float) null).orElse(null), nullValue());
    }

    @Test
    public void test$IntegerUtility() throws Exception {
        Assert.assertThat($(1).get(), instanceOf(Integer.class));
        Assert.assertThat($((Integer) null).orElse(null), nullValue());
    }

    @Test
    public void test$LongUtility() throws Exception {
        Assert.assertThat($(1L).get(), instanceOf(Long.class));
        Assert.assertThat($((Long) null).orElse(null), nullValue());
    }

    @Test
    public void test$ShortUtility() throws Exception {
        Assert.assertThat($((short) 1).get(), instanceOf(Short.class));
        Assert.assertThat($((Short) null).orElse(null), nullValue());
    }

    @Test
    public void test$StreamUtility() throws Exception {
        Assert.assertThat($(new ArrayList<>().stream()).get(), instanceOf(Stream.class));
        Assert.assertThat($((Stream<Object>) null).orElse(null), nullValue());
    }

    @Test
    public void test$StringUtility() throws Exception {
        Assert.assertThat($("a").get(), instanceOf(String.class));
        Assert.assertThat($((String) null).orElse(null), nullValue());
    }

    @Test
    public void test$ArrayUtilityInline() throws Exception {
        Assert.assertThat($(new Object(), new Object()).get(), instanceOf(Object[].class));
    }

    @Test
    public void test$Optional() throws Exception {
        Assert.assertThat($(Optional.of(new Object())).get(), instanceOf(Optional.class));
        Assert.assertThat($((Optional<Object>) null).orElse(null), nullValue());
    }

}