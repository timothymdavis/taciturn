package io.taciturn.utility;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static io.taciturn.Utility.$;
import static org.junit.Assert.fail;

public class AbstractUtilityTest {
    
    @Test
    public void testIsPresent() throws Exception {
        assertThat($(new Object()).isPresent(), is(true));
        assertThat($((Object) null).isPresent(), is(false));
    }

    @Test
    public void testIfPresent() throws Exception {
        List<Object> list = new ArrayList<>();
        assertThat(list.size(), is(0));
        $(new Object()).ifPresent(list::add);
        assertThat(list.size(), is(1));
        $((Object) null).ifPresent(list::add);
        assertThat(list.size(), is(1));
    }

    @Test
    public void testFilter() throws Exception {
        assertThat($("").filter(String::isEmpty).orElse(null), is(""));
        assertThat($("").filter(s -> !s.isEmpty()).orElse(null), nullValue());
    }

    @Test
    public void testMap() throws Exception {
        assertThat($(new Object()).map(Object::getClass).orElse(null), is(Object.class));
        assertThat($((Object) null).map(Object::getClass).orElse(null), nullValue());
    }

    @Test
    public void testFlatMap() throws Exception {
        assertThat($(new Object()).flatMap(o -> Optional.of(o.getClass())).orElse(null), is(Object.class));
        assertThat($((Object) null).flatMap(o -> Optional.of(o.getClass())).orElse(null), nullValue());
    }

    @Test
    public void testGet() throws Exception {
        assertThat($("Value").get(), is("Value"));
        assertThat($("Value").get(), not("Other"));
    }

    @Test
    public void testOrElse() throws Exception {
        assertThat($((Object) null).orElse(0), is(0));
    }

    @Test
    public void testOrElseGet() throws Exception {
        assertThat($((Object) null).orElseGet(() -> 0), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void testOrElseThrow() throws Exception {
        $((Object) null).orElseThrow(NullPointerException::new);
    }

    @Test
    public void testMustBe() throws Exception {
        $((Object) null).mustBe(o -> o == null);
        try {
            $((Object) null).mustBe(o -> o != null);
            fail("An exception should have been thrown.");
        } catch (InvalidContractException ignored) {
        }
    }

    @Test(expected = InvalidContractException.class)
    public void testMustBeWithMessage() throws Exception {
        $((Object) null).mustBe(o -> o != null, "This value should not be null!");
    }

    @Test
    public void testMustNotBe() throws Exception {
        $((Object) null).mustNotBe(o -> o != null);
        try {
            $((Object) null).mustNotBe(o -> o == null);
            fail("An exception should have been thrown.");
        } catch (InvalidContractException ignored) {
        }
    }

    @Test(expected = InvalidContractException.class)
    public void testMustNotBeWithMessage() throws Exception {
        $((Object) null).mustNotBe(o -> o == null, "This value should not be null!");
    }

    @Test
    public void testMustNotBeNull() throws Exception {
        Object object = new Object();
        $(object).mustNotBeNull();
    }

    @Test(expected = NullPointerException.class)
    public void testMustNotBeNullButIs() {
        $((String) null).mustNotBeNull();
    }

    @Test
    public void testOptional() throws Exception {
        assertThat($(new Object()).optional(), not(Optional.empty()));
        assertThat($((Object) null).optional(), is(Optional.empty()));
    }

}
