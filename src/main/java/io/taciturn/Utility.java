package io.taciturn;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import io.taciturn.utility.*;

public class Utility {

    public static <Item> ObjectUtility<Item> $(Item object) {
        return new ObjectUtility<>(object);
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

    public static DateUtility $(Date object) {
        return new DateUtility(object);
    }

    public static DoubleUtility $(Double object) {
        return new DoubleUtility(object);
    }

    public static FloatUtility $(Float object) {
        return new FloatUtility(object);
    }

    public static InstantUtility $(Instant object) {
        return new InstantUtility(object);
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

    public <Item> AbstractUtility<Item> $(Optional<Item> object) {
        return $(object.orElse(null));
    }

}
