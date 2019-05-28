package ru.job4j.list;

import java.util.*;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] x : array) {
            for (int y : x) {
                list.add(y);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        TreeSet <String> hs = new TreeSet<String>();
        hs.add("alfa");
        hs.add("betta");
        hs.add("gamma");
        hs.add("delta");
        hs.add("epsilon");
//        hs.add(1, "delta");
        System.out.println(hs);
    }
}