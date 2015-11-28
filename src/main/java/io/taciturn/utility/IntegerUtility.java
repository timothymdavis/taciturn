package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class IntegerUtility extends ComparableUtility<Integer> {

    public static final int DEFAULT_VALUE = 0;

    public IntegerUtility(Integer object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Integer.toString(o)).orElse(null);
    }

    public StringUtility convertToString() {
        return $(toString());
    }

    public StringUtility convertToString(int radix) {
        return $(map(o -> Integer.toString(o, radix)).orElse(null));
    }

    public int asPrimitive() {
        return asPrimitive(DEFAULT_VALUE);
    }
    
    public int asPrimitive(int defaultValue) {
        return orElse(defaultValue);
    }

}
