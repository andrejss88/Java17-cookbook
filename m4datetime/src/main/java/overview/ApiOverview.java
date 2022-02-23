package overview;

import java.time.*;

/**
 * https://www.oreilly.com/library/view/java-9-recipes/9781484219751/
 * https://www.oreilly.com/library/view/java-coding-problems/9781789801415/
 */
public class ApiOverview {

    public static void main(String[] args) {

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(Instant.now());
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(System.currentTimeMillis());


        System.out.println(ZonedDateTime.now());

    }
}
