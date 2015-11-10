package spike;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static spike.Utility.$;

public class ObjectUtilityTest {
    
    @Test
    public void thisObjectGet() {
        assertThat($((String) null).isNull(), is(false));
        assertThat($("Value").get(), is("Value"));
        assertThat($("Value").get(), not("Other"));
    }

    @Test
    public void thisObjectIsNull() {
        assertThat($((String) null).isNotPresent(), is(true));
    }

    @Test
    public void thisObjectIsNotNull() {
        assertThat($(new Object()).isNull(), is(true));
    }

    @Test(expected = InvalidContractException.class)
    public void thisObjectMustNotBeNullButIs() {
        $((String) null).mustNotBeNull();
    }

    @Test(expected = InvalidContractException.class)
    public void thisObjectMustBeNullButIsNot() {
        $(new Object()).mustBeNull();
    }

    @Test
    public void thisObjectMustBeNull() {
        Object object = new Object();
        assertThat($(object).mustNotBeNull(), is(object));
    }

}
