package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorArray implements Iterator {
    private Integer indexY = 0;
    private Integer indexX = 0;
    private int[][] matrix;

    public IteratorArray(int[][] matrix) {
        this.matrix = matrix;
    }

    private boolean hasNextX() {
        return indexY < matrix.length;
    }

    private boolean hasNextY() {
        return indexX < matrix[indexY].length;
    }

    @Override
    public boolean hasNext() {
        return hasNextX()
                && hasNextY();
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer result = matrix[indexY][indexX++];
        if (indexX == matrix[indexY].length) {
            indexY++;
            indexX = 0;
        }
        return result;
    }
}
