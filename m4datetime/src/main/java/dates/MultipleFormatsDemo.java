package dates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;


/**
 * https://stackoverflow.com/questions/30135025/java-date-parsing-with-microsecond-or-nanosecond-accuracy/59546290#59546290
 */
public class MultipleFormatsDemo {

    public static void main(String[] args) {

        final var formatBuilder = new DateTimeFormatterBuilder();
        formatBuilder.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyy"));
//                .appendOptional(DateTimeFormatter.ofPattern("MM-dd-yyy"));
        // careful not to append too many patterns that may conflict e.g. 1/2/2022

        var formatter = formatBuilder.toFormatter();

        System.out.println(LocalDate.parse("2022-07-22", formatter)); // OK
        System.out.println(LocalDate.parse("22-07-2022", formatter)); // OK
        System.out.println(LocalDate.parse("07-22-2022", formatter)); //fail

        // + add quick try-catch and translate the exception

    }
}
