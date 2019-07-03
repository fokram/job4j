package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAddThreeUserGetTreeSet() {
        var users = List.of(new User("Ivan", 4),
                new User("Andrew", 10),
                new User("John", 1));
        var result = new TreeSet<>(new SortUser().sort(users));
        var expected = Set.of(
                new User("John", 1),
                new User("Ivan", 4),
                new User("Andrew", 10));

        assertThat(result, is(expected));
    }
    @Test
    public void whenAddThreeSortByNameLength() {
        var result = List.of(
                new User("Ivan", 4),
                new User("Andrew", 10),
                new User("Joh", 1));
        var su = new SortUser();
        result = su.sortNameLength(result);
        var expected = List.of(
                new User("Joh", 1),
                new User("Ivan", 4),
                new User("Andrew", 10));
        var n = 0;
        for (var user:result) {
            assertThat(user.getName(), is(expected.get(n++).getName()));
        }
    }
    @Test
    public void whenAddThreeSortByAllFields() {
        var result = List.of(
                new User("Ivan", 5),
                new User("Ivan", 4),
                new User("John", 1),
                new User("Andrew", 10));
        var su = new SortUser();
        result = su.sortByAllFields(result);

        var expected = List.of(
                new User("John", 1),
                new User("Ivan", 4),
                new User("Ivan", 5),
                new User("Andrew", 10));
        var n = 0;
        for (var user:result) {
            assertThat(user.getName(), is(expected.get(n).getName()));
            assertThat(user.getAge(), is(expected.get(n++).getAge()));
        }
    }
}
