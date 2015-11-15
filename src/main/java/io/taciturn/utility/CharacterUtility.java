package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class CharacterUtility extends ComparableUtility<Character> {

    public static final char DEFAULT_VALUE = '\u0000';

    public CharacterUtility(Character object) {
        super(object);
    }
    
    @Override
    public String toString() {
        return map(o -> Character.toString(o)).orElse(null);
    }

    public StringUtility convertToString() {
        return $(toString());
    }

    public char asPrimitive() {
        return asPrimitive(DEFAULT_VALUE);
    }

    public char asPrimitive(char defaultValue) {
        return map(o -> o).orElse(defaultValue);
    }

}
