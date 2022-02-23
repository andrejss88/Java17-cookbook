package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://stackoverflow.com/questions/2607289/converting-array-to-list-in-java
 * https://stackoverflow.com/questions/4042434/converting-arrayliststring-to-string-in-java
 */
public class ConvertToFromArray {

    public static void main(String[] args) {

        // 1- works with objects
        String[] stringsArr = {"1", "2", "3"};
        List<String> stringList = new ArrayList<String>(List.of(stringsArr));

        System.out.println("List Before: " + stringList);
        stringList.add("4");
        stringList.add("5");
        stringList.remove("1");
        System.out.println("List After: " + stringList);

        String[] strings = stringList.toArray(String[]::new);
        System.out.println("Back to array: " + Arrays.toString(strings));

//         Can't do these - Arrays.asList(stringsArr); or List.of(stringsArr);

        // 2- explain and demo why
        int[] intArr = {1, 2, 3};
//        List<Integer> intList =  Arrays.asList(intArr); // doesn't compile

        // 2.1 - declare as Integer
        Integer[] integerArr = {1, 2, 3};
//        List<Integer> intList = Arrays.asList(integerArr);

        // 2.2 - convert - and modify while streaming
        int[] ints = {1, 2, 3, 4, 5};
        List<Integer> intList2 =Arrays.stream(ints)
                .filter( n -> n < 4)
                .map( n -> n * 2) // double all the nums
                .boxed()
                .toList();




    }
}
