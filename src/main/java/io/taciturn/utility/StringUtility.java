package io.taciturn.utility;

import java.util.Optional;
import java.util.function.Predicate;

public class StringUtility extends ComparableUtility<String> {

    public StringUtility(String object) {
        super(object);
    }

    public boolean isBlank() {
        return blank().isPresent();
    }
    
    public boolean isEmpty() {
        return empty().orElse(false);
    }

    public boolean isNotBlank() {
        return notBlank().orElse(false);
    }

    public boolean isNotEmpty() {
        return notEmpty().orElse(false);
    }

    public Optional<Boolean> blank() {
        return map(String::trim).map(String::isEmpty);
    }

    public Optional<Boolean> empty() {
        return map(String::isEmpty);
    }

    public Optional<Boolean> notBlank() {
        return blank().map(o -> !o);
    }

    public Optional<Boolean> notEmpty() {
        return empty().map(o -> !o);
    }

    public Optional<Boolean> toBoolean() {
        return map(Boolean::parseBoolean);
    }

    public Optional<Double> toDouble() {
        return map(Double::parseDouble);
    }

    public Optional<Float> toFloat() {
        return map(Float::parseFloat);
    }

    public Optional<Integer> toInteger() {
        return map(Integer::parseInt);
    }

    public Optional<Integer> toInteger(int radix) {
        return map(o -> Integer.parseInt(o, radix));
    }

    public Optional<Long> toLong() {
        return map(Long::parseLong);
    }

    public Optional<Long> toLong(int radix) {
        return map(o -> Long.parseLong(o, radix));
    }

    public Optional<Short> toShort() {
        return map(Short::parseShort);
    }

    public Optional<Short> toShort(int radix) {
        return map(o -> Short.parseShort(o, radix));
    }

    public Predicate<String> isEmptyPredicate() {
        return String::isEmpty;
    }

    public Predicate<String> isBlankPredicate() {
        return o -> o.trim().isEmpty();
    }

}
