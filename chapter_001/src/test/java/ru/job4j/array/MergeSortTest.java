package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MergeSortTest {
    @Test
    public void whenSortedThenTrue1() {
        int[] input1 = {1, 2, 100, 102, 103};
        int[] input2 = {3, 4, 99, 101, 102, 104};
        MergeSort array = new MergeSort();
        int[] resultArray = array.merge(input1, input2);
        int[] expectArray = new int[] {1, 2, 3, 4, 99, 100, 101, 102, 102, 103, 104};
        assertThat(resultArray, is(expectArray));
    }

    @Test
    public void whenSortedThenTrue2() {
        int[] input1 = {1, 2, 100, 102, 104};
        int[] input2 = {3, 4, 99, 101, 102, 103};
        MergeSort array = new MergeSort();
        int[] resultArray = array.merge(input1, input2);
        int[] expectArray = new int[] {1, 2, 3, 4, 99, 100, 101, 102, 102, 103, 104};
        assertThat(resultArray, is(expectArray));
    }
}