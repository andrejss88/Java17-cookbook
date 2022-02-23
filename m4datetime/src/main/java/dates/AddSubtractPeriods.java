package dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * https://github.com/PacktPublishing/Java-Coding-Problems/tree/master/Chapter03/P65_AddingSubtractingToFromDateTime/src/modern/challenge
 * + 6.6 -> https://learning.oreilly.com/library/view/java-cookbook-4th/9781492072577/ch06.html#javacook-dates-SECT-7
 */
public class AddSubtractPeriods {

//    + add a story - book an appointment "1 week from now"
//    and print the result back to the user with a message "Your scheduled app is in X {period} on n-th"
    public static void main(String[] args) {

        var date = LocalDate.now();

        // 1) the basics - use methods provided
        System.out.println(date);
        System.out.println(date.plusDays(1));
        System.out.println(date.plusWeeks(1));
        System.out.println(date.plusMonths(3));
        System.out.println(date.plusYears(5));

        System.out.printf("Your scheduled appointment will take place in %s days", date.plusMonths(1).getDayOfYear() - date.getDayOfYear());
        System.out.println();
//        date.minusDays(5);
        // 2) want more? like decades? use .plus()
        System.out.println(date.plus(1, ChronoUnit.DECADES));
        System.out.println(LocalDateTime.now().plus(1, ChronoUnit.MINUTES));
        System.out.println(date.plus(1, ChronoUnit.MINUTES)); // UnsupportedTemporalTypeException, makes sense


        // 3) Want to add/subtract several chronounits (months/days) at the same time?
        Period period = Period.of(0, 1,5);
        System.out.println(date.plus(period));
    }
}

