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
    
    public boolean isBetween(Item lower, Item upper) {
        return between(lower, upper).orElse(false);
    }

    public boolean isGreaterThan(Item lower) {
        return greaterThan(lower).orElse(false);
    }

    public boolean isGreaterThanOrEqualTo(Item lower) {
        return greaterThanOrEqualTo(lower).orElse(false);
    }

    public boolean isLessThan(Item upper) {
        return lessThan(upper).orElse(false);
    }

    public boolean isLessThanOrEqualTo(Item upper) {
        return lessThanOrEqualTo(upper).orElse(false);
    }

    public boolean isEqualTo(Item item) {
        return equalTo(item).orElse(false);
    }

    public Optional<Boolean> between(Item lower, Item upper) {
        return Optional.of(filter(isBetweenPredicate(lower, upper)).isPresent());
    }

    public Optional<Boolean> greaterThan(Item lower) {
        return Optional.of(filter(isGreaterThanPredicate(lower)).isPresent());
    }

    public Optional<Boolean> greaterThanOrEqualTo(Item lower) {
        return Optional.of(filter(isGreaterThanOrEqualToPredicate(lower)).isPresent());
    }

    public Optional<Boolean> lessThan(Item upper) {
        return Optional.of(filter(isLessThanPredicate(upper)).isPresent());
    }

    public Optional<Boolean> lessThanOrEqualTo(Item upper) {
        return Optional.of(filter(isLessThanOrEqualToPredicate(upper)).isPresent());
    }

    public Optional<Boolean> equalTo(Item item) {
        return Optional.of(filter(isEqualToPredicate(item)).isPresent());
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
