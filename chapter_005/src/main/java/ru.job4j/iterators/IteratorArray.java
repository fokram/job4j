package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorArray implements Iterator {
    private Integer indexX = 0;
    private Integer indexY = 0;
    private int[][] matrix;

    public IteratorArray(int[][] matrix) {
        this.matrix = matrix;
    }

    private boolean hasNextX() {
        return indexX < matrix.length - 1;
    }

    private boolean hasNextY() {
        return indexY < matrix[indexX].length;
    }

    @Override
    public boolean hasNext() {
        return hasNextX()
                || hasNextY();
    }

    @Override
    public Object next() {
        Integer result;
        if (hasNextY()) {
            result = matrix[indexX][indexY++];
        } else if (hasNextX()) {
            indexY = 0;
            result = matrix[++indexX][indexY++];
        } else {
            result = null;
        }
        if (result == null) {
                throw new NoSuchElementException();
        }
        return result;
    }
}
