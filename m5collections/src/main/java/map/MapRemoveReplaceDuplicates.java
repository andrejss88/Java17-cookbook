package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * https://github.com/PacktPublishing/Java-Coding-Problems/tree/master/Chapter05/P112_RemoveFromMap
 * + 113
 */
public class MapRemoveReplaceDuplicates {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>(Map.of(
                1, "Java",
                2, "C#",
                3, "JavaScript",
                4, "Python",
                5, "Go",
                6, "Kotlin"
        ));

        // 1 - Remove
        map.remove(1);
        System.out.println("Simple remove: "  + map);
        map.entrySet().removeIf(entry -> entry.getValue().equals("C#"));
        System.out.println("Removed by checking value: " + map);

        map.entrySet().removeIf(entry -> entry.getKey().equals(3));
        System.out.println("Removed by checking key: " + map);

        // 2 - Replace
        map.replace(4, "Go");
        System.out.println("Simple replace: " + map);

        // 3 - Complex replace
        // Represents a function that accepts two arguments and produces a result
        BiFunction<Integer, String, String> replaceGoWithJava = (k, v) -> {
            if("Go".equals(v)) {
                return "Java";
            }
            return v;
        };
        map.replaceAll(replaceGoWithJava);
        System.out.println(map);

    }
}
