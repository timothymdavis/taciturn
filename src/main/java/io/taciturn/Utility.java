package io.taciturn;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import io.taciturn.utility.*;

/**
 * This library is targeted to Java 8 users who want to add some extra functionality to their favorite objects. You
 * will likely notice some similarities to notable Javascript libraries jQuery and Underscore. The goal of Taciturn is
 * to add what is missing, and make common, tedious operations more convenient.
 * <p/>
 * It should be noted that Taciturn is very immature at this time. Keep in mind that the method signatures may change
 * over the coming months. Hopefully it will settle into a grove in the near future. Once we hit the 1.0.0 version, I
 * will be sure to deprecate anything that will disappear in an upcoming release. Until then, I hope that you will be
 * willing to put up with a small amount of chaos.
 */
public class Utility {

    /**
     * Example code:
     * <p/>
     * <code>
     *     $('a').toSet();
     * </code>
     * <p/>
     * @param object Object to augment.
     * @param <Item> The type of object to augment.
     * @return the utility that wraps the object to augment.
     */
    public static <Item> ObjectUtility<Item> $(Item object) {
        return new ObjectUtility<>(object);
    }

    /**
     * Example code:
     * <p/>
     * <code>
     *     $("a", "3", "2").reduce((a, b) -> a + b).ifPresent(System.out::println);
     * </code>
     * <p/>
     * @param object Object to augment.
     * @param <Item> The type of object to augment.
     * @return the utility that wraps the object to augment.
     */
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
