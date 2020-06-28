package TerminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinbyMaxby {

    private static Optional<Student> minBy() {
        Optional<Student> worstStudent = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
        return worstStudent;
    }

    private static Optional<Student> maxBy() {
        // maxby can be used exactly the same with minBy - together with comparator
        // Is this problem, we can also use reduce to solve
        Optional<Student> bestStudent = StudentDataBase.getAllStudents()
                .stream()
                .reduce((student, student2) -> {
                    if (student.getGpa() >= student2.getGpa()) return student;
                    else return student2;
                });
        return bestStudent;
    }

    public static void main(String[] args) {
        System.out.println("Worst student is: " + (minBy().isPresent() ? minBy().get() : "none"));
        System.out.println("Best student is: " + (maxBy().isPresent() ? maxBy().get() : "none"));
    }
}
