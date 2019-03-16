package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class ShortUtility extends ComparableUtility<Short> {

    public static final short DEFAULT_VALUE = (short) 0;

    public ShortUtility(Short object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Short.toString(o)).orElse(null);
    }

    public StringUtility mapToString() {
        return $(toString());
    }

    public short asPrimitive() {
        return asPrimitive(DEFAULT_VALUE);
    }

    public short asPrimitive(short defaultValue) {
        return map(o -> o).orElse(defaultValue);
    }

}
