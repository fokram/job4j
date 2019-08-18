package ru.job4j.iterators;

import java.util.Iterator;

public class IteratorArray implements Iterator {
    private Integer indexX = 0;
    private Integer indexY = 0;
    private int[][] values;

    public IteratorArray(int[][] values) {
        this.values = values;
    }

    private boolean hasNextX() {
        return indexX < values.length - 1;
    }

    private boolean hasNextY() {
        return indexY < values[indexX].length;
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
            result = values[indexX][indexY++];
        } else if (hasNextX()) {
            indexY = 0;
            result = values[++indexX][indexY++];
        } else {
            result = 0;
        }
        return result;
    }
}
