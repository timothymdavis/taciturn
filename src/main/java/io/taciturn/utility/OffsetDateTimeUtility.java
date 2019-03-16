package io.taciturn.utility;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.temporal.Temporal;
import java.util.Date;

import static io.taciturn.Utility.$;

public class OffsetDateTimeUtility extends ObjectUtility<OffsetDateTime> {

    public OffsetDateTimeUtility(OffsetDateTime object) {
        super(object);
    }

    public Temporal asTemporal() {
        return map(o -> (Temporal) o).orElse(null);
    }

    public Date toDate() {
        return map(o -> Date.from(o.toInstant())).orElse(null);
    }

    public DateUtility mapToDate() {
        return $(toDate());
    }

    public OffsetTime toOffsetTime() {
        return map(OffsetTime::from).orElse(null);
    }

    public LocalDateTime toLocalDateTime() {
        return map(OffsetDateTime::toLocalDateTime).orElse(null);
    }

    public LocalDateTimeUtility mapToLocalDateTime() {
        return $(toLocalDateTime());
    }

    public Instant toInstant() {
        return map(OffsetDateTime::toInstant).orElse(null);
    }

    public InstantUtility mapToInstant() {
        return $(toInstant());
    }

    @Override
    public String toString() {
        return map(OffsetDateTime::toString).orElse(null);
    }

    public StringUtility mapToString() {
        return $(toString());
    }

}
