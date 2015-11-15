package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class BooleanUtility extends ComparableUtility<Boolean> {

    public static final boolean DEFAULT_VALUE = false;

    public BooleanUtility(Boolean object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Boolean.toString(o)).orElse(null);
    }

    public StringUtility convertToString() {
        return $(toString());
    }

    public boolean asPrimitive() {
        return asPrimitive(DEFAULT_VALUE);
    }

    public boolean asPrimitive(boolean defaultValue) {
        return map(o -> o).orElse(defaultValue);
    }

}
