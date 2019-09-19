package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {
    User user = new User("Ivan", 1, new GregorianCalendar(2000, 1, 1));
    User user2 = new User("Ivan", 1, new GregorianCalendar(2000, 1, 1));

    @Test
    public void whenCompareTwoTheSameUsers() {
        System.out.println(user);
        System.out.println(user2);
        assertThat(user.equals(user2), is(false));
    }

    @Test
    public void whenAddTwoEqualsObjectInMap() {
        Map<User, Object> hm = new HashMap<>();
        System.out.println(user.hashCode());
        System.out.println(user2.hashCode());

        hm.put(user, (Object) 1);
        hm.put(user2, (Object) 2);
        System.out.println(hm);
    }
}