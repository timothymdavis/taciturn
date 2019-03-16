package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class ByteUtility extends ComparableUtility<Byte> {

    public static final byte DEFAULT_VALUE = (byte) 0;

    public ByteUtility(Byte object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Byte.toString(o)).orElse(null);
    }

    public StringUtility mapToString() {
        return $(toString());
    }

    public byte asPrimitive() {
        return asPrimitive(DEFAULT_VALUE);
    }

    public byte asPrimitive(byte defaultValue) {
        return map(o -> o).orElse(defaultValue);
    }

}
