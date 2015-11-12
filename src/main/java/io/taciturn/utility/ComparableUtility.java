package io.taciturn.utility;

import java.util.function.Predicate;

import static io.taciturn.Utility.$;

public class ComparableUtility<Item extends Comparable<Item>>
        extends NonIterableUtility<Item> {

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

    public Item mustBeBetween(Item lower, Item upper) {
        return mustBe(isBetweenPredicate(lower, upper), createBetweenExpectedMessage(lower, upper));
    }

    public Item mustBeGreaterThan(Item lower) {
        return mustBe(isGreaterThanPredicate(lower), createGreaterThanExpectedMessage(lower));
    }

    public Item mustBeGreaterThanOrEqualTo(Item lower) {
        return mustBe(isGreaterThanOrEqualToPredicate(lower), createGreaterThanOrEqualToExpectedMessage(lower));
    }

    public Item mustBeLessThan(Item upper) {
        return mustBe(isLessThanPredicate(upper), createLessThanExpectedMessage(upper));
    }

    public Item mustBeLessThanOrEqualTo(Item upper) {
        return mustBe(isLessThanOrEqualToPredicate(upper), createLessThanOrEqualToExpectedMessage(upper));
    }

    public Item mustBeEqualTo(Item upper) {
        return mustBe(isEqualToPredicate(upper), createEqualToExpectedMessage(upper));
    }

    public static <T extends Comparable<T>> Predicate<T> isBetweenPredicate(T lower, T upper) {
        return o -> $(lower).mustNotBeNull().compareTo(o) <= 0 && $(upper).mustNotBeNull().compareTo(o) >= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isGreaterThanPredicate(T lower) {
        return o -> $(lower).mustNotBeNull().compareTo(o) < 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isGreaterThanOrEqualToPredicate(T lower) {
        return o -> $(lower).mustNotBeNull().compareTo(o) <= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isLessThanPredicate(T upper) {
        return o -> $(upper).mustNotBeNull().compareTo(o) > 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isLessThanOrEqualToPredicate(T upper) {
        return o -> $(upper).mustNotBeNull().compareTo(o) >= 0;
    }

    public static <T extends Comparable<T>> Predicate<T> isEqualToPredicate(T item) {
        return o -> $(item).mustNotBeNull().compareTo(o) == 0;
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
