package io.taciturn.utility;

import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static io.taciturn.Utility.$;

public class StringUtilityTest {

    @Test
    public void testBlank() throws Exception {
        assertThat($((String) null).blank().isPresent(), is(false));
        assertThat($("").blank().isPresent(), is(true));
        assertThat($(" ").blank().isPresent(), is(true));
        assertThat($("a").blank().isPresent(), is(false));
    }

    @Test
    public void testConvertToBoolean() throws Exception {
        assertThat($((String) null).mapToBoolean().isPresent(), is(false));
        assertThat($((String) null).mapToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(false));
        assertThat($("false").mapToBoolean().isPresent(), is(true));
        assertThat($("false").mapToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(false));
        assertThat($("false").mapToBoolean().orElse(null), is(false));
        assertThat($("true").mapToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(true));
        assertThat($("True").mapToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(true));
        assertThat($("TRUE").mapToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(true));
    }

    @Test
    public void testConvertToDouble() throws Exception {
        assertThat($((String) null).mapToDouble().isPresent(), is(false));
        assertThat($((String) null).mapToDouble().orElse(null), nullValue());
        assertThat($((String) null).mapToDouble().orElse(DoubleUtility.DEFAULT_VALUE), is(0.0D));
        assertThat($("").mapToDouble().isPresent(), is(false));
        assertThat($("").mapToDouble().orElse(DoubleUtility.DEFAULT_VALUE), is(0.0D));
        assertThat($("1.0").mapToDouble().isPresent(), is(true));
        assertThat($("1.0").mapToDouble().orElse(DoubleUtility.DEFAULT_VALUE), is(1.0D));
    }

    @Test
    public void testConvertToFloat() throws Exception {
        assertThat($((String) null).mapToFloat().isPresent(), is(false));
        assertThat($((String) null).mapToFloat().orElse(null), nullValue());
        assertThat($((String) null).mapToFloat().orElse(FloatUtility.DEFAULT_VALUE), is(0.0F));
        assertThat($("").mapToFloat().isPresent(), is(false));
        assertThat($("").mapToFloat().orElse(FloatUtility.DEFAULT_VALUE), is(0.0F));
        assertThat($("1.0").mapToFloat().isPresent(), is(true));
        assertThat($("1.0").mapToFloat().orElse(FloatUtility.DEFAULT_VALUE), is(1.0F));
    }

    @Test
    public void testConvertToInteger() throws Exception {
        assertThat($((String) null).mapToInteger().isPresent(), is(false));
        assertThat($((String) null).mapToInteger().orElse(null), nullValue());
        assertThat($((String) null).mapToInteger().orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("").mapToInteger().isPresent(), is(false));
        assertThat($("").mapToInteger().orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("1.0").mapToInteger().isPresent(), is(false));
        assertThat($("1.0").mapToInteger().orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("1").mapToInteger().isPresent(), is(true));
        assertThat($("1").mapToInteger().orElse(IntegerUtility.DEFAULT_VALUE), is(1));
    }

    @Test
    public void testConvertToIntegerWithRadix() throws Exception {
        assertThat($((String) null).mapToInteger(2).isPresent(), is(false));
        assertThat($((String) null).mapToInteger(2).orElse(null), nullValue());
        assertThat($((String) null).mapToInteger(2).orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("").mapToInteger(2).isPresent(), is(false));
        assertThat($("").mapToInteger(2).orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("1.0").mapToInteger(2).isPresent(), is(false));
        assertThat($("1.0").mapToInteger(2).orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("1001").mapToInteger(2).isPresent(), is(true));
        assertThat($("1001").mapToInteger(2).orElse(IntegerUtility.DEFAULT_VALUE), is(9));
        assertThat($("9A1E").mapToInteger(16).isPresent(), is(true));
        assertThat($("9A1E").mapToInteger(16).orElse(IntegerUtility.DEFAULT_VALUE), is(39454));
    }

    @Test
    public void testConvertToLong() throws Exception {
        assertThat($((String) null).mapToLong().isPresent(), is(false));
        assertThat($((String) null).mapToLong().orElse(null), nullValue());
        assertThat($((String) null).mapToLong().orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("").mapToLong().isPresent(), is(false));
        assertThat($("").mapToLong().orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("1.0").mapToLong().isPresent(), is(false));
        assertThat($("1.0").mapToLong().orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("1").mapToLong().isPresent(), is(true));
        assertThat($("1").mapToLong().orElse(LongUtility.DEFAULT_VALUE), is(1L));
    }

    @Test
    public void testConvertToLongWithRadix() throws Exception {
        assertThat($((String) null).mapToLong(2).isPresent(), is(false));
        assertThat($((String) null).mapToLong(2).orElse(null), nullValue());
        assertThat($((String) null).mapToLong(2).orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("").mapToLong(2).isPresent(), is(false));
        assertThat($("").mapToLong(2).orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("1.0").mapToLong(2).isPresent(), is(false));
        assertThat($("1.0").mapToLong(2).orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("1001").mapToLong(2).isPresent(), is(true));
        assertThat($("1001").mapToLong(2).orElse(LongUtility.DEFAULT_VALUE), is(9L));
        assertThat($("9A1E").mapToLong(16).isPresent(), is(true));
        assertThat($("9A1E").mapToLong(16).orElse(LongUtility.DEFAULT_VALUE), is(39454L));
    }

    @Test
    public void testConvertToShort() throws Exception {
        assertThat($((String) null).mapToShort().isPresent(), is(false));
        assertThat($((String) null).mapToShort().orElse(null), nullValue());
        assertThat($((String) null).mapToShort().orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("").mapToShort().isPresent(), is(false));
        assertThat($("").mapToShort().orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("1.0").mapToShort().isPresent(), is(false));
        assertThat($("1.0").mapToShort().orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("1").mapToShort().isPresent(), is(true));
        assertThat($("1").mapToShort().orElse(ShortUtility.DEFAULT_VALUE), is((short) 1));
    }

    @Test
    public void testConvertToShortWithRadix() throws Exception {
        assertThat($((String) null).mapToShort(2).isPresent(), is(false));
        assertThat($((String) null).mapToShort(2).orElse(null), nullValue());
        assertThat($((String) null).mapToShort(2).orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("").mapToShort(2).isPresent(), is(false));
        assertThat($("").mapToShort(2).orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("1.0").mapToShort(2).isPresent(), is(false));
        assertThat($("1.0").mapToShort(2).orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("1001").mapToShort(2).isPresent(), is(true));
        assertThat($("1001").mapToShort(2).orElse(ShortUtility.DEFAULT_VALUE), is((short) 9));
        assertThat($("111E").mapToShort(16).isPresent(), is(true));
        assertThat($("111E").mapToShort(16).orElse(ShortUtility.DEFAULT_VALUE), is((short) 4382));
    }

    @Test
    public void testMustConvertToDouble() throws Exception {
        $("1").mustConvertToDouble();
        $("1.0").mustConvertToDouble();
        assetConvertFailure(() -> $("").mustConvertToDouble());
    }

    @Test
    public void testMustConvertToFloat() throws Exception {
        $("1").mustConvertToFloat();
        $("1.0").mustConvertToFloat();
        assetConvertFailure(() -> $("").mustConvertToFloat());
    }

    @Test
    public void testMustConvertToInteger() throws Exception {
        $("1").mustConvertToInteger();
        assetConvertFailure(() -> $("").mustConvertToInteger());
        assetConvertFailure(() -> $("1.0").mustConvertToInteger());
    }

    @Test
    public void testMustConvertToIntegerWithRadix() throws Exception {
        $("1001").mustConvertToInteger(2);
        $("111E").mustConvertToInteger(16);
        assetConvertFailure(() -> $("").mustConvertToInteger(2));
        assetConvertFailure(() -> $("1.0").mustConvertToInteger(2));
        assetConvertFailure(() -> $("111G").mustConvertToInteger(16));
    }

    @Test
    public void testMustConvertToLong() throws Exception {
        $("1").mustConvertToLong();
        assetConvertFailure(() -> $("").mustConvertToLong());
        assetConvertFailure(() -> $("1.0").mustConvertToLong());
    }

    @Test
    public void testMustConvertToLongWithRadix() throws Exception {
        $("1001").mustConvertToLong(2);
        $("111E").mustConvertToLong(16);
        assetConvertFailure(() -> $("").mustConvertToLong(2));
        assetConvertFailure(() -> $("1.0").mustConvertToLong(2));
        assetConvertFailure(() -> $("111G").mustConvertToLong(16));
    }

    @Test
    public void testMustConvertToShort() throws Exception {
        $("1").mustConvertToShort();
        assetConvertFailure(() -> $("").mustConvertToShort());
        assetConvertFailure(() -> $("1.0").mustConvertToShort());
    }

    @Test
    public void testMustConvertToShortWithRadix() throws Exception {
        $("1001").mustConvertToShort(2);
        $("111E").mustConvertToShort(16);
        assetConvertFailure(() -> $("").mustConvertToShort(2));
        assetConvertFailure(() -> $("1.0").mustConvertToShort(2));
        assetConvertFailure(() -> $("111G").mustConvertToShort(16));
    }

    @Test
    public void testEmpty() throws Exception {
        assertThat($((String) null).empty().isPresent(), is(false));
        assertThat($("").empty().isPresent(), is(true));
        assertThat($(" ").empty().isPresent(), is(false));
        assertThat($("a").empty().isPresent(), is(false));
    }

    @Test
    public void testIsBlank() throws Exception {
        assertThat($((String) null).isBlank(), is(false));
        assertThat($("").isBlank(), is(true));
        assertThat($(" ").isBlank(), is(true));
        assertThat($("a").isBlank(), is(false));
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertThat($((String) null).isEmpty(), is(false));
        assertThat($("").isEmpty(), is(true));
        assertThat($(" ").isEmpty(), is(false));
        assertThat($("a").isEmpty(), is(false));
    }

    @Test
    public void testIsNotBlank() throws Exception {
        assertThat($((String) null).isNotBlank(), is(false));
        assertThat($("").isNotBlank(), is(false));
        assertThat($(" ").isNotBlank(), is(false));
        assertThat($("a").isNotBlank(), is(true));
    }

    @Test
    public void testIsNotEmpty() throws Exception {
        assertThat($((String) null).isNotEmpty(), is(false));
        assertThat($("").isNotEmpty(), is(false));
        assertThat($(" ").isNotEmpty(), is(true));
        assertThat($("a").isNotEmpty(), is(true));
    }

    @Test
    public void testNotBlank() throws Exception {
        assertThat($((String) null).notBlank().isPresent(), is(false));
        assertThat($("").notBlank().isPresent(), is(false));
        assertThat($(" ").notBlank().isPresent(), is(false));
        assertThat($("a").notBlank().isPresent(), is(true));
    }

    @Test
    public void testNotEmpty() throws Exception {
        assertThat($((String) null).notEmpty().isPresent(), is(false));
        assertThat($("").notEmpty().isPresent(), is(false));
        assertThat($(" ").notEmpty().isPresent(), is(true));
        assertThat($("a").notEmpty().isPresent(), is(true));
    }

    private void assetConvertFailure(Supplier converter) {
        try {
            converter.get();
            Assert.fail("Convert should have thrown NumberFormatException");
        }
        catch (NumberFormatException ignored) {
        }
    }

}
