package ru.job4j.iterators;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IteratorArrayTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        int cnt = 0;
        int aa;

        IteratorArray itArray = new IteratorArray(new int[][] {{1}, {2, 3}, {4, 5, 6}});

        while (itArray.hasNext()) {
            System.out.println((int) itArray.next());
            cnt++;
        }
        assertThat(cnt, is(6));
    }
}
