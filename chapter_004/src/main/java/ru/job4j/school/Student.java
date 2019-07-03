package ru.job4j.school;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparator<Student> {
    private int score;
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Student{"
                + "score=" + score
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + '}';
    }

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getScore(), o2.getScore());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score
                && Objects.equals(firstName, student.firstName)
                && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, firstName, lastName);
    }
}
