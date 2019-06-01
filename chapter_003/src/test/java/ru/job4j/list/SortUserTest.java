package ru.job4j.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAddThreeUserGetTreeSet() {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 4));
        users.add(new User("Andrew", 10));
        users.add(new User("John", 1));
        Set<User> result = new TreeSet<>(new SortUser().sort(users));
        Set<User> expected = new TreeSet<>();
        expected.add(new User("John", 1));
        expected.add(new User("Ivan", 4));
        expected.add(new User("Andrew", 10));

        assertThat(result, is(expected));
    }
    @Test
    public void whenAddThreeSortByNameLength() {
        List<User> result = new ArrayList();
        result.add(new User("Ivan", 4));
        result.add(new User("Andrew", 10));
        result.add(new User("Joh", 1));
        SortUser su = new SortUser();
        result = su.sortNameLength(result);
        List<User> expected = new ArrayList<>();
        expected.add(new User("Joh", 1));
        expected.add(new User("Ivan", 4));
        expected.add(new User("Andrew", 10));
        int n = 0;
        for (User user:result) {
            assertThat(user.getName(), is(expected.get(n++).getName()));
        }
    }
    @Test
    public void whenAddThreeSortByAllFields() {
        List<User> result = new ArrayList<>();
        result.add(new User("Ivan", 5));
        result.add(new User("Ivan", 4));
        result.add(new User("John", 1));
        result.add(new User("Andrew", 10));
        SortUser su = new SortUser();
        result = su.sortByAllFields(result);

        List<User> expected = new ArrayList<>();
        expected.add(new User("John", 1));
        expected.add(new User("Ivan", 4));
        expected.add(new User("Ivan", 5));
        expected.add(new User("Andrew", 10));
        int n = 0;
        for (User user:result) {
            assertThat(user.getName(), is(expected.get(n).getName()));
            assertThat(user.getAge(), is(expected.get(n++).getAge()));
        }
    }
}
