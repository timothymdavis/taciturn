package io.taciturn;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import io.taciturn.utility.AbstractUtility;
import io.taciturn.utility.ArrayUtility;
import io.taciturn.utility.BooleanUtility;
import io.taciturn.utility.ByteUtility;
import io.taciturn.utility.CharacterUtility;
import io.taciturn.utility.ClassUtility;
import io.taciturn.utility.CollectionUtility;
import io.taciturn.utility.DateUtility;
import io.taciturn.utility.DoubleUtility;
import io.taciturn.utility.FloatUtility;
import io.taciturn.utility.InstantUtility;
import io.taciturn.utility.IntegerUtility;
import io.taciturn.utility.LongUtility;
import io.taciturn.utility.ObjectUtility;
import io.taciturn.utility.ShortUtility;
import io.taciturn.utility.StreamUtility;
import io.taciturn.utility.StringUtility;

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

    public static <Item> ClassUtility<Item> $(Class<Item> object) {
        return new ClassUtility<>(object);
    }

    /**
     * Example code:
     * <p/>
     * <pre>
     *     boolean primitive = $(Boolean.TRUE).asPrimitive();
     *
     *     $(1).filter(i -> i < 5).ifPresent(System.out::println);
     *
     *     boolean between = $(5).isBetween(1, 10)
     *     boolean greaterThan = $(1).isGreaterThan(5);
     *
     *     $(1).lessThanOrEqualTo(5).ifPresent(System.out::println);
     *
     *     $("b").mustNotBeNull(); // Throws NullPointerException
     *
     *     $(1).toArray();
     *     $(4L).toArrayDeque()
     *     $("one").toArrayList();
     *     $('a').toSet();
     * </pre>
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
     *     $(new String[]{"a", "3", "2"}).reduce((a, b) -> a + b).ifPresent(System.out::println);
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

    /**
     * Example code:
     * <p/>
     * <pre>
     *     boolean asPrimitive = $(Boolean.TRUE).asPrimitive();
     * </pre>
     * @param object Object to augment.
     * @return the utility that wraps the object to augment.
     */
    public static BooleanUtility $(Boolean object) {
        return new BooleanUtility(object);
    }

    public static ByteUtility $(Byte object) {
        return new ByteUtility(object);
    }

    public static CharacterUtility $(Character object) {
        return new CharacterUtility(object);
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

    /**
     * Example code:
     * <p/>
     * <pre>
     *     int asPrimitive = $(Integer.valueOf(1)).asPrimitive();
     * </pre>
     * @param object Object to augment.
     * @return the utility that wraps the object to augment.
     */
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

    /**
     * Example code:
     * <p/>
     * <code>
     *     $("a", "3", "2").reduce((a, b) -> a + b).ifPresent(System.out::println);
     * </code>
     * <p/>
     * @param first The first object to add to the array.
     * @param rest The rest of the objects to add to the array.
     * @param <Item> The type of object to augment.
     * @return the utility that wraps the object to augment.
     */
    @SafeVarargs
    public static <Item> ArrayUtility<Item> $(Item first, Item... rest) {
        return new ArrayUtility<>(first, rest);
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    public <Item> AbstractUtility<Item> $(Optional<Item> object) {
        return $(object.orElse(null));
    }

}
