package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SearchTest {
    @Test
    public void whenFindShGotIt() {
        Search s = new Search();
        List<File> listFiles = s.files("/Users/r.markov/projects/job4j/chapter_005/src/main/java/ru/job4j/io/tmpdir", Arrays.asList("csv", "sh"));
        assertThat(listFiles.size(), is(5));

        listFiles = s.files("/Users/r.markov/projects/job4j/chapter_005/src/main/java/ru/job4j/io/tmpdir", Arrays.asList("", "sh"));
        assertThat(listFiles.size(), is(2));

//        listFiles.stream().map(File::getName).forEach(System.out::println);
    }
}