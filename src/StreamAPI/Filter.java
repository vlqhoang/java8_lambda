package StreamAPI;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();
        Map<String, List<String>> studentMap = studentList.stream() // stream
                // lambda predicate
                .filter(student -> student.getGpa() > 2)
                // method reference implementing functional interface - lambda shorthand syntax
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(studentMap);
    }
}