package ru.job4j.list;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; i < Math.min(left.length(), right.length()) && result == 0; i++) {
            if (right.length() <= i) {
                result = -1;
                break;
            }
            result = Character.compare(left.charAt(i), right.charAt(i));
        }
        if (result == 0) {
            result = left.length() - right.length();
        }
        return result;
    }
}