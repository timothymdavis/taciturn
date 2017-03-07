package io.taciturn.utility;

import java.util.function.Predicate;

import static io.taciturn.Utility.$;

@SuppressWarnings("WeakerAccess")
public class ComparableUtility<Item extends Comparable<Item>>
        extends ObjectUtility<Item> {

    public ComparableUtility(Item object) {
        super(object);
    }
    
    public boolean isBetween(Item lower, Item upper) {
        return between(lower, upper).isPresent();
    }

    public boolean isGreaterThan(Item lower) {
        return greaterThan(lower).isPresent();
    }

    public boolean isGreaterThanOrEqualTo(Item lower) {
        return greaterThanOrEqualTo(lower).isPresent();
    }

    public boolean isLessThan(Item upper) {
        return lessThan(upper).isPresent();
    }

    public boolean isLessThanOrEqualTo(Item upper) {
        return lessThanOrEqualTo(upper).isPresent();
    }

    public boolean isEqualTo(Item item) {
        return equalTo(item).isPresent();
    }

    public ComparableUtility<Item> between(Item lower, Item upper) {
        return filter(isBetweenPredicate(lower, upper));
    }

    public ComparableUtility<Item> greaterThan(Item lower) {
        return filter(isGreaterThanPredicate(lower));
    }

    public ComparableUtility<Item> greaterThanOrEqualTo(Item lower) {
        return filter(isGreaterThanOrEqualToPredicate(lower));
    }

    public ComparableUtility<Item> lessThan(Item upper) {
        return filter(isLessThanPredicate(upper));
    }

    public ComparableUtility<Item> lessThanOrEqualTo(Item upper) {
        return filter(isLessThanOrEqualToPredicate(upper));
    }

    public ComparableUtility<Item> equalTo(Item item) {
        return filter(isEqualToPredicate(item));
    }

    public ComparableUtility<Item> mustBeBetween(Item lower, Item upper) {
        return mustBe(isBetweenPredicate(lower, upper), createBetweenExpectedMessage(lower, upper));
    }

    public ComparableUtility<Item> mustBeBetween(ComparableUtility<Item> lower, ComparableUtility<Item> upper) {
        return mustBe(isBetweenPredicate(lower, upper), createBetweenExpectedMessage(lower, upper));
    }

    public ComparableUtility<Item> mustBeGreaterThan(Item lower) {
        return mustBe(isGreaterThanPredicate(lower), createGreaterThanExpectedMessage(lower));
    }

    public ComparableUtility<Item> mustBeGreaterThanOrEqualTo(Item lower) {
        return mustBe(isGreaterThanOrEqualToPredicate(lower), createGreaterThanOrEqualToExpectedMessage(lower));
    }

    public ComparableUtility<Item> mustBeLessThan(Item upper) {
        return mustBe(isLessThanPredicate(upper), createLessThanExpectedMessage(upper));
    }

    public ComparableUtility<Item> mustBeLessThanOrEqualTo(Item upper) {
        return mustBe(isLessThanOrEqualToPredicate(upper), createLessThanOrEqualToExpectedMessage(upper));
    }

    public ComparableUtility<Item> mustBeEqualTo(Item upper) {
        return mustBe(isEqualToPredicate(upper), createEqualToExpectedMessage(upper));
    }

    public static <T extends Comparable<T>> Predicate<T> isBetweenPredicate(T lower, T upper) {
        $(lower).mustNotBeNull();
        $(upper).mustNotBeNull();
        return o -> lower.compareTo(o) <= 0 && upper.compareTo(o) >= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isBetweenPredicate(ComparableUtility<T> lower, ComparableUtility<T> upper) {
        return isBetweenPredicate(lower.orElse(null), upper.orElse(null));
    }

    public static <T extends Comparable<T>> Predicate<T> isGreaterThanPredicate(T lower) {
        $(lower).mustNotBeNull();
        return o -> lower.compareTo(o) < 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isGreaterThanOrEqualToPredicate(T lower) {
        $(lower).mustNotBeNull();
        return o -> lower.compareTo(o) <= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isLessThanPredicate(T upper) {
        $(upper).mustNotBeNull();
        return o -> upper.compareTo(o) > 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isLessThanOrEqualToPredicate(T upper) {
        $(upper).mustNotBeNull();
        return o -> upper.compareTo(o) >= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isEqualToPredicate(T item) {
        $(item).mustNotBeNull();
        return o -> item.compareTo(o) == 0;
    }

    private String createBetweenExpectedMessage(ComparableUtility<Item> lower, ComparableUtility<Item> upper) {
        return createBetweenExpectedMessage(lower.orElse(null), upper.orElse(null));
    }

    private String createBetweenExpectedMessage(Item lower, Item upper) {
        return String.format("Expected: value between %s and %s\n     got: %s\n", lower, upper, orElse(null));
    }

    private String createGreaterThanExpectedMessage(Item lower) {
        return String.format("Expected: value greater than %s\n     got: %s\n", lower, orElse(null));
    }

    private String createGreaterThanOrEqualToExpectedMessage(Item lower) {
        return String.format("Expected: value greater than or equal to %s\n     got: %s\n", lower, orElse(null));
    }

    private String createLessThanExpectedMessage(Item lower) {
        return String.format("Expected: value less than %s\n     got: %s\n", lower, orElse(null));
    }

    private String createLessThanOrEqualToExpectedMessage(Item lower) {
        return String.format("Expected: value less than or equal to %s\n     got: %s\n", lower, orElse(null));
    }

    private String createEqualToExpectedMessage(Item item) {
        return String.format("Expected: value equal to %s\n     got: %s\n", item, orElse(null));
    }

}
