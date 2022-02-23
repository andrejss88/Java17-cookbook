package list;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReplaceElementInAList {

    public static void main(String[] args) {

        // double example
        List<Double> doubles = new ArrayList<>(List.of(10.525, 20.567, 30.789));

        UnaryOperator<Double> operator =  num -> BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
        UnaryOperator<Double> operator2 = num -> num < 30 ? BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_EVEN).doubleValue() : num;
        UnaryOperator<Double> operator3 = num -> {
            if(num < 30) {
                return BigDecimal.valueOf(num).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            }
            return num;
        };

        doubles.replaceAll(operator);
        System.out.println(doubles);

        List<String> strings = new ArrayList<>(List.of("mary", "jake", "thomas"));

        strings.replaceAll( str -> str.substring(0, 1).toUpperCase() + str.substring(1));
        System.out.println(strings);

        // as always - prefer streams and create new collections
        strings.stream()
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                .forEach(System.out::println);

        List<String> streamedStrings = strings.stream()
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                .toList();
    }


}
