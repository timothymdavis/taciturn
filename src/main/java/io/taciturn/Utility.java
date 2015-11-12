package io.taciturn;

import java.util.Collection;

import io.taciturn.utility.ArrayUtility;
import io.taciturn.utility.CollectionUtility;
import io.taciturn.utility.ComparableUtility;
import io.taciturn.utility.NonIterableUtility;
import io.taciturn.utility.StringUtility;

public class Utility {

    public static <Item> NonIterableUtility<Item> $(Item object) {
        return new NonIterableUtility<>(object);
    }

    @SafeVarargs
    public static <Item> ArrayUtility<Item> $(Item first, Item... rest) {
        return new ArrayUtility<>(first, rest);
    }

    public static <Item> ArrayUtility<Item> $(Item[] object) {
        return new ArrayUtility<>(object);
    }

    public static <Item> CollectionUtility<Collection<Item>, Item> $(Collection<Item> object) {
        return new CollectionUtility<>(object);
    }

    public static ComparableUtility<Boolean> $(Boolean object) {
        return new ComparableUtility<>(object);
    }

    public static ComparableUtility<Character> $(Character object) {
        return new ComparableUtility<>(object);
    }

    public static ComparableUtility<Byte> $(Byte object) {
        return new ComparableUtility<>(object);
    }

    public static ComparableUtility<Double> $(Double object) {
        return new ComparableUtility<>(object);
    }

    public static ComparableUtility<Float> $(Float object) {
        return new ComparableUtility<>(object);
    }

    public static ComparableUtility<Integer> $(Integer object) {
        return new ComparableUtility<>(object);
    }

    public static ComparableUtility<Long> $(Long object) {
        return new ComparableUtility<>(object);
    }

    public static ComparableUtility<Short> $(Short object) {
        return new ComparableUtility<>(object);
    }

    public static StringUtility $(String object) {
        return new StringUtility(object);
    }

}
