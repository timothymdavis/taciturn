package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class DoubleUtility extends ComparableUtility<Double> {

    public DoubleUtility(Double object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Double.toString(o)).orElse(null);
    }

    public StringUtility convertToString() {
        return $(toString());
    }

}
