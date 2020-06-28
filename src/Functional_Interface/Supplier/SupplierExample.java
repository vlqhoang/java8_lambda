package Functional_Interface.Supplier;

import data.Student;
import data.StudentDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    static Supplier<Student> studentSupplier = () -> new Student("S1", 3, 9.0, "M", new ArrayList<>());
    static Supplier<List<Student>> studentListSupplier = StudentDataBase::getAllStudents;

    public static void main(String[] args) {

        // simple example of supplier
        System.out.println("All student are: " + studentListSupplier.get());
        System.out.println("New student is: " + studentSupplier.get());
    }
}
