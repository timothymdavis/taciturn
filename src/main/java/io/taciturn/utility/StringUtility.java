package io.taciturn.utility;

import java.util.function.Predicate;
import java.util.function.Supplier;

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

    public BooleanUtility convertToBoolean() {
        return $(map(Boolean::parseBoolean).orElse(null));
    }

    public DoubleUtility mustConvertToDouble() {
        return $(map(Double::parseDouble).orElse(null));
    }

    public FloatUtility mustConvertToFloat() {
        return $(map(Float::parseFloat).orElse(null));
    }

    private <T extends ComparableUtility<? extends Number>> T convertToNumber(
            T utility,
            Supplier<T> defaultValueSupplier) {
        $(utility).mustNotBeNull();
        $(defaultValueSupplier).mustNotBeNull();
        try {
            return utility;
        }
        catch (NumberFormatException e) {
            return defaultValueSupplier.get();
        }
    }

    public IntegerUtility convertToInteger() {
        return convertToNumber(mustConvertToInteger(), () -> new IntegerUtility(null));
    }

    public IntegerUtility convertToInteger(int radix) {
        return convertToNumber(mustConvertToInteger(radix), () -> new IntegerUtility(null));
    }

    public LongUtility convertToLong() {
        return convertToNumber(mustConvertToLong(), () -> new LongUtility(null));
    }

    public LongUtility convertToLong(int radix) {
        return convertToNumber(mustConvertToLong(radix), () -> new LongUtility(null));
    }

    public ShortUtility convertToShort() {
        return convertToNumber(mustConvertToShort(), () -> new ShortUtility(null));
    }

    public ShortUtility convertToShort(int radix) {
        return convertToNumber(mustConvertToShort(radix), () -> new ShortUtility(null));
    }

    public IntegerUtility mustConvertToInteger() {
        return $(map(Integer::parseInt).orElse(null));
    }

    public IntegerUtility mustConvertToInteger(int radix) {
        return $(map(o -> Integer.parseInt(o, radix)).orElse(null));
    }

    public LongUtility mustConvertToLong() {
        return $(map(Long::parseLong).orElse(null));
    }

    public LongUtility mustConvertToLong(int radix) {
        return $(map(o -> Long.parseLong(o, radix)).orElse(null));
    }

    public ShortUtility mustConvertToShort() {
        return $(map(Short::parseShort).orElse(null));
    }

    public ShortUtility mustConvertToShort(int radix) {
        return $(map(o -> Short.parseShort(o, radix)).orElse(null));
    }

    public Predicate<String> isEmptyPredicate() {
        return String::isEmpty;
    }

    public Predicate<String> isBlankPredicate() {
        return o -> o.trim().isEmpty();
    }

}
