package TerminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Partition takes in predicate and then perform partition data base on provided predicate
 * always return a map Map<K, V>. V is usually a list of grouped data but it can be customized by providing collection downstream
 */
public class Partitioning {

    static Predicate<Student> isGPAOver4 = (student) -> student.getGpa() >= 4;

    private static void partitionBaseOnGPA() {
        Map<Boolean, List<Student>> partitionedGPA = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(isGPAOver4));

        System.out.println("Students having gpa > 4: ..");
        System.out.println(partitionedGPA.get(true)); // Key - > true: predicate return true
    }

    private static void partitionNamesOnGPA() {
        Map<Boolean, List<String>> partitionedNameOnGPA = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(isGPAOver4,
                        Collectors.mapping(
                                Student::getName,
                                Collectors.toList()
                        )
                ));
        System.out.println("Students having gpa < 4: ..");
        System.out.println(partitionedNameOnGPA.get(false)); // Key - > false: predicate return false
    }

    private static void theBestStudentOfEachPartition() {
        Map<Boolean, Student> bestStudentOfEach = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(isGPAOver4,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Student::getGpa).thenComparing(Student::getGradeLevel)),
                                Optional::get
                        )
                ));
        System.out.println("Best student under 4 GPA: ");
        System.out.println(bestStudentOfEach.get(false));
        System.out.println("Best student over 4 GPA: ");
        System.out.println(bestStudentOfEach.get(true));
    }

    public static void main(String[] args) {
        partitionBaseOnGPA();
        System.out.println("=======================");
        partitionNamesOnGPA();

        System.out.println("=======================");
        theBestStudentOfEachPartition();
    }
}
