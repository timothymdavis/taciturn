package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class ByteUtility extends ComparableUtility<Byte> {

    public ByteUtility(Byte object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Byte.toString(o)).orElse(null);
    }

    public StringUtility convertToString() {
        return $(toString());
    }

}
