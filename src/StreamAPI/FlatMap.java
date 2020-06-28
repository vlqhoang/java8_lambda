package StreamAPI;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * flatMap operation is the same as map, different thing is that flatMap is used in the case
 * where each element in the stream represents multiple elements.
 */
public class FlatMap {

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();
        Set<String> studentActivities = studentList.stream()
                .map(Student::getActivities) // Stream List<String>
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println(studentActivities);
    }
}
