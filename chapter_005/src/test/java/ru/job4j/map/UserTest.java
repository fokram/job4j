package ru.job4j.map;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenCompareTwoTheSameUsers() {
        User user = new User("Ivan", 1, new GregorianCalendar(2000,1,1));
        User user2 = new User("Ivan", 1, new GregorianCalendar(2000,1,1));
        System.out.println(user);
        System.out.println(user2);
        assertThat(user.equals(user2), is(false));
    }

}