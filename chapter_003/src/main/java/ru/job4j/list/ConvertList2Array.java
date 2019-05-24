package ru.job4j.list;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
//        int cells = (int) Math.ceil(list.size() / (float) rows);
//        int[][] array = new int[rows][cells];
//        for (int i = 0; i < rows; i++) {
//             array[i] = convertIntegerArrayToInt(list.subList(i * cells, Math.min(i * cells + cells, list.size())), cells);
//        }
//        return array;
//

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
}
