package ru.job4j.list;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertList2Array {

    private int[] convertIntegerArrayToInt(List<Integer> sublist, int cells) {
        int[] result = new int[cells];
        int i = 0;
        for (Integer item : sublist) {
            result[i++] = item;
        }
        return result;
    }
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (float) rows);
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
             array[i] = convertIntegerArrayToInt(list.subList(i * cells, Math.min(i * cells + cells, list.size())), cells);
        }
        return array;
    }
}
