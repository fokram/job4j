package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {


        return new Iterator<Integer>() {
            Iterator currentIterator = it.next();
            @Override
            public boolean hasNext() {
                if (!currentIterator.hasNext() && it.hasNext()) {
                    currentIterator = it.next();
                }
                return currentIterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!currentIterator.hasNext()) {
                    if (it.hasNext()) {
                        currentIterator = it.next();
                    } else {
                        throw new NoSuchElementException();
                    }
                }
                return (Integer) currentIterator.next();
            }
        };
    }
}
