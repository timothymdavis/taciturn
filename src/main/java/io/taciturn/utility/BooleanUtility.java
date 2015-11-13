package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class BooleanUtility extends ComparableUtility<Boolean> {

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

}
