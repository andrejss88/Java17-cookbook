package demoapp;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DemoAppOne {

    /**
     * App 1: Time left this year (X days, Y whole weeks, Z whole months left until the end of 2022)
     */
    public static void main(String[] args) {

        var today = LocalDate.now();
        var lastDay = today.with(TemporalAdjusters.lastDayOfYear());

        // doesn't work as smoothly
        var period = Period.between(today, lastDay);
        System.out.printf("Only %s months left till EOY", period.getMonths());
        System.out.printf("\nOnly %s days left till EOY", period.getDays());
//        System.out.printf("\nOnly %s days left till EOY", period.get(ChronoUnit.WEEKS));

        // this works!
        System.out.println();
        System.out.println("With Until");

        System.out.printf("\nOnly %s whole months left till EOY", today.until(lastDay, ChronoUnit.MONTHS));
        System.out.printf("\nOnly %s whole weeks left till EOY", today.until(lastDay, ChronoUnit.WEEKS));
        System.out.printf("\nOnly %s whole days left till EOY", today.until(lastDay, ChronoUnit.DAYS));



    }
}
