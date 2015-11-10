package spike;

import java.util.ArrayList;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static spike.Utility.$;

public class StringUtilityTest {

    @Test
    public void thisStringIsEmpty() {
        assertThat($("").isEmpty(), is(true));
    }

    @Test
    public void thisStringIsNotEmpty() {
        assertThat($(" ").isEmpty(), is(false));
    }

    @Test
    public void thisStringIsBlank() {
        assertThat($(" ").isBlank(), is(true));
    }

    @Test
    public void thisStringIsNotBlank() {
        assertThat($(" a ").isBlank(), is(false));
    }

    @Test
    public void thisStringToArrayList() {
        assertThat($(" a ").toArrayList().get(), instanceOf(ArrayList.class));
    }

}
