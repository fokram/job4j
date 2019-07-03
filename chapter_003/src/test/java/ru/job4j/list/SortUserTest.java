package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAddThreeUserGetTreeSet() {
        List<User> users = List.of(new User("Ivan", 4),
                new User("Andrew", 10),
                new User("John", 1));
        Set<User> result = new TreeSet<>(new SortUser().sort(users));
        Set<User> expected = Set.of(
                new User("John", 1),
                new User("Ivan", 4),
                new User("Andrew", 10));

        assertThat(result, is(expected));
    }
    @Test
    public void whenAddThreeSortByNameLength() {
        List<User> result = List.of(
                new User("Ivan", 4),
                new User("Andrew", 10),
                new User("Joh", 1));
        SortUser su = new SortUser();
        result = su.sortNameLength(result);
        List<User> expected = List.of(
                new User("Joh", 1),
                new User("Ivan", 4),
                new User("Andrew", 10));
        int n = 0;
        for (User user:result) {
            assertThat(user.getName(), is(expected.get(n++).getName()));
        }
    }
    @Test
    public void whenAddThreeSortByAllFields() {
        List<User> result = List.of(
                new User("Ivan", 5),
                new User("Ivan", 4),
                new User("John", 1),
                new User("Andrew", 10));
        SortUser su = new SortUser();
        result = su.sortByAllFields(result);

        List<User> expected = List.of(
                new User("John", 1),
                new User("Ivan", 4),
                new User("Ivan", 5),
                new User("Andrew", 10));
        int n = 0;
        for (User user:result) {
            assertThat(user.getName(), is(expected.get(n).getName()));
            assertThat(user.getAge(), is(expected.get(n++).getAge()));
        }
    }
}
