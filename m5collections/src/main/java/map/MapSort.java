package map;

import java.util.*;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.toMap;

/**
 * https://github.com/PacktPublishing/Java-Coding-Problems/blob/master/Chapter05/P117_SortMap/src/modern/challenge/Maps.java
 */
public class MapSort {
    // https://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-treemap
    // https://stackoverflow.com/questions/47357126/why-does-a-hashmap-sometimes-print-in-natural-order#:~:text=When%20you%20print%20a%20HashMap,the%20same%20as%20key%20order.
    public static void main(String[] args) {

        Map<Integer, String> mapOne = Map.of(20, "Java", 30, "C#",10, "JavaScript", 40 , "Python"); // new HashMap<>();
        System.out.println(mapOne);

        // 1 - Place your map into a TreeMap
        // ordered according to the natural ordering of its keys.
        // All keys inserted into the new map must implement the Comparable interface
        System.out.println("TreeMap: " + new TreeMap<>(mapOne));

        // 2 - Keys must implement the Comparable interface
        Map<Language, String> mapTwo = Map.of(new Language(), "Java", new Language(), "C#",new Language(), "Go");
//        System.out.println(new TreeMap<>(mapTwo)); // ClassCastException - cannot be cast to class java.lang.Comparable


        // 3 - Custom solution
        System.out.println("Sort by value stream: " + sortByValueStream(mapTwo, Comparator.naturalOrder()));
        System.out.println("Sort by value stream reverse: " + sortByValueStream(mapTwo, Comparator.reverseOrder()));
    }

    static class Language {
        String name;

        @Override
        public String toString() {
            return "Language";
        }
    }

    public static <K, V> Map<K, V> sortByValueStream(Map<K, V> map, Comparator<? super V> c) {
        Objects.requireNonNull(map, "Map cannot be null");

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(c)) // or comparingByValue
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        // LinkedHashMap - keep the order of insertion
                        (v1, v2) -> v1, LinkedHashMap::new));
    }
}
