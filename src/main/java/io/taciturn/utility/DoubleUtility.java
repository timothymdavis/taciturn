package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class DoubleUtility extends ComparableUtility<Double> {

    public static final double DEFAULT_VALUE = 0.0D;

    public DoubleUtility(Double object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Double.toString(o)).orElse(null);
    }

    public StringUtility mapToString() {
        return $(toString());
    }

    public double asPrimitive() {
        return asPrimitive(DEFAULT_VALUE);
    }

    public double asPrimitive(double defaultValue) {
        return map(o -> o).orElse(defaultValue);
    }

}
