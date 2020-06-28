package StreamAPI;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Reduce is classified as a terminal operation alongside 'collect'.
 * Used to reduce a stream to a single value
 */
public class Reduce {

    private static Optional<Integer> multiplication(List<Integer> integerList) {
        return integerList.stream()
                .reduce((number1, number2) -> number1 * number2);
    }

    /**
     * Using reduce, we can implement logic to get min / max value
     */
    private static Optional<Student> getHighestGPA(List<Student> studentList) {
        return studentList.stream()
                .reduce((student1, student2) -> {
                    if (student1.getGpa() >= student2.getGpa()) return student1;
                    else return student2;
                });
    }

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 5, 7);
        System.out.println("Reduce list by multiplication:");
        System.out.println(multiplication(integerList));

        List<Student> allStudents = StudentDataBase.getAllStudents();
        Optional<Student> highestGPA = getHighestGPA(allStudents);
        highestGPA.ifPresent(student -> System.out.println("Highest GPA student is: " + student));
    }
}
