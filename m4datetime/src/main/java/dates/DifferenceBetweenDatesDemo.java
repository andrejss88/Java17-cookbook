package dates;

import java.time.LocalDate;
import java.time.Period;

/**
 * https://github.com/PacktPublishing/Java-Coding-Problems/tree/master/Chapter03/P74_CalculatingAge
 * -> 4-15 p.89 of Java 9 Recipes
 */
public class DifferenceBetweenDatesDemo {

    // suppose we want to calculate the age of a person
    // zoneIDs are irrelevant
    public static void main(String[] args) {
        LocalDate startLocalDate = LocalDate.of(2010, 11, 2);
        LocalDate endLocalDate = LocalDate.now();


        Period age = Period.between(startLocalDate, endLocalDate);
        System.out.println(age.getYears() + "y "
                + age.getMonths() + "m "    // not the total cumulative months,
                + age.getDays() + "d");

        if(age.getYears() < 18) {
            System.out.println("Sorry, you can't buy this age-restricted item");
        }
    }
}
