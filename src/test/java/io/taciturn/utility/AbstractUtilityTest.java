package io.taciturn.utility;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static io.taciturn.Utility.$;

public class AbstractUtilityTest {
    
    @Test
    public void thisObjectGet() {
        assertThat($("Value").optional().get(), is("Value"));
        assertThat($("Value").optional().get(), not("Other"));
    }

    @Test
    public void thisObjectIsNull() {
        assertThat($((String) null).isPresent(), is(false));
    }

    @Test
    public void thisObjectIsNotNull() {
        assertThat($(new Object()).isPresent(), is(true));
    }

    @Test(expected = InvalidContractException.class)
    public void thisObjectMustNotBeNullButIs() {
        $((String) null).mustNotBeNull();
    }

    @Test
    public void thisObjectMustNotBeNull() {
        Object object = new Object();
        $(object).mustNotBeNull();
    }

}
