package ru.job4j.statistic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AnalizeTest {

    @Test
    public void whenCompareGetAnalize() {
        List<Analize.User> previous = new ArrayList<>();
        previous.add(new Analize.User(1, "IVAN"));
        previous.add(new Analize.User(2, "ANDREW"));
        previous.add(new Analize.User(3, "BERG"));
        previous.add(new Analize.User(4, "qwert"));
        previous.add(new Analize.User(5, "gfdsa"));
        previous.add(new Analize.User(6, "asdf"));

        List<Analize.User> current = new ArrayList<>();
        current.add(new Analize.User(1, "IVAN"));
        current.add(new Analize.User(2, "ANDREY"));
        current.add(new Analize.User(7, "ANDREY7"));
        current.add(new Analize.User(8, "ANDREY8"));

        Analize.Info a = new Analize().diff(previous, current);

        System.out.println("Added:" + a.getAdded());
        System.out.println("Deleted:" + a.getDeleted());
        System.out.println("Changed:" + a.getChanged());
    }

}