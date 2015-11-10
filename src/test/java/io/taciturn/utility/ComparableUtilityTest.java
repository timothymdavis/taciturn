package io.taciturn.utility;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static io.taciturn.Utility.$;

public class ComparableUtilityTest {

    @Test
    public void thisIntegerIsNotBetween1And10() {
        assertThat($((Integer) null).isBetween(1, 10).orElse(false), is(false));
        assertThat($(0).isBetween(1, 10).orElse(false), is(false));
        assertThat($(11).isBetween(1, 10).orElse(false), is(false));
    }

    @Test
    public void thisIntegerIsBetween1And10() {
        assertThat($(1).isBetween(1, 10).orElse(false), is(true));
        assertThat($(10).isBetween(1, 10).orElse(false), is(true));
    }

    @Test
    public void thisDoubleIsBetween1Point5And10Point5() {
        assertThat($(1.50d).isBetween(1.5d, 10.5d).orElse(false), is(true));
        assertThat($(10.50d).isBetween(1.5d, 10.5d).orElse(false), is(true));
    }

    @Test
    public void thisDoubleIsNotBetween1Point5And10Point5() {
        assertThat($(1.49d).isBetween(1.5d, 10.5d).orElse(false), is(false));
        assertThat($(10.51d).isBetween(1.5d, 10.5d).orElse(false), is(false));
    }

    @Test
    public void thisFloatIsBetween1Point5And10Point5() {
        assertThat($(1.50f).isBetween(1.5f, 10.5f).orElse(false), is(true));
        assertThat($(10.50f).isBetween(1.5f, 10.5f).orElse(false), is(true));
    }

    @Test
    public void thisFloatIsNotBetween1Point5And10Point5() {
        assertThat($(1.49f).isBetween(1.5f, 10.5f).orElse(false), is(false));
        assertThat($(10.51f).isBetween(1.5f, 10.5f).orElse(false), is(false));
    }

    @Test
    public void thisStringIsNotBetweenAAndZ() {
        assertThat($("a").isBetween("A", "Z").orElse(false), is(false));
        assertThat($("z").isBetween("A", "Z").orElse(false), is(false));
    }

    @Test
    public void thisStringIsBetweenAAndZ() {
        assertThat($("A").isBetween("A", "Z").orElse(false), is(true));
        assertThat($("Z").isBetween("A", "Z").orElse(false), is(true));
        assertThat($("B").isBetween("A", "Z").orElse(false), is(true));
        assertThat($("Y").isBetween("A", "Z").orElse(false), is(true));
    }

    @Test
    public void thisStringIsNotBetweenInclusiveAAndZ() {
        assertThat($("a").isBetween("A", "Z").orElse(false), is(false));
        assertThat($("z").isBetween("A", "Z").orElse(false), is(false));
    }

    @Test
    public void thisStringIsBetweenInclusiveAAndZ() {
        assertThat($("A").isBetween("A", "Z").orElse(false), is(true));
        assertThat($("Z").isBetween("A", "Z").orElse(false), is(true));
        assertThat($("B").isBetween("A", "Z").orElse(false), is(true));
        assertThat($("Y").isBetween("A", "Z").orElse(false), is(true));
    }

}
