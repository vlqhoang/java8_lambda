package TerminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * GroupingBy takes in function and then perform grouping data base on provided function's return
 * always return a map Map<K, V>. V is usually a list of grouped data but it can be customized by providing collection downstream
 */
public class GroupingBy {

    private static void groupStudentByGender() {
        Map<String, List<String>> groupedGender = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(
                        Student::getGender,
                        Collectors.mapping(Student::getName, Collectors.toList())
                ));
        System.out.println("Grouped gender is: " + groupedGender);

        Map<String, List<String>> groupedGender2 = StudentDataBase.getAllStudents()
                .parallelStream()
                .collect(Collectors.groupingBy(
                        Student::getGender,
                        Collector.of(
                                ArrayList::new,
                                (list, s) -> list.add(s.getName()),
                                (list1, list2) -> {
                                    list1.addAll(list2);
                                    return list1;
                                }
                        )
                ));
        System.out.println("Grouped gender is: " + groupedGender2);
    }

    private static void twoLevelGrouping() {
        // in each grade, classify student names into 2 group (Good vs Average)
        Map<Integer, Map<String, List<String>>> twoLevelGrouping = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(
                                student -> student.getGpa() >= 3.8 ? "GOOD" : "AVERAGE",
                                Collectors.mapping(Student::getName, Collectors.toList())
                        )));

        System.out.println(twoLevelGrouping);
    }

    /**
     * We could use minBy / maxBy / reduce but the given result is only 1 single object
     * Sometimes, there is a task requesting dev to show grouped max / min data
     */
    private static void bestStudentNameInEachGrade() {
        Map<Integer, String> bestStudentsMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.collectingAndThen( // use this when you need to perform extra action
                                Collectors.maxBy(Comparator.comparing(Student::getGpa)), // returning Optional<Student>
                                (optionalStudent) -> optionalStudent.isPresent() ? optionalStudent.get().getName() : ""
                        )
                ));
        System.out.println(bestStudentsMap);
    }

    public static void main(String[] args) {

        // 1 level grouping
        groupStudentByGender();

        System.out.println("=====================================");

        // 2 level grouping
        twoLevelGrouping();

        System.out.println("=====================================");

        // Using groupingBy in practical
        bestStudentNameInEachGrade();
    }
}
