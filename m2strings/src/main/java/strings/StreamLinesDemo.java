package strings;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamLinesDemo {

    public static void main(String[] args) {

        String str = "To whom it may concern \n" +
                "I wish you a good day \n" +
                "Sincerely \n" +
                "Me";

        Stream<String> lines = str.lines();

//        lines.forEach(System.out::println);

        // add line numbers
        final AtomicInteger i = new AtomicInteger(1);
        lines.forEach(line -> System.out.println(i.getAndIncrement() + " " + line));
    }
}
