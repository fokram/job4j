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
        return this.indexY < this.matrix.length;
    }

    private boolean hasNextY() {
        return this.indexX < this.matrix[this.indexY].length;
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
        Integer result = this.matrix[this.indexY][this.indexX++];
        if (this.indexX == this.matrix[this.indexY].length) {
            this.indexY++;
            this.indexX = 0;
        }
        return result;
    }
}
