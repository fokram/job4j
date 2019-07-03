package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void whenAddThreeUserGetMap() {
        List<User> list = List.of(
                new User(1, "Ivan", "Moscow"),
                new User(99, "Andrew", "NewYork"),
                new User(50, "John", "Portland"));
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> result = new HashMap<>(uc.process(list));

        assertThat(result.get(99).getName(), is("Andrew"));
    }
}
