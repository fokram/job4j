package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        var list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when8ElementsThen8() {
        var list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                4
        );
        int[][] expect = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7, 8}
        };
        assertThat(result, is(expect));
    }


    @Test
    public void whenConvertThenConverted() {
        var convertedList = new ConvertList2Array();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        var result = convertedList.convert(list);
        var expect = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(result, is(expect));
    }
}