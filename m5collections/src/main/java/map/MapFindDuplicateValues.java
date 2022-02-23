package map;

import java.util.*;

public class MapFindDuplicateValues {

    public static void main(String[] args) {

        Map<Integer, String> map = Map.of(
                1, "Java",
                2, "C#",
                3, "C#",
                4, "JavaScript",
                5, "JavaScript"
        );

        System.out.println(mapHasDuplicates(map));

        System.out.println(collectDuplicateValues(map));
    }


    // 1
    public static <K, V> boolean mapHasDuplicates(Map<K, V> map) {
        Collection<V> valuesList = map.values();
        Set<V> valuesSet = new HashSet<V>(map.values());
        return !(valuesList.size() == valuesSet.size());
    }

    // 2
    private static <K, V> List<V> collectDuplicateValues(Map<K, V> map) {
        return map.values().stream()
                // Returns the number of elements in the specified collection equal to the specified object
                .filter(value -> Collections.frequency(map.values(), value) > 1)
//                .distinct() //
                .toList();
    }
}
