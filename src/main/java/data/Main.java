package data;

import challenges.CarOps;
import challenges.StudentOps;
import domain.Car;
import domain.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static challenges.CarOps.*;
import static data.FetchData.getCarList;
import static data.FetchData.getStudentList;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = getStudentList();
        List<Car> cars = getCarList();
        System.out.println("Question1: +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        getCarList().stream()
                .limit(5)
                .forEach(System.out::println);
        System.out.println("++++++++++++++++");
        getStudentList().stream()
                .limit(5)
                .forEach(System.out::println);

        System.out.println("Question2 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Student> sortedStudents = StudentOps.sortStudentsByAge(students);

        if (sortedStudents != null) {
            sortedStudents.forEach(student -> {
                System.out.println(student.getFirst_name() + ": " + student.getAge());
            });
        }
        System.out.println("Question 3");
        System.out.println(StudentOps.averageAgeOfStudents(students));
        System.out.println("Question 4");
        StudentOps.printStudentsNames(students);
        System.out.println("Question 5");
        Map<String, List<Student>> mappedStudents = StudentOps.groupStudentsByGender(students);
        mappedStudents.forEach((x, j) ->{
            System.out.println(x);
            j.forEach(System.out::println);
        });

    }

}
