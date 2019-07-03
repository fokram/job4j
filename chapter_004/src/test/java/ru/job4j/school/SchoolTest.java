package ru.job4j.school;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void getClassesList() {
        List<Student> students = List.of(
                new Student("Andrew", "Belyakov", 5),
                new Student("John", "Belkovsky", 33),
                new Student("Ivan", "Ivanov", 80),
                new Student("Dmitry", "Balabanov", 100),
                new Student("Sergey", "Vanin", 90),
                new Student("Mark", "Frankenstein", 50),
                new Student("Arseniy", "Belov", 24),
                new Student("Boris", "Petrov", 65),
                new Student("Leo", "Smirnov", 22),
                new Student("Petr", "Petrov", 97),
                new Student("Albert", "Qwert", 86),
                new Student("Bengamin", "OIUytr", 1),
                new Student("Robert", "Kjhgfd", 56),
                new Student("Valentin", "Hbnm", 80));
        Map<String, Student> a = new School().collect(students, student -> student.getScore() <= 50);
        Map<String, Student> b = new School().collect(students, student -> student.getScore() > 50 && student.getScore() <= 70);
        Map<String, Student> c = new School().collect(students, student -> student.getScore() > 70);
        boolean result = false;
        if (a.size() == 6 & b.size() == 2 & c.size() == 6) {
            result = true;
        }
        assertThat(result, is(true));
    }

    @Test
    public void getCheckLevelOf() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Andrew", "Belyakov", 5));
        students.add(new Student("John", "Belkovsky", 33));
        students.add(new Student("Petr", "Petrov", 11));
        students.add(new Student("Albert", "Qwert", 86));
        students.add(new Student("a", "s", 1));
        students.add(new Student("Robert", "Kjhgfd", 56));
        students.add(new Student("s", "a", 76));
        students.add(new Student("Valentin", "Hbnm", 98));

        students.sort(students.get(0));

        List<Student> result = new School().levelOf(students, 50);

        List<Student> expected = List.of(
                new Student("Robert", "Kjhgfd", 56),
                new Student("s", "a", 76),
                new Student("Albert", "Qwert", 86),
                new Student("Valentin", "Hbnm", 98)
        );
        assertThat(result, is(expected));
    }
}
