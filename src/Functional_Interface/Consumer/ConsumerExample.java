package Functional_Interface.Consumer;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        // simple consumer
        Consumer<String> consumer1 = (s) -> System.out.println(s.toUpperCase());
        consumer1.accept("Java 8");

        System.out.println("==========================================");
        printAllStudents();

        System.out.println("==========================================");
        printNameAndActivities();
    }

    /**
     * Example 2 - Using consumer interface
     */
    private static void printAllStudents() {
        // direct
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> System.out.println(student.toString())); // inline lambda - directly implementing a consumer interface

        // indirect
        Consumer<Student> consumer2 = (student) -> System.out.println(student.toString());
        students.forEach(consumer2); // passing in implementation of consumer interface
    }

    /**
     * Example 2 - Chaining consumers
     */
    private static void printNameAndActivities() {
        System.out.println("Example of chaining:...");
        Consumer<Student> printNameConsumer = student -> System.out.print(student.getName());
        Consumer<Student> printActivitiesConsumer = student -> System.out.println(student.getActivities());

        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(printNameConsumer.andThen(printActivitiesConsumer));
    }
}
