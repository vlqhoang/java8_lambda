package Functional_Interface.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInterfaceExample {

    static Function<String, String> addSomeString = (name) -> name.toUpperCase().concat("_defaultString");
    static Function<String, List<String>> strToList = (name) -> {
        List<String> list = new ArrayList<>();
        list.add(name);
        return list;
    };

    public static void main(String[] args) {

        // Chaining functions from left to right, the result of the first function will be passed to the second function and so on ..
        List<String> result = addSomeString.andThen(strToList).apply("John Wick");
        System.out.println(result);
    }
}
