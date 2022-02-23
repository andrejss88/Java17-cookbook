package list;

import java.util.*;

/**
 * https://stackoverflow.com/questions/2607289/converting-array-to-list-in-java
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        // 1) start with this
        List<Integer> ints = List.of(20, 30, 40, 40, 50, 50);
        Set<Integer> intSet = new HashSet<>(ints);
        System.out.println(intSet);

        // 2) then: + same for array, but first must convert array to list
        // place list to set

        List<Person> personList = new ArrayList<>(List.of(new Person("Jon"), new Person("Jon")));
        Set<Person> personSet = new HashSet<>(personList);
        System.out.println(personSet);
    }

    static class Person {

        String name;

        public Person(String name) {
            this.name = name;
        }

//        @Override
//        public boolean equals(Object obj) {
//            final Person other = (Person) obj;
//            return this.name.equals(other.name);
//        }
//
//        @Override
//        public int hashCode() {
//            int hash = 3;
//            hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
//            hash = 53 * hash;
//            return hash;
//        }

        @Override
        public String toString() {
            return name;
        }

    }
}
