package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://stackoverflow.com/questions/46579074/what-is-the-difference-between-list-of-and-arrays-aslist
public class CreateListAndAddElement {


    public static void main(String[] args) {

        // 1) This should be good, right?
        List<String> strings = List.of("a", "b");
        List<String> strings2 = Arrays.asList("a", "b");
//        strings.add("c"); // UnsupportedOperationException

        // 2) explain Mod vs UnMod
        // 3) Old-style
        List<String> strings3 = new ArrayList<>(Arrays.asList("a", "b"));
        strings2.add("c");
        System.out.println(strings2);


    }
}
