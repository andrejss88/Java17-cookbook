package dates;

import java.time.LocalDate;

/**
 * https://learning.oreilly.com/library/view/java-9-recipes/9781484219751/A323910_3_En_4_Chapter.html
 * -> 4-14 of Java 9 Recipes
 */
public class CompareDatesDemo {

    // think of a context (story)
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2021, 12, 30);
        LocalDate now = LocalDate.now();


        System.out.println(date1.isAfter(now) ? "Not Yet!" : "Already past!");
        System.out.println(date1.isEqual(now));
        // .isBefore() and isEqual()

    }
}
