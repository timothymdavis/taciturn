package io.taciturn.utility;

import java.util.function.Predicate;

import static io.taciturn.Utility.$;

public class StringUtility extends ComparableUtility<String> {

    public StringUtility(String object) {
        super(object);
    }

    public boolean isBlank() {
        return blank().isPresent();
    }
    
    public boolean isEmpty() {
        return empty().isPresent();
    }

    public boolean isNotBlank() {
        return notBlank().isPresent();
    }

    public boolean isNotEmpty() {
        return notEmpty().isPresent();
    }

    public StringUtility blank() {
        return filter(isBlankPredicate());
    }

    public StringUtility empty() {
        return filter(isEmptyPredicate());
    }

    public StringUtility notBlank() {
        return filter(isBlankPredicate().negate());
    }

    public StringUtility notEmpty() {
        return filter(isEmptyPredicate().negate());
    }

    public ComparableUtility<Boolean> toBoolean() {
        return $(map(Boolean::parseBoolean).orElse(null));
    }

    public ComparableUtility<Double> toDouble() {
        return $(map(Double::parseDouble).orElse(null));
    }

    public ComparableUtility<Float> toFloat() {
        return $(map(Float::parseFloat).orElse(null));
    }

    public ComparableUtility<Integer> toInteger() {
        return $(map(Integer::parseInt).orElse(null));
    }

    public ComparableUtility<Integer> toInteger(int radix) {
        return $(map(o -> Integer.parseInt(o, radix)).orElse(null));
    }

    public ComparableUtility<Long> toLong() {
        return $(map(Long::parseLong).orElse(null));
    }

    public ComparableUtility<Long> toLong(int radix) {
        return $(map(o -> Long.parseLong(o, radix)).orElse(null));
    }

    public ComparableUtility<Short> toShort() {
        return $(map(Short::parseShort).orElse(null));
    }

    public ComparableUtility<Short> toShort(int radix) {
        return $(map(o -> Short.parseShort(o, radix)).orElse(null));
    }

    public Predicate<String> isEmptyPredicate() {
        return String::isEmpty;
    }

    public Predicate<String> isBlankPredicate() {
        return o -> o.trim().isEmpty();
    }

}
