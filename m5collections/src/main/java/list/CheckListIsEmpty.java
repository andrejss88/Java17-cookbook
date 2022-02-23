package list;

import java.util.List;

public class CheckListIsEmpty {

    public static void main(String[] args) {

        int[] intArray = {};
        System.out.println(intArray.length == 0);

        List<Integer> intList = List.of(1, 2 , 3);

        // no!
        System.out.println(intList.size() == 0);

        // yes
        System.out.println(intList.isEmpty());

        if(intList.isEmpty()) {
            System.out.println("Is empty");
        }

    }
}
