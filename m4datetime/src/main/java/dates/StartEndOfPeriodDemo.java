package dates;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * https://github.com/PacktPublishing/Java-Coding-Problems/tree/master/Chapter03/P70_FindFirstAndLastDayOfMonth/src/modern/challenge
 */
public class StartEndOfPeriodDemo {

    public static void main(String[] args) {

        // +  HURRY, Sale ends at the end of the month!, x Days remaining
        LocalDate today = LocalDate.now();
        LocalDate endOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());

        System.out.println(today);
        System.out.println(endOfMonth);

        String message = String.format("Hurry! The sale ends at the end of the month, %s day(s) remaining!", endOfMonth.getDayOfMonth() - today.getDayOfMonth());
        System.out.println(message);
        // + talk about TemporalAdjusters interface and all the useful things it provides, incl. .firstDayOfMonth()
    }
}
