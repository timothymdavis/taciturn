package io.taciturn.utility;

import static io.taciturn.Utility.$;

public class CharacterUtility extends ComparableUtility<Character> {

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

}
