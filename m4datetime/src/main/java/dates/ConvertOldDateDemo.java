package dates;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class ConvertOldDateDemo {

    /**
     * Instant
     *  -An instantaneous point on the time-line - the epoch-seconds are measured from the standard Java epoch of 1970-01-01T00:00:00
     *  - like Date, doesn't have TimeZone
     *
     * LocalDateTime
     *  -A date-time without a time-zone too ?? the time-zone used as an offset
     *
     * ZonedDateTime
     * - stores all date and time fields, to a precision of nanoseconds, and a timezone, with a zone offset used to handle ambiguous local date-times
     * can't freely set offsets, as the zone controls the valid offset values .  is fully DST-aware and handles daylight savings adjustments
     * comes in handy for displaying date-time fields in a user-specific timezone
     */
    public static void main(String[] args) {

        // https://stackoverflow.com/questions/19431234/converting-between-java-time-localdatetime-and-java-util-date
        // https://www.baeldung.com/java-date-to-localdate-and-localdatetime

        Date in = new Date();

        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        LocalDateTime ldt2 = LocalDateTime.ofInstant(in.toInstant(), ZoneId.of("America/New_York"));
//        System.out.println(ZoneId.getAvailableZoneIds());
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println(in);
        System.out.println(ldt);
        System.out.println(ldt2);
        System.out.println(out);

        // similar for ZonedDateTime
        // use slide from "Programming with Dates and Times in Java"
        // ref to
        ZonedDateTime zdt = ZonedDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());

    }
}
