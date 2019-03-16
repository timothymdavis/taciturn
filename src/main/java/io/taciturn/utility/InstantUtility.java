package io.taciturn.utility;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

import static io.taciturn.Utility.$;

public class InstantUtility extends ComparableUtility<Instant> {

    public InstantUtility(Instant object) {
        super(object);
    }

    public OffsetDateTime toOffsetDateTime() {
        return map(OffsetDateTime::from).orElse(null);
    }

    public OffsetDateTime toOffsetDateTime(ZoneId zoneId) {
        return map(o -> OffsetDateTime.ofInstant(o, zoneId)).orElse(null);
    }

    public OffsetDateTime toOffsetDateTimeWithDefaultZoneId() {
        return map(o -> OffsetDateTime.ofInstant(o, ZoneId.systemDefault())).orElse(null);
    }

    public OffsetDateTimeUtility mapToOffsetDateTime() {
        return $(toOffsetDateTime());
    }

    public OffsetDateTimeUtility mapToOffsetDateTimeWithDefaultZoneId() {
        return $(toOffsetDateTimeWithDefaultZoneId());
    }

    public OffsetDateTimeUtility mapToOffsetDateTime(ZoneId zoneId) {
        return $(toOffsetDateTime(zoneId));
    }

    public LocalDateTime toLocalDateTime() {
        return map(LocalDateTime::from).orElse(null);
    }

    public LocalDateTime toLocalDateTimeWithDefaultZoneId() {
        return map(o -> LocalDateTime.ofInstant(o, ZoneId.systemDefault())).orElse(null);
    }

    public LocalDateTime toLocalDateTime(ZoneId zoneId) {
        return map(o -> LocalDateTime.ofInstant(o, zoneId)).orElse(null);
    }

    public LocalDateTimeUtility mapToLocalDateTime() {
        return $(toLocalDateTime());
    }

    public LocalDateTimeUtility mapToLocalDateTimeWithDefaultZoneId() {
        return $(toLocalDateTimeWithDefaultZoneId());
    }

    public LocalDateTimeUtility mapToLocalDateTime(ZoneId zoneId) {
        return $(toLocalDateTime(zoneId));
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
