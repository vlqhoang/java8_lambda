package StreamAPI;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Map {

    public static void main(String[] args) {
        Function<Student, String> getNameFromStudent = Student::getName;
        Function<String, String> performUpperCase = String::toUpperCase;
        Comparator<String> comparator = String::compareToIgnoreCase;

        List<String> studentNames = StudentDataBase.getAllStudents().stream()
                .map(getNameFromStudent.andThen(performUpperCase)) // map method takes an implementation of function interface
                .sorted(comparator.reversed()) // sort names in desc order
                .collect(Collectors.toList());
        System.out.println(studentNames);
    }
}
