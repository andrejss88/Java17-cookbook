package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeCopyOfList {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(List.of("a", "b"));

        // 4) and once you're done adding, consider making it unmod again
        List<String> strings2 = Collections.unmodifiableList(strings);
        List<String> strings3 = List.copyOf(strings);
        System.out.println(strings2);

        strings.add("d");
        System.out.println(strings2); // oops! strings2 is actually a view, a shallow copy!
        System.out.println(strings3); // deep copy
    }
}
