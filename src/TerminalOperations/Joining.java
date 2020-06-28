package TerminalOperations;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

/**
 * joining() performs the String concatenation on the stream elements
 * There are 3 overloaded method: pure concatenation / concatenation with delimiter / delimiter with prefix and suffix
 */
public class Joining {

    public static String joiningStudentNames() {
        return StudentDataBase.getAllStudents()
                .stream().map(Student::getName)
                // .collect(Collectors.joining("-"));
                .collect(Collectors.joining("-", "(", ")")); // overload with prefix and suffix
    }

    public static void main(String[] args) {
        System.out.println("Result when joining names: ");
        System.out.println(joiningStudentNames());
    }
}
