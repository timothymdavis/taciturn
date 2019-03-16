package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class FloatUtility extends ComparableUtility<Float> {

    public static final float DEFAULT_VALUE = 0.0F;

    public FloatUtility(Float object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Float.toString(o)).orElse(null);
    }

    public StringUtility mapToString() {
        return $(toString());
    }

    public float asPrimitive() {
        return asPrimitive(DEFAULT_VALUE);
    }

    public float asPrimitive(float defaultValue) {
        return map(o -> o).orElse(defaultValue);
    }

}
