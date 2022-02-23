package dates;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormatDatesDemo {

    // https://www.baeldung.com/java-datetimeformatter
    // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
    public static void main(String[] args) {

        // 1) predefined formatters as constants
        var date = LocalDateTime.now();
        System.out.println(date);


        var isoDate = DateTimeFormatter.ISO_DATE.format(date);
        System.out.println(isoDate);

        var isoDateTime = DateTimeFormatter.BASIC_ISO_DATE.format(date);
        System.out.println(isoDateTime);

        // UnsupportedTemporalTypeException
//        System.out.println(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(date));


        // 2) static factor methods
        System.out.println("Static Factory Methods");
        var someDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(date);
        System.out.println(someDate);

        // prints with default locale
        var someDate2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(date);
        System.out.println(someDate2);

        // 3) withLocale()
        System.out.println("With Locale");
        var someDate3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(new Locale("en", "US")).format(date);
        System.out.println(someDate3);

        var someDate4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(new Locale("fr", "FR")).format(date);
        System.out.println(someDate4);

        // 4) .ofPattern()
        System.out.println(".ofPattern()");
        String europeanPattern = "dd---MM---yyyy";
        String usPattern = "MM.dd.yyyy";
        var fixedDate = LocalDate.of(2022, 10, 31);

        System.out.println(DateTimeFormatter.ofPattern(europeanPattern)
                                    .format(fixedDate));
        System.out.println(DateTimeFormatter.ofPattern(usPattern)
                .format(fixedDate));

    }
}
