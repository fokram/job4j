package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    SimpleHashMap<String, Integer> table = new SimpleHashMap<>();
    @Before
    public void setUp() {
        this.table.insert("first", 1);
        this.table.insert("second", 2);
        this.table.insert("third", 3);
        this.table.insert("forth", 4);
        this.table.insert("fifth", 5);
        this.table.insert("sixth", 6);
        this.table.insert("seventh", 7);
        this.table.insert("eighth", 8);
        this.table.insert("ninth", 9);
        this.table.insert("tenth", 10);
        this.table.insert("eleventh", 11);
        this.table.insert("twelfth", 12);
        this.table.insert("thirteenth", 13);
        this.table.insert("fourteenth", 14);
        this.table.insert("fifteenth", 15);
        this.table.insert("sixteenth", 16);
    }

    @Test
    public void whenAddToExtendArrayThenExtendedAndRebuilded() {
        int index = this.table.getIndex("first");
        this.table.insert("fgbhnjkiuyhgb", 17);
        assertThat(table.getCapacity(), is(32));
        assertThat(this.table.getIndex("first"), not(index));
    }


    @Test
    public void whenAddExistingElementThanFalse() {
        assertThat(this.table.insert("sixteenth", 16), is(false));
    }

}