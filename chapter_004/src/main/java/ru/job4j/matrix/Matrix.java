package ru.job4j.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {
    public List<Integer> getListFromMatrix(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(e -> Arrays.stream(e)).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        Integer[][] a = {{1, 2, 8, 3}, {4, 5, 6}, {4, 5, 6}};
        Matrix matrix = new Matrix();
        System.out.println(matrix.getListFromMatrix(a));
    }
}
