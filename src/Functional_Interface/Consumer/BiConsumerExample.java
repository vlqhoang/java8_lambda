package Functional_Interface.Consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        // simple example
        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println("First param: " + a + " ,and second param: " + b);
        Map<String, String> map = new HashMap<>();
        map.put("hello1", "1");
        map.put("hello2", "2");
        map.forEach(biConsumer);

        System.out.println("==========================================");

        // chaining example
        BiConsumer<Integer, Integer> multiply = (x1, x2) -> System.out.println("Multiplication is: " + x1 * x2);
        BiConsumer<Integer, Integer> division = (x1, x2) -> System.out.println("Division is: " + x1 / x2);

        multiply.andThen(division).accept(4, 2);
    }
}
