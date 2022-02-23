package datetime;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * https://github.com/PacktPublishing/Java-Coding-Problems/blob/master/Chapter03/P75_StartAndEndOfDay/src/modern/challenge/Main.java
 */
public class StartEndDay {

    public static void main(String[] args) throws InterruptedException {
        
        // sale ends at midnight, X hours left! (every user will see a different time)

            LocalDate today = LocalDate.now();
            LocalTime now = LocalTime.now();
            LocalDateTime nowToday = LocalDateTime.of(today, now);
            LocalDateTime midnightToday = LocalDateTime.of(today, LocalTime.MAX);

            System.out.println(nowToday);
            System.out.println(midnightToday);
            String message = String.format("Hurry, sale ends at midnight, time left: %s hours, %s minutes, %s seconds",
                    midnightToday.getHour() - nowToday.getHour(),
                    midnightToday.getMinute() - nowToday.getMinute(),
                    midnightToday.getSecond() - nowToday.getSecond());

            System.out.println(message);

//        while(true){             Thread.sleep(1000); }

            // + same can be done with ZonedDateTime
    }
}
