package TerminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class Mapping {

    public static void main(String[] args) {
        List<String> studentNames = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));
        System.out.println("names of students are: " + studentNames);
    }
}
