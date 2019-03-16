package io.taciturn.utility;

import java.time.Instant;
import java.util.Date;

import static io.taciturn.Utility.$;

public class DateUtility extends ComparableUtility<Date> {

    public DateUtility(Date object) {
        super(object);
    }
    
    public DateUtility to(Instant instant) {
        ifPresent(o -> o.setTime(Date.from(instant).getTime()));
        return this;
    }

    @Override
    public String toString() {
        return map(Date::toString).orElse(null);
    }

    public StringUtility mapToString() {
        return $(toString());
    }

}
