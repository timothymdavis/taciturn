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
        assertThat($((String) null).convertToBoolean().isPresent(), is(false));
        assertThat($((String) null).convertToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(false));
        assertThat($("false").convertToBoolean().isPresent(), is(true));
        assertThat($("false").convertToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(false));
        assertThat($("false").convertToBoolean().orElse(null), is(false));
        assertThat($("true").convertToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(true));
        assertThat($("True").convertToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(true));
        assertThat($("TRUE").convertToBoolean().orElse(BooleanUtility.DEFAULT_VALUE), is(true));
    }

    @Test
    public void testConvertToDouble() throws Exception {
        assertThat($((String) null).convertToDouble().isPresent(), is(false));
        assertThat($((String) null).convertToDouble().orElse(null), nullValue());
        assertThat($((String) null).convertToDouble().orElse(DoubleUtility.DEFAULT_VALUE), is(0.0D));
        assertThat($("").convertToDouble().isPresent(), is(false));
        assertThat($("").convertToDouble().orElse(DoubleUtility.DEFAULT_VALUE), is(0.0D));
        assertThat($("1.0").convertToDouble().isPresent(), is(true));
        assertThat($("1.0").convertToDouble().orElse(DoubleUtility.DEFAULT_VALUE), is(1.0D));
    }

    @Test
    public void testConvertToFloat() throws Exception {
        assertThat($((String) null).convertToFloat().isPresent(), is(false));
        assertThat($((String) null).convertToFloat().orElse(null), nullValue());
        assertThat($((String) null).convertToFloat().orElse(FloatUtility.DEFAULT_VALUE), is(0.0F));
        assertThat($("").convertToFloat().isPresent(), is(false));
        assertThat($("").convertToFloat().orElse(FloatUtility.DEFAULT_VALUE), is(0.0F));
        assertThat($("1.0").convertToFloat().isPresent(), is(true));
        assertThat($("1.0").convertToFloat().orElse(FloatUtility.DEFAULT_VALUE), is(1.0F));
    }

    @Test
    public void testConvertToInteger() throws Exception {
        assertThat($((String) null).convertToInteger().isPresent(), is(false));
        assertThat($((String) null).convertToInteger().orElse(null), nullValue());
        assertThat($((String) null).convertToInteger().orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("").convertToInteger().isPresent(), is(false));
        assertThat($("").convertToInteger().orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("1.0").convertToInteger().isPresent(), is(false));
        assertThat($("1.0").convertToInteger().orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("1").convertToInteger().isPresent(), is(true));
        assertThat($("1").convertToInteger().orElse(IntegerUtility.DEFAULT_VALUE), is(1));
    }

    @Test
    public void testConvertToIntegerWithRadix() throws Exception {
        assertThat($((String) null).convertToInteger(2).isPresent(), is(false));
        assertThat($((String) null).convertToInteger(2).orElse(null), nullValue());
        assertThat($((String) null).convertToInteger(2).orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("").convertToInteger(2).isPresent(), is(false));
        assertThat($("").convertToInteger(2).orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("1.0").convertToInteger(2).isPresent(), is(false));
        assertThat($("1.0").convertToInteger(2).orElse(IntegerUtility.DEFAULT_VALUE), is(0));
        assertThat($("1001").convertToInteger(2).isPresent(), is(true));
        assertThat($("1001").convertToInteger(2).orElse(IntegerUtility.DEFAULT_VALUE), is(9));
        assertThat($("9A1E").convertToInteger(16).isPresent(), is(true));
        assertThat($("9A1E").convertToInteger(16).orElse(IntegerUtility.DEFAULT_VALUE), is(39454));
    }

    @Test
    public void testConvertToLong() throws Exception {
        assertThat($((String) null).convertToLong().isPresent(), is(false));
        assertThat($((String) null).convertToLong().orElse(null), nullValue());
        assertThat($((String) null).convertToLong().orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("").convertToLong().isPresent(), is(false));
        assertThat($("").convertToLong().orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("1.0").convertToLong().isPresent(), is(false));
        assertThat($("1.0").convertToLong().orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("1").convertToLong().isPresent(), is(true));
        assertThat($("1").convertToLong().orElse(LongUtility.DEFAULT_VALUE), is(1L));
    }

    @Test
    public void testConvertToLongWithRadix() throws Exception {
        assertThat($((String) null).convertToLong(2).isPresent(), is(false));
        assertThat($((String) null).convertToLong(2).orElse(null), nullValue());
        assertThat($((String) null).convertToLong(2).orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("").convertToLong(2).isPresent(), is(false));
        assertThat($("").convertToLong(2).orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("1.0").convertToLong(2).isPresent(), is(false));
        assertThat($("1.0").convertToLong(2).orElse(LongUtility.DEFAULT_VALUE), is(0L));
        assertThat($("1001").convertToLong(2).isPresent(), is(true));
        assertThat($("1001").convertToLong(2).orElse(LongUtility.DEFAULT_VALUE), is(9L));
        assertThat($("9A1E").convertToLong(16).isPresent(), is(true));
        assertThat($("9A1E").convertToLong(16).orElse(LongUtility.DEFAULT_VALUE), is(39454L));
    }

    @Test
    public void testConvertToShort() throws Exception {
        assertThat($((String) null).convertToShort().isPresent(), is(false));
        assertThat($((String) null).convertToShort().orElse(null), nullValue());
        assertThat($((String) null).convertToShort().orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("").convertToShort().isPresent(), is(false));
        assertThat($("").convertToShort().orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("1.0").convertToShort().isPresent(), is(false));
        assertThat($("1.0").convertToShort().orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("1").convertToShort().isPresent(), is(true));
        assertThat($("1").convertToShort().orElse(ShortUtility.DEFAULT_VALUE), is((short) 1));
    }

    @Test
    public void testConvertToShortWithRadix() throws Exception {
        assertThat($((String) null).convertToShort(2).isPresent(), is(false));
        assertThat($((String) null).convertToShort(2).orElse(null), nullValue());
        assertThat($((String) null).convertToShort(2).orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("").convertToShort(2).isPresent(), is(false));
        assertThat($("").convertToShort(2).orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("1.0").convertToShort(2).isPresent(), is(false));
        assertThat($("1.0").convertToShort(2).orElse(ShortUtility.DEFAULT_VALUE), is((short) 0));
        assertThat($("1001").convertToShort(2).isPresent(), is(true));
        assertThat($("1001").convertToShort(2).orElse(ShortUtility.DEFAULT_VALUE), is((short) 9));
        assertThat($("111E").convertToShort(16).isPresent(), is(true));
        assertThat($("111E").convertToShort(16).orElse(ShortUtility.DEFAULT_VALUE), is((short) 4382));
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
