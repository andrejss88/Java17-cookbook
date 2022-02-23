package numbers.formatting;

/**
 * https://docs.oracle.com/javase/tutorial/i18n/format/choiceFormat.html
 *
 * https://stackoverflow.com/questions/14326653/java-internationalization-i18n-with-proper-plurals
 *
 * https://stuartgunter.wordpress.com/2011/08/09/java-i18n-pluralisation-using-choiceformat/
 * https://stuartgunter.wordpress.com/2011/08/14/even-better-java-i18n-pluralisation-using-icu4j/
 */
public class FormattingWithPlurals {

    public static void main(String[] args) {

        report(0); report(1); report(2);

    }

    // start simple
    public static void report(int n) {
        String ending = (n == 1 ? "" : "s");
        System.out.println("We used " + n + " item" + ending);
    }
}
