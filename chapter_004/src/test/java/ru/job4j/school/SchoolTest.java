package ru.job4j.school;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void getClassesList() {
        List<Student> students = List.of(
                new Student(5),
                new Student(33),
                new Student(80),
                new Student(100),
                new Student(90),
                new Student(50),
                new Student(24),
                new Student(65),
                new Student(22),
                new Student(97),
                new Student(86),
                new Student(1),
                new Student(56),
                new Student(80));
        List<Student> a = new School().collect(students, student -> student.getScore() <= 50);
        List<Student> b = new School().collect(students, student -> student.getScore() > 50 && student.getScore() <= 70);
        List<Student> c = new School().collect(students, student -> student.getScore() > 70);

        boolean result = false;
        if (a.size() == 6 & b.size() == 2 & c.size() == 6) {
            result = true;
        }
        assertThat(result, is(true));
    }
}
