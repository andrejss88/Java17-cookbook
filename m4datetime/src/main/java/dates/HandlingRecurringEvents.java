package dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

/**
 * 6.7 Handling Recurring Events
 * https://learning.oreilly.com/library/view/java-cookbook-4th/9781492072577/ch06.html#javacook-dates-SECT-7
 * https://stackoverflow.com/questions/20527998/get-all-fridays-in-a-date-range-in-java
 */
public class HandlingRecurringEvents {

    public static void main(String[] args) {

        // Task - meeting every Friday. Print all remaining meetings for the month

        var start = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        var stop = LocalDate.now().with(TemporalAdjusters.lastDayOfYear());
        var firstFriday = start.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        System.out.println("Starting date " + start);
        System.out.println("End date " + stop);

        List<LocalDate> fridays = new ArrayList<>();
        // Loop and collect until stop date
        while ((firstFriday.isBefore(stop))) {
            fridays.add(firstFriday);
            firstFriday = firstFriday.plusWeeks(1);  // Move to the next Friday
        }
        System.out.printf("From %s to %s, Fridays will be %s%n", start, stop, fridays);

        // things get complicated with "every second Friday, every third Friday except bank Holidays, etc."
    }
}
