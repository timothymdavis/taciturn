package io.taciturn;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import io.taciturn.utility.ArrayUtility;
import io.taciturn.utility.BooleanUtility;
import io.taciturn.utility.ByteUtility;
import io.taciturn.utility.CharacterUtility;
import io.taciturn.utility.CollectionUtility;
import io.taciturn.utility.DoubleUtility;
import io.taciturn.utility.FloatUtility;
import io.taciturn.utility.IntegerUtility;
import io.taciturn.utility.LongUtility;
import io.taciturn.utility.NonIterableUtility;
import io.taciturn.utility.ObjectUtility;
import io.taciturn.utility.ShortUtility;
import io.taciturn.utility.StreamUtility;
import io.taciturn.utility.StringUtility;

public class Utility {

    public static <Item> Function<Item, ? extends ObjectUtility<Item>> $() {
        return Utility::$;
    }

    public static <Item> NonIterableUtility<Item> $(Item object) {
        return new NonIterableUtility<>(object);
    }

    public static <Item> ArrayUtility<Item> $(Item[] object) {
        return new ArrayUtility<>(object);
    }

    public static <Item> CollectionUtility<Collection<Item>, Item> $(Collection<Item> object) {
        return new CollectionUtility<>(object);
    }

    public static BooleanUtility $(Boolean object) {
        return new BooleanUtility(object);
    }

    public static CharacterUtility $(Character object) {
        return new CharacterUtility(object);
    }

    public static ByteUtility $(Byte object) {
        return new ByteUtility(object);
    }

    public static DoubleUtility $(Double object) {
        return new DoubleUtility(object);
    }

    public static FloatUtility $(Float object) {
        return new FloatUtility(object);
    }

    public static IntegerUtility $(Integer object) {
        return new IntegerUtility(object);
    }

    public static LongUtility $(Long object) {
        return new LongUtility(object);
    }

    public static ShortUtility $(Short object) {
        return new ShortUtility(object);
    }

    public static <Item> StreamUtility<Item> $(Stream<Item> object) {
        return new StreamUtility<>(object);
    }

    public static StringUtility $(String object) {
        return new StringUtility(object);
    }

    @SafeVarargs
    public static <Item> ArrayUtility<Item> $(Item first, Item... rest) {
        return new ArrayUtility<>(first, rest);
    }

    public <Item> ObjectUtility<Item> $(Optional<Item> object) {
        return $(object.orElse(null));
    }

}
