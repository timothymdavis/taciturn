package io.taciturn.utility;

import java.lang.reflect.Array;

public class ClassUtility<Item> extends AbstractUtility<Class<Item>> {

    public ClassUtility(Class<Item> type) {
        super(type);
    }

    @SuppressWarnings("unchecked")
    public Item[] newArray() {
        return newArray(0);
    }

    @SuppressWarnings("unchecked")
    public Item[] newArray(int size) {
        return map(type -> (Item[]) Array.newInstance(type, size)).orElse(null);
    }

}
