package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://stackoverflow.com/questions/2762093/java-compare-two-lists
 */
public class FindDuplicatesAndSimilarElements {


    public static void main(String[] args) {

        List<String> listOne = List.of("USA", "Brazil", "USA", "France", "Egypt", "India", "Japan");

        List<String> listTwo = List.of("USA", "Brazil", "Germany", "Australia");


        // find similar
        Set<String> similar = new HashSet<>(listOne);
        // JavaDoc: this operation effectively modifies this set so that its value is the intersection of the two sets
        similar.retainAll(listTwo);
        System.out.println(similar);

        // find different
        Set<String> different = new HashSet<>();
        different.addAll(listOne); // different = 7
        different.addAll(listTwo); // different = 8 (only non-duplicates added)
        different.removeAll(similar); // different = 6 - removes similar
        System.out.println(different);


    }
}
