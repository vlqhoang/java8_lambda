package ParallelStream;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    /**
     * summing ints sequentially
     */
    private static long checkPerformanceSequentialStream() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            IntStream.rangeClosed(1, 100000).sum();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * summing ints in parallel
     */
    private static long checkPerformanceParallelStream() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            IntStream.rangeClosed(1, 100000).parallel().sum();
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long checkPerformanceSequentialStream2() {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted() // stateless
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long checkPerformanceParallelStream2() {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted() // stateful
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        System.out.println("Number of thread to process: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Time took for executing sequential stream is: " + checkPerformanceSequentialStream());
        System.out.println("Time took for executing parallel stream is: " + checkPerformanceParallelStream());

        System.out.println("================");
        System.out.println("Time took for executing sequential stream 2 is: " + checkPerformanceSequentialStream2());
        System.out.println("Time took for executing parallel stream 2 is: " + checkPerformanceParallelStream2());
    }
}
