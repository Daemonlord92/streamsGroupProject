package challenges;

import data.FetchData;
import domain.Student;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentOps {
    //  1. Filter Students by Gender: Write a method to filter a list of students by their gender.

    public static List<Student> filterStudentsByGender(List<Student> students, String gender) {
        return students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .toList();
    }

    //2. Sort Students by Age: Sort the list of students by their age (based on date of birth).
    public static List<Student> sortStudentsByAge(List<Student> students) {
        LocalDate currentDate = LocalDate.now();
        students.forEach(student -> {
            LocalDate dob = student.getDob();
            Period period = Period.between(dob, currentDate);
            student.setAge(period.getYears());
        });
        return  students.stream()
                    .sorted(Comparator.comparing(Student::getAge))
                    .toList();
    }

    //3. **Calculate Average Age:**
    public static int averageAgeOfStudents(List<Student> students) {
        return (int) students
                .stream()
                .mapToInt(Student::getAge)
                .summaryStatistics()
                .getAverage();
    }
    //4. **Print Student Names:**
    public static void printStudentsNames(List<Student> students) {
        List<String> names = students
                .stream()
                .map(x -> x.getFirst_name() + " " + x.getLast_name())
                .toList();
        names.forEach(System.out::println);
    }

    //5. **Group Students by Gender:**
    public static Map<String,List<Student>> groupStudentsByGender(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }

    //6. **Find Maximum Age:**
    public static int maximumAgeOfStudent(List<Student> students) {
        return students
                .stream()
                .mapToInt(Student::getAge)
                .max()
                .getAsInt();
    }
}
