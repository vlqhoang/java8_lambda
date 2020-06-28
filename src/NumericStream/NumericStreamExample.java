package NumericStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamExample {

    public static void main(String[] args) {

        System.out.println("================Range example===================");
        System.out.println("range");
        IntStream.range(1,50).forEach(value -> System.out.print(value + ","));
        System.out.println();
        System.out.println("range closed");
        LongStream.rangeClosed(1,50).forEach(value -> System.out.print(value + ","));

        System.out.println();
        System.out.println("============= Aggregation ================");
        System.out.println("Sum from 1 to 50: " + IntStream.rangeClosed(1, 50).sum());
        System.out.println("Max from 1 to 50: " + IntStream.rangeClosed(1, 50).max());
        System.out.println("Min from 1 to 50: " + IntStream.rangeClosed(1, 50).min());
        System.out.println("Avg from 1 to 50: " + IntStream.rangeClosed(1, 50).average());

        System.out.println("============= Unboxing =============");
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        IntStream stream1To6 = integerList.stream().mapToInt(Integer::valueOf);
        System.out.println("Sum from 1 to 6: " + stream1To6.sum());
    }
}
