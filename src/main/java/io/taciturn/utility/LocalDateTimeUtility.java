package io.taciturn.utility;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.Temporal;
import java.util.Date;

import static io.taciturn.Utility.$;

public class LocalDateTimeUtility extends ObjectUtility<LocalDateTime> {

    public LocalDateTimeUtility(LocalDateTime object) {
        super(object);
    }

    public Temporal asTemporal() {
        return map(o -> (Temporal) o).orElse(null);
    }

    public Date toDate() {
        return map(o -> Date.from(o.atZone(ZoneId.systemDefault()).toInstant())).orElse(null);
    }

    public Date toDate(ZoneId zoneId) {
        return map(o -> Date.from(o.atZone(zoneId).toInstant())).orElse(null);
    }

    public DateUtility mapToDate() {
        return $(toDate());
    }

    public DateUtility mapToDate(ZoneOffset zoneOffset) {
        return $(toDate(zoneOffset));
    }

    public LocalDate toLocalDate() {
        return map(LocalDate::from).orElse(null);
    }

    public LocalTime toLocalTime() {
        return map(LocalTime::from).orElse(null);
    }

    public OffsetDateTime toOffsetDateTime(ZoneOffset zoneOffset) {
        return map(o -> o.atOffset(zoneOffset)).orElse(null);
    }

    public OffsetDateTimeUtility mapToOffsetDateTime(ZoneOffset zoneOffset) {
        return $(toOffsetDateTime(zoneOffset));
    }

    public Instant toInstantWithDefaultZoneId() {
        return map(o -> o.toInstant(ZoneOffset.of(ZoneId.systemDefault().getId()))).orElse(null);
    }

    public Instant toInstant(ZoneOffset zoneOffset) {
        return map(o -> o.toInstant(zoneOffset)).orElse(null);
    }

    public InstantUtility mapToInstantWithDefaultZoneId() {
        return $(toInstantWithDefaultZoneId());
    }

    public InstantUtility mapToInstant(ZoneOffset zoneOffset) {
        return $(toInstant(zoneOffset));
    }

    @Override
    public String toString() {
        return map(LocalDateTime::toString).orElse(null);
    }

    public StringUtility mapToString() {
        return $(toString());
    }

}
