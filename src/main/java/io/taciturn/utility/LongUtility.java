package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class LongUtility extends ComparableUtility<Long> {

    public static final long DEFAULT_VALUE = 0L;

    public LongUtility(Long object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Long.toString(o)).orElse(null);
    }

    public StringUtility convertToString() {
        return $(toString());
    }

    public long asPrimitive() {
        return asPrimitive(DEFAULT_VALUE);
    }

    public long asPrimitive(long defaultValue) {
        return map(o -> o).orElse(defaultValue);
    }

}
