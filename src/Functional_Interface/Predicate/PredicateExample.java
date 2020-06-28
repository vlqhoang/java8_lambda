package Functional_Interface.Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    // lambda expression -> implementing abstract method 'test'
    static Predicate<String> isStartWithLetterG = (name) -> name.startsWith("G");
    static Predicate<Integer> isOver20 = (number) -> number > 20;
    static Predicate<Integer> isEven = (number) -> number % 2 == 0;

    public static void main(String args[]) {
        // create a list of strings
        List<String> names = Arrays.asList("Geek","GeeksQuiz","g1","QA","Geek2");
        List<Integer> ages = Arrays.asList(20, 15, 1, 19, 21, 22);

        names.forEach(name -> {
            if (isStartWithLetterG.test(name)) System.out.println(name);
        });

        System.out.println("=============================");
        predicateAnd(ages);

        System.out.println("=============================");
        predicateOr(ages);

        System.out.println("=============================");
        predicateOrNegated(ages);


    }

    /**
     * Chaining predicate as 'AND' example
     */
    private static void predicateAnd(List<Integer> ages) {
        System.out.println("Predicate AND");
        ages.forEach(age -> {
            System.out.println("Testing age " + age + " : " + isOver20.and(isEven).test(age));
        });
    }

    /**
     * Chaining predicate as 'OR' example
     */
    private static void predicateOr(List<Integer> ages) {
        System.out.println("Predicate OR");
        ages.forEach(age -> {
            System.out.println("Testing age " + age + " : " + isOver20.or(isEven).test(age));
        });
    }

    /**
     * Chaining predicate with 'negate' example
     */
    private static void predicateOrNegated(List<Integer> ages) {
        System.out.println("Predicate OR negated");
        ages.forEach(age -> {
            System.out.println("Testing age " + age + " : " + isOver20.or(isEven).negate().test(age));
        });
    }
}
