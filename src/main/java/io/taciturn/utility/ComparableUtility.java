package io.taciturn.utility;

import java.util.Optional;
import java.util.function.Predicate;

import io.taciturn.Utility;

import static io.taciturn.Utility.$;

public class ComparableUtility<Item extends Comparable<Item>>
        extends NonIterableUtility<Item> {

    public ComparableUtility(Item object) {
        super(object);
    }
    
    public Optional<Boolean> isBetween(Item lower, Item upper) {
        return Optional.of(object.filter(isBetweenPredicate(lower, upper)).isPresent());
    }

    public Optional<Boolean> isGreaterThan(Item lower) {
        return Optional.of(object.filter(isGreaterThanPredicate(lower)).isPresent());
    }

    public Optional<Boolean> isGreaterThanOrEqual(Item lower) {
        return Optional.of(object.filter(isGreaterThanOrEqualPredicate(lower)).isPresent());
    }

    public Optional<Boolean> isLessThan(Item upper) {
        return Optional.of(object.filter(isLessThanPredicate(upper)).isPresent());
    }

    public Optional<Boolean> isLessThanOrEqual(Item upper) {
        return Optional.of(object.filter(isLessThanOrEqualPredicate(upper)).isPresent());
    }

    public Item mustBeBetween(Item lower, Item upper) {
        return mustBe(isBetweenPredicate(lower, upper), createBetweenExpectedMessage(lower, upper));
    }

    public Item mustBeGreaterThan(Item lower) {
        return mustBe(isGreaterThanPredicate(lower), createGreaterThanExpectedMessage(lower));
    }

    public Item mustBeGreaterThanOrEqual(Item lower) {
        return mustBe(isGreaterThanOrEqualPredicate(lower), createGreaterThanOrEqualExpectedMessage(lower));
    }

    public Item mustBeLessThan(Item upper) {
        return mustBe(isLessThanPredicate(upper), createLessThanExpectedMessage(upper));
    }

    public Item mustBeLessThanOrEqual(Item upper) {
        return mustBe(isLessThanOrEqualPredicate(upper), createLessThanOrEqualExpectedMessage(upper));
    }

    public static <T extends Comparable<T>> Predicate<T> isBetweenPredicate(T lower, T upper) {
        return o -> Utility.$(lower).mustNotBeNull().compareTo(o) <= 0 && Utility.$(upper).mustNotBeNull().compareTo(o) >= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isGreaterThanPredicate(T lower) {
        return o -> Utility.$(lower).mustNotBeNull().compareTo(o) < 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isGreaterThanOrEqualPredicate(T lower) {
        return o -> Utility.$(lower).mustNotBeNull().compareTo(o) <= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isLessThanPredicate(T upper) {
        return o -> Utility.$(upper).mustNotBeNull().compareTo(o) > 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isLessThanOrEqualPredicate(T upper) {
        return o -> Utility.$(upper).mustNotBeNull().compareTo(o) >= 0;
    }

    private String createBetweenExpectedMessage(Item lower, Item upper) {
        return String.format("Expected: value between %s and %s\n     got: %s\n", lower, upper, object);
    }

    private String createGreaterThanExpectedMessage(Item lower) {
        return String.format("Expected: value greater than %s\n     got: %s\n", lower, object);
    }

    private String createGreaterThanOrEqualExpectedMessage(Item lower) {
        return String.format("Expected: value greater than or equal to %s\n     got: %s\n", lower, object);
    }

    private String createLessThanExpectedMessage(Item lower) {
        return String.format("Expected: value less than %s\n     got: %s\n", lower, object);
    }

    private String createLessThanOrEqualExpectedMessage(Item lower) {
        return String.format("Expected: value less than or equal to %s\n     got: %s\n", lower, object);
    }

}
