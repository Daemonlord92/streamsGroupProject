package data;

import challenges.StudentOps;
import domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentOpsTest {


        private static List<Student> students;

        @BeforeAll
        static void setUp() throws IOException {
            // Fetch data before all tests
            students = FetchData.getStudentList();
        }



        @Test
        void shouldReturnEmptyListWhenNoStudentsMatchGender() {
            List<Student> filteredStudents = StudentOps.filterStudentsByGender(students, "Other");
            assertThat(filteredStudents).isEmpty();
        }

        @Test
        void shouldReturnListStudentsMatchingGender() {
            List<Student> filteredStudents = StudentOps.filterStudentsByGender(students, "Female");
            assertEquals("Female",filteredStudents.get(5).getGender());
        }

        @Test
        void shouldReturnIntegerForAverageAge() {
            int res = StudentOps.averageAgeOfStudents(students);
            Assertions.assertEquals(35, res);
        }

        @Test
        void shouldReturnMapGroupingStudentsByGender() {
            Map<String, List<Student>> groupedStudents = StudentOps.groupStudentsByGender(students);
            Assertions.assertEquals("Agender", groupedStudents.get("Agender").getFirst().getGender());
        }

        @Test
        void shouldReturnNullIfNoStudentsInThatGroup() {
            Map<String, List<Student>> groupedStudents = StudentOps.groupStudentsByGender(students);
            Assertions.assertEquals(null, groupedStudents.get("Asexual"));
        }

        @Test
        void ShouldReturnIntForMaxAgeOfStudents() {
            int res = StudentOps.maximumAgeOfStudent(students);
            Assertions.assertEquals(54, res);
        }

        @Test
        void shouldReturnAMap() {
            Map<Integer, Student> mapped = StudentOps.studentListToMap(students);
            Assertions.assertNotNull(mapped);
        }

        @Test
        void shouldReturnAListWithEmailsInIt() {
            List<String> emails = StudentOps.getStudentsEmails(students);
            Assertions.assertNotNull(emails);
            Assertions.assertEquals("kpadden0@utexas.edu", emails.getFirst());
        }

        @Test
        void shouldReturnListWithAdultsInIt() {
            List<Student> adults = StudentOps.getAdultStudents(students);
            Assertions.assertTrue(adults.stream().allMatch(x-> x.getAge() > 17));
        }

        @Test
        void shouldReturnStudentThatIsTheYoungestFemale() {
            Student youngestStudent = StudentOps.getYoungestFemaleStudent(students);
            Assertions.assertEquals("Female", youngestStudent.getGender());
            Assertions.assertEquals(17, youngestStudent.getAge());
        }

        @Test
        void shouldReturnAStringWithFirstNamesInIt() {
            String[] names = StudentOps.joinStudentsNames(students).split(" ");
            Assertions.assertEquals("Kaitlyn", names[0]);
            Assertions.assertEquals("Melvyn", names[names.length-1]);
        }

        @Test
        void shouldReturnASumOfTheAgesOfStudents() {
            int sum = StudentOps.sumOfStudentsAges(students);
            Assertions.assertEquals(17553, sum);
        }

        @Test
        void shouldReturnFalseForCheckingStudentsAllAdults() {
            boolean result = StudentOps.areAllStudentsAdult(students);
            Assertions.assertFalse(result);
        }

        @Test
        void shouldReturnTheOldestStudent() {
            Student student = StudentOps.findTheOldestStudent(students);
            Assertions.assertEquals(54, student.getAge());
        }

        @Test
        void shouldReturnAListOfNamesThatAreUpperCased() {
            List<String> names = StudentOps.studentsFirstNameToUpper(students);
            Assertions.assertEquals("Kaitlyn".toUpperCase(), names.getFirst());
            Assertions.assertEquals("Melvyn".toUpperCase(), names.getLast());
        }

        @Test
        void shouldReturnAStudentWithTheCorrectId() {
            Student student = StudentOps.findStudentById(students, 345);
            Assertions.assertEquals(345, student.getId());
            student = StudentOps.findStudentById(students, 250);
            Assertions.assertEquals(250, student.getId());
        }

        @Test
        void shouldReturnNullIfIdOutOfBounds() {
            Student student = StudentOps.findStudentById(students, 501);
            Assertions.assertNull(student);
            student = StudentOps.findStudentById(students, 700);
            Assertions.assertNull(student);
        }
    }

