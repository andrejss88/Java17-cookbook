package list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.Comparator.comparing;
import static java.util.Comparator.nullsLast;

/**
 * https://itsallbinary.com/java-8-comparator-improvements-easy-null-handling-comparator-chaining-reversal/
 */
public class SortingAdvanced {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("Jake", 28),
                new Person("Don", 30),
                new Person("Andy", 40),
                new Person("John", 36),
                new Person("John", 35)
        ));

        // 1- can't do that, neither on Integer
//        personList.sort(String::compareTo);
//        personList.sort(Person::name);

        // 2 - simpler sorting
        personList.sort(comparing(Person::age));
        System.out.println("Compared by age: " + personList);


        personList.sort(comparing(Person::name));
        System.out.println("Compared by name: " + personList);


        personList.sort(comparing(Person::name).reversed());
        System.out.println("Reversed by name: " + personList);

        // 3 - combined
        personList.sort(comparing(Person::age).thenComparing(Person::name));
        System.out.println("By age then by name: " + personList);


        // 4 - handling nulls
        List<Person> personListWithNulls = new ArrayList<>(Arrays.asList(
                null,
                new Person("Jake", 28),
                new Person("Don", 30),
                new Person("Andy", 40),
                new Person("John", 36),
                new Person("John", 35),
                null
        ));

        // NPE
//        personListWithNulls.sort(Comparator.comparing(Person::name));
        personListWithNulls.sort(nullsFirst(comparing(Person::name)));
        System.out.println(personListWithNulls);
        // finally, briefly show the streams way
        // extra useful if it's part of an operation - filter, map, then sort

        // 5 - The stream way
        System.out.println("The stream way");
        personListWithNulls.stream()
                .filter(p -> p != null)
                .sorted(Comparator.comparing(Person::age))
                .forEach(System.out::print);


        // Array
        Person[] personArr = {
                null,
                new Person("Jake", 28),
                new Person("Don", 30),
                new Person("Andy", 40),
                new Person("John", 35),
                null
        };
        Arrays.sort(personArr, nullsLast(comparing(Person::name).thenComparing(Person::age)));
        Stream.of(personArr)
                .forEach(System.out::print);
    }

    record Person(String name, int age) {

        @Override
        public String toString() {
            return  name + "=" + age;
        }
    }
}
