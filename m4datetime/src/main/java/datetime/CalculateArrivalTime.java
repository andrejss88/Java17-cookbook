package datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * https://mkyong.com/java/java-convert-date-and-time-between-timezone/
 */
public class CalculateArrivalTime {

    public static void main(String[] args) {

        // int year, Month month, int dayOfMonth, int hour, int minute
        var departure = LocalDateTime.of(2022, Month.JULY, 22, 7, 0);
        var arrival = departure.plusHours(8);


        var departureLondonPerspective = departure.atZone(ZoneId.of("Europe/London"));
        var arrivalLondonPerspective = arrival.atZone(ZoneId.of("Europe/London"));

        // alternatively
//        var alternative = ZonedDateTime.of(departure, ZoneId.of("Europe/London"));

        System.out.println(departureLondonPerspective);
        System.out.println(arrivalLondonPerspective);

        var departureNyPerspective = departureLondonPerspective.withZoneSameInstant(ZoneId.of("America/New_York"));
        var arrivalNyPerspective = arrivalLondonPerspective.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println(departureNyPerspective);
        System.out.println(arrivalNyPerspective);

        System.out.printf("Flight departs at %s and arrives at %s%n", departureLondonPerspective, arrivalNyPerspective);

        System.out.println("======== Flight ========");

        System.out.println(new Flight("Europe/London", "America/New_York", departure, 8));
        System.out.println(new Flight("Europe/Berlin", "Asia/Dubai", departure, 4));

    }

    public record Flight(String from, String to, LocalDateTime departure, int duration) {


        @Override
        public String toString() {
            ZoneId fromZone = ZoneId.of(from);
            ZoneId toZone = ZoneId.of(to);
            var departTime = departure.atZone(fromZone);
            var arrivalTime = departure.plusHours(duration).atZone(fromZone).withZoneSameInstant(toZone);
            return String.format("Flight departs at %s and arrives at %s%n", departTime, arrivalTime);
        }
    }

}
