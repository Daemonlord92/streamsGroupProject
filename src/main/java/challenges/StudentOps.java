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

    //7. **Transform to Map:**
    public static Map<Integer, Student> studentListToMap(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.toMap(Student::getId, s -> s));
    }

    //8. **Get Student Emails:**
    public static List<String> getStudentsEmails(List<Student> students) {
        return students
                .stream()
                .map(Student::getEmail)
                .toList();
    }

    //9. **Check if Any Student is Adult:**
    public static List<Student> getAdultStudents(List<Student> students) {
        return students
                .stream()
                .filter(x -> x.getAge() > 18)
                .toList();
    }

    //10. **Count Students by Gender:**
    public static Map<String, List<Student>> countStudentsByGender(List<Student> students) {
        Map<String, List<Student>> mappedStudents = students
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
        mappedStudents.forEach((x, j) -> {
            System.out.println(x + " " + j.stream().count());
        });
        return mappedStudents;
    }

    //11. **Find Youngest Female Student:**
    public static Student getYoungestFemaleStudent(List<Student> students) {
        return students
                .stream()
                .filter(x -> x.getGender().equalsIgnoreCase("female"))
                .min(Comparator.comparing(Student::getAge))
                .orElse(null);
    }

    //12. **Join Student Names:**
    public static String joinStudentsNames(List<Student> students) {
        StringBuilder nameString = new StringBuilder();
        students
                .stream()
                .forEach(x -> nameString.append(x.getFirst_name()).append(" "));
        return nameString.toString();
    }

    //13. **Calculate Age Sum:**
    public static int sumOfStudentsAges(List<Student> students) {
        return students
                .stream()
                .mapToInt(Student::getAge)
                .sum();
    }

    //14. **Check if All Students are Adults:**
    public static boolean areAllStudentsAdult(List<Student> students) {
        long studentCount = students.stream().count();
        long adultStudentCount = students.stream().filter(x-> x.getAge() > 17).count();
        return studentCount == adultStudentCount;
    }
    //15. **Find Oldest Student:**
    public static Student findTheOldestStudent(List<Student> students) {
        return students
                .stream()
                .max(Comparator.comparing(Student::getAge))
                .get();
    }

    //16. **Convert to Uppercase:**
    public static List<String> studentsFirstNameToUpper(List<Student> students) {
        return students
                .stream()
                .map(x -> x.getFirst_name().toUpperCase())
                .toList();
    }

    //17. **Find Student by ID:**
    public static Student findStudentById(List<Student> students, int id) {
        return students
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //18. **Compute Age Distribution:**
    public static void computeAgeDistribution(List<Student> students) {
        students
                .stream()
                .collect(Collectors.groupingBy(Student::getAge))
                .forEach((x,y) -> {
                    System.out.println("Age " + x + ": " + y.stream().count());
                });
    }

    //19. **Group Students by Age:**
    public static void groupStudentsByAge(List<Student> students) {
        students
                .stream()
                .collect(Collectors.groupingBy(Student::getAge))
                .forEach((x, y) -> {
                    System.out.println("Age "+x+ ":");
                    y.forEach(System.out::println);
                });
    }

    //20. **Calculate Age Standard Deviation:**
    public static void calculateAgeStandardDeviation(List<Student> students) {
        double mean = (students.stream().mapToInt(Student::getAge).sum()/students.stream().count());
        System.out.println(Math.sqrt(students.stream().mapToDouble(s -> Math.pow(s.getAge() - mean, 2)).average().orElse(0.0)));
    }
}
