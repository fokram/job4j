package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.

        String[] input = {"Привет", "Мир", "Привет", "Супер", "Мир", "Мир", "Мир"};
        ArrayDuplicate array = new ArrayDuplicate();
        String[] resultArray = array.remove(input);
        String[] expectArray = new String[] {"Привет", "Мир", "Супер"};
        assertThat(resultArray, is(expectArray));
    }
}