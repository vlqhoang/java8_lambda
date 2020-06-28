package TerminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

public class SumAndAvg {

    private static double totalGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingDouble(Student::getGpa));
    }

    private static double averageGPA() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingDouble(Student::getGpa));
    }

    public static void main(String[] args) {
        System.out.println("Total gpa: " + totalGpa());
        System.out.println("Average gpa: " + averageGPA());
    }
}
