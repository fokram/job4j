package ru.job4j.list;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenAddThreeUserGetMap() {
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
}
