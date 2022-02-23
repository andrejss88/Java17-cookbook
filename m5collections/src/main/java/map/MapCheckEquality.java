package map;

import java.util.Map;

/**
 * https://github.com/PacktPublishing/Java-Coding-Problems/tree/master/Chapter05/P114_CompareMaps
 */
public class MapCheckEquality {

    public static void main(String[] args) {

        // 1 - equals works with built-in types, where equals is implemented properly
        Map<Integer, String> mapOne = Map.of(1, "Java", 2, "C#",3, "JavaScript");
        Map<Integer, String> mapTwo = Map.of(1, "Java", 2, "C#",3, "JavaScript");
        Map<Integer, String> mapThree = Map.of(1, "Java", 2, "C#",4, "JavaScript");

        System.out.println(mapOne.equals(mapTwo));  // true
        System.out.println(mapOne.equals(mapThree)); // false

        // 2 - doesn't work unless we implement the equals
        Map<Integer, Language> mapLangOne = Map.of(1, new Language("Java"));
        Map<Integer, Language> mapLangTwo = Map.of(1, new Language("Java"));

        System.out.println("Class without equals: " +  mapLangOne.equals(mapLangTwo));

        // 3 - records implement equals using the fields

        Map<Integer, LanguageRecord> mapLangRecordOne = Map.of(1, new LanguageRecord("Java"));
        Map<Integer, LanguageRecord> mapLangRecordTwo = Map.of(1, new LanguageRecord("Java"));
        System.out.println("With records: " + mapLangRecordOne.equals(mapLangRecordTwo));

        // 4 - finally - equality based on values only
        System.out.println("By values only: " + areMapsEqual(mapLangOne, mapLangTwo));

    }

    private static boolean areMapsEqual(Map<Integer, Language> first, Map<Integer, Language> second) {
        if (first.size() != second.size()) {
            return false;
        }

        return first.entrySet().stream()
                .allMatch(e -> e.getValue().getName().equals(second.get(e.getKey()).getName()));
    }

    static class Language {
        String name;

        public Language(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        // equals() and hashCode not overriden
    }
    record LanguageRecord(String name) { }

}
