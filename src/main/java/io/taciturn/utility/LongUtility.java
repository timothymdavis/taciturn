package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class LongUtility extends ComparableUtility<Long> {

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

}
