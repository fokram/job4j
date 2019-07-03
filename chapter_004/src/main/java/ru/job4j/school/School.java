package ru.job4j.school;

import ru.job4j.tur.Address;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    Map<String, Student> collect(List<Student> students, Predicate<Student> predict) {
        return students
                .stream()
                .filter(predict)
                .collect(Collectors
                        .toMap(p -> p.getLastName(), p -> p));
    }
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .dropWhile(score -> score.getScore() < bound)
                .collect(Collectors.toList());
    }
}
