package io.taciturn.utility;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static io.taciturn.Utility.$;

public class StringUtility extends ComparableUtility<String> {

    public static final Predicate<String> isEmptyPredicate = String::isEmpty;
    public static final Predicate<String> isBlankPredicate = o -> o.trim().isEmpty();

    public StringUtility(String object) {
        super(object);
    }

    public StringUtility blank() {
        return filter(isBlankPredicate);
    }

    public Boolean toBoolean() {
        return map(Boolean::parseBoolean).orElse(null);
    }

    public BooleanUtility mapToBoolean() {
        return $(toBoolean());
    }

    public Double toDouble() {
        return map(Double::parseDouble).orElse(null);
    }

    public DoubleUtility mapToDouble() {
        return mapToNumber(this::mustConvertToDouble, () -> new DoubleUtility(null));
    }

    public Float toFloat() {
        return map(Float::parseFloat).orElse(null);
    }

    public FloatUtility mapToFloat() {
        return mapToNumber(this::mustConvertToFloat, () -> new FloatUtility(null));
    }

    public Integer toInteger() {
        return map(Integer::parseInt).orElse(null);
    }

    public IntegerUtility mapToInteger() {
        return mapToNumber(this::mustConvertToInteger, () -> new IntegerUtility(null));
    }

    public Integer toInteger(int radix) {
        return map(o -> Integer.parseInt(o, radix)).orElse(null);
    }

    public IntegerUtility mapToInteger(int radix) {
        return mapToNumber(() -> mustConvertToInteger(radix), () -> new IntegerUtility(null));
    }

    public Long toLong() {
        return map(Long::parseLong).orElse(null);
    }

    public LongUtility mapToLong() {
        return mapToNumber(this::mustConvertToLong, () -> new LongUtility(null));
    }

    public Long toLong(int radix) {
        return map(o -> Long.parseLong(o, radix)).orElse(null);
    }

    public LongUtility mapToLong(int radix) {
        return mapToNumber(() -> mustConvertToLong(radix), () -> new LongUtility(null));
    }

    public Short toShort() {
        return map(Short::parseShort).orElse(null);
    }

    public ShortUtility mapToShort() {
        return mapToNumber(this::mustConvertToShort, () -> new ShortUtility(null));
    }

    public Short toShort(int radix) {
        return map(o -> Short.parseShort(o, radix)).orElse(null);
    }

    public ShortUtility mapToShort(int radix) {
        return mapToNumber(() -> mustConvertToShort(radix), () -> new ShortUtility(null));
    }

    private <T extends ComparableUtility<? extends Number>> T mapToNumber(
            Supplier<T> utility,
            Supplier<T> defaultValueSupplier) {
        $(utility).mustNotBeNull();
        $(defaultValueSupplier).mustNotBeNull();
        try {
            return utility.get();
        }
        catch (NumberFormatException e) {
            return defaultValueSupplier.get();
        }
    }

    /**
     * @return Date parsed using the {@link DateTimeFormatter#ISO_INSTANT} format, such as '2011-12-03T10:15:30Z'.
     */
    public Date toDate() {
        return mapToInstant().toDate();
    }

    public DateUtility mapToDate() {
        return mapToInstant().mapToDate();
    }

    public DateUtility mustConvertToDate() {
        return $(toDate());
    }

    public Date toDate(DateTimeFormatter dateTimeFormatter) {
        return mapToInstant(dateTimeFormatter).toDate();
    }

    public DateUtility mapToDate(DateTimeFormatter dateTimeFormatter) {
        return mapToInstant(dateTimeFormatter).mapToDate();
    }

    public DateUtility mustConvertToDate(DateTimeFormatter dateTimeFormatter) {
        return $(toDate(dateTimeFormatter));
    }

    public DoubleUtility mustConvertToDouble() {
        return $(map(Double::parseDouble).orElse(null));
    }

    public FloatUtility mustConvertToFloat() {
        return $(map(Float::parseFloat).orElse(null));
    }

    /**
     * @return {@link Instant} parsed using the {@link DateTimeFormatter#ISO_INSTANT} format.
     */
    public Instant toInstant() {
        return map(Instant::parse).orElse(null);
    }

    public InstantUtility mapToInstant() {
        try {
            return mustConvertToInstant();
        }
        catch (DateTimeParseException e) {
            return new InstantUtility(null);
        }
    }

    public InstantUtility mustConvertToInstant() {
        return $(toInstant());
    }

    public Instant toInstant(DateTimeFormatter dateTimeFormatter) {
        return map(o -> dateTimeFormatter.parse(o, Instant::from)).orElse(null);
    }

    public InstantUtility mapToInstant(DateTimeFormatter dateTimeFormatter) {
        try {
            return mustConvertToInstant(dateTimeFormatter);
        }
        catch (DateTimeParseException e) {
            return new InstantUtility(null);
        }
    }

    public InstantUtility mustConvertToInstant(DateTimeFormatter dateTimeFormatter) {
        return $(toInstant(dateTimeFormatter));
    }

    public IntegerUtility mustConvertToInteger() {
        return $(toInteger());
    }

    public IntegerUtility mustConvertToInteger(int radix) {
        return $(toInteger(radix));
    }

    public LongUtility mustConvertToLong() {
        return $(toLong());
    }

    public LongUtility mustConvertToLong(int radix) {
        return $(toLong(radix));
    }

    public ShortUtility mustConvertToShort() {
        return $(toShort());
    }

    public ShortUtility mustConvertToShort(int radix) {
        return $(toShort(radix));
    }

    public StringUtility empty() {
        return filter(isEmptyPredicate);
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

    public StringUtility notBlank() {
        return filter(isBlankPredicate.negate());
    }

    public StringUtility notEmpty() {
        return filter(isEmptyPredicate.negate());
    }
}
