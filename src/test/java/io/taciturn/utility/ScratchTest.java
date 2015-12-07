package io.taciturn.utility;

import org.junit.Test;

import static io.taciturn.Utility.$;

public class ScratchTest {

    @Test
    public void scratch() throws Exception {
        $("a", "3", "2")
                .mapItems(i -> $(i).convertToInteger(16).orElse(null))
                .filterItems(o -> o != null)
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);

        $("a", "3", "2")
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);
    }

}
