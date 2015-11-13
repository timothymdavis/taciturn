package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class ShortUtility extends ComparableUtility<Short> {

    public ShortUtility(Short object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Short.toString(o)).orElse(null);
    }

    public StringUtility convertToString() {
        return $(toString());
    }

}
