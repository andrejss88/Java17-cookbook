package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapOverview {

    public static void main(String[] args) {


        Map<Integer, String> map = Map.of(
                1, "Java",
                2, "C#",
                3, "JavaScript",
                4, "JavaScript"
        );

        Map<Integer, String> mutableMap = new HashMap<>(Map.of(
                1, "Java",
                2, "C#",
                3, "JavaScript",
                4, "JavaScript"
        ));

        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.values());


        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            if(entry.getKey() < 2) {
                String modifiedValue = entry.getValue().toUpperCase();
                // do things
            }
        }

        for(String value : map.values()) {
            if("Java".equals(value)) {
                // do things
            }
        }



    }
}
