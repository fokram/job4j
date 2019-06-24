package ru.job4j.calc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Calc {
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        while (start < end) {
            list.add(func.apply(Double.valueOf(start++)));
        }
        return list;
    }
}