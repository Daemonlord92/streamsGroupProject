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
        System.out.println("Question 6");
        System.out.println(StudentOps.maximumAgeOfStudent(students));
        System.out.println("Question 7");
        Map<Integer, Student> indexOfStudents = StudentOps.studentListToMap(students);
        System.out.println(indexOfStudents);
        System.out.println("Question 8");
        List<String> emails = StudentOps.getStudentsEmails(students);
        emails.forEach(System.out::println);
        System.out.println("Question 9");
        List<Student> adultStudents = StudentOps.getAdultStudents(students);
        adultStudents.forEach(System.out::println);
        System.out.println("Question 10");
        StudentOps.countStudentsByGender(students);
        System.out.println("Question 11");
        System.out.println(StudentOps.getYoungestFemaleStudent(students));
        System.out.println("Question 12");
        System.out.println(StudentOps.joinStudentsNames(students));
        System.out.println("Question 13");
        System.out.println(StudentOps.sumOfStudentsAges(students));
        System.out.println("Question 14");
        System.out.println(StudentOps.areAllStudentsAdult(students));
        System.out.println("Question 15");
        System.out.println(StudentOps.findTheOldestStudent(students));
        System.out.println("Question 16");
        StudentOps.studentsFirstNameToUpper(students).forEach(System.out::println);
        System.out.println("Question 17");
        System.out.println(StudentOps.findStudentById(students, 66));
        System.out.println(StudentOps.findStudentById(students, 15));
        System.out.println("Question 18");
        StudentOps.computeAgeDistribution(students);
        System.out.println("Question 19");
        StudentOps.groupStudentsByAge(students);
        System.out.println("Question 20");
        StudentOps.calculateAgeStandardDeviation(students);
        System.out.println("Question 1 Cars");
        System.out.println(filterByMake(cars, "Ford"));
        System.out.println("Question 2 Cars");
        System.out.println(filterByYear(cars, 1995));
        System.out.println("Question 3 Cars");
        System.out.println(filterByPrice(cars, 58424.51));
        System.out.println("Question 4 Cars");
        System.out.println(mapToModelNames(cars));
        System.out.println("Question 5 Cars");
        System.out.println(mapToUpperCaseMakes(cars));
        System.out.println("Question 6 Cars");
        System.out.println(sortByYear(cars));
        System.out.println("Question 7 Cars");
        System.out.println(sortByPrice(cars));
        System.out.println("Question 8 Cars");
        System.out.println(getTheHighestPricedCar(cars));
        System.out.println("Question 9 Cars");
        System.out.println(getLowestPricedCar(cars));
        System.out.println("Question 10 Cars");
        groupByMake(cars).forEach((x, y) -> {
            System.out.println(x +":");
            y.forEach(System.out::println);
        });
        System.out.println("Question 11 Cars");
        countCarsByMake(cars);
        System.out.println("Question 12 Cars");
        System.out.println(averagePrice(cars));
        System.out.println("Question 13 Cars");
        System.out.println(sumOfPrices(cars));
        System.out.println("Question 14 Cars");
        anyCarWithColor(cars, "blue").forEach(System.out::println);
        System.out.println("Question 15 Cars");
        allCarsAreExpensive(cars).forEach(System.out::println);
    }

}
