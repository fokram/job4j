package ru.job4j.list;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        var list = new ConvertMatrix2List();
        int[][] input = {
                {1, 2},
                {3, 4}
        };
        var expect = Arrays.asList(
                1, 2, 3, 4
        );
        var result = list.toList(input);
        assertThat(result, is(expect));
    }
}
