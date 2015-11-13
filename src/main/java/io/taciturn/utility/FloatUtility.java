package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class FloatUtility extends ComparableUtility<Float> {

    public FloatUtility(Float object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Float.toString(o)).orElse(null);
    }

    public StringUtility convertToString() {
        return $(toString());
    }

}
