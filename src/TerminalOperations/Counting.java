package TerminalOperations;

import data.StudentDataBase;

import java.util.stream.Collectors;

public class Counting {

    public static void main(String[] args) {

        Long totalStudent = StudentDataBase.getAllStudents().stream().collect(Collectors.counting());
        System.out.println("Total student: " + totalStudent);

        Long totalGoodStudent = StudentDataBase.getAllStudents()
                .stream().filter(student -> student.getGpa() > 3.9)
                .collect(Collectors.counting());
        System.out.println("Total good student: " + totalGoodStudent);
    }
}
