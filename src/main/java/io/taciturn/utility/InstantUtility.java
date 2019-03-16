package io.taciturn.utility;

import java.time.Instant;
import java.util.Date;

import static io.taciturn.Utility.$;

public class InstantUtility extends ComparableUtility<Instant> {

    public InstantUtility(Instant object) {
        super(object);
    }

    public Date toDate() {
        return map(Date::from).orElse(null);
    }

    public DateUtility mapToDate() {
        return $(toDate());
    }

    @Override
    public String toString() {
        return map(Instant::toString).orElse(null);
    }

    public StringUtility mapToString() {
        return $(toString());
    }

}
