package io.taciturn.utility;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

import static io.taciturn.Utility.$;

public class DateUtility extends ComparableUtility<Date> {

    public DateUtility(Date object) {
        super(object);
    }

    public LocalDateTime toLocalDateTime() {
        return mapToInstant().map(LocalDateTime::from).orElse(null);
    }

    public LocalDateTime toLocalDateTimeWithDefaultZoneId() {
        return mapToInstant().map(o -> LocalDateTime.ofInstant(o, ZoneId.systemDefault())).orElse(null);
    }

    public LocalDateTime toLocalDateTime(ZoneId zoneId) {
        return mapToInstant().map(o -> LocalDateTime.ofInstant(o, zoneId)).orElse(null);
    }

    public LocalDateTimeUtility mapToLocalDateTimeWithDefaultZoneId() {
        return $(toLocalDateTimeWithDefaultZoneId());
    }

    public LocalDateTimeUtility mapToLocalDateTime(ZoneId zoneId) {
        return $(toLocalDateTime(zoneId));
    }

    public OffsetDateTime toOffsetDateTime() {
        return mapToInstant().map(OffsetDateTime::from).orElse(null);
    }

    public OffsetDateTime toOffsetDateTimeWithDefaultZoneId() {
        return mapToInstant().map(o -> OffsetDateTime.ofInstant(o, ZoneId.systemDefault())).orElse(null);
    }

    public OffsetDateTime toOffsetDateTime(ZoneId zoneId) {
        return mapToInstant().map(o -> OffsetDateTime.ofInstant(o, zoneId)).orElse(null);
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

    public Instant toInstant() {
        return map(Date::toInstant).orElse(null);
    }

    public InstantUtility mapToInstant() {
        return $(toInstant());
    }

    @Override
    public String toString() {
        return map(Date::toString).orElse(null);
    }

    public StringUtility mapToString() {
        return $(toString());
    }

}
