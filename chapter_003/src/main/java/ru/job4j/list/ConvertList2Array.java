package ru.job4j.list;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil(list.size() / (float) rows);
        int[][] array = new int[rows][cells];
        int j = 0;
        int i = 0;
        for (int item:list) {
            array[j][i] = item;
            i++;
            if (i == cells) {
                i = 0;
                j++;
            }
        }
        return array;
    }

    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for(int[] items : list) {
            for (int item : items) {
                result.add(item);
            }
        }
        return result;
    }
}
