package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class SimpleHashMap<K, V> implements Iterable<NodeKV> {

    private int capacity = 16;
    private int capacityUsed = 0;
    private static double loadFactor = 0.75;

    private NodeKV<K, V> [] table;

    private int modCount = 0;

    public SimpleHashMap() {
        table = new NodeKV[this.capacity];
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getIndex(K key) {
        int result = 0;
        if (key != null) {
//        return Math.abs(key.hashCode() % this.capacity - 1);
            int h = key.hashCode();
            result = ((h) ^ (h >>> 16)) & (this.capacity - 1);

        }
        return result;
    }

    private void extendCapacityAndRebuild() {
        NodeKV<K, V> entry;
        Iterator it = this.iterator();
        this.capacity = this.capacity * 2;
        NodeKV<K, V> [] tableExtended = new NodeKV[this.capacity];
        while (it.hasNext()) {

            entry = (NodeKV) it.next();
            tableExtended[this.getIndex(entry.getKey())] = entry;
        }
        table = tableExtended;
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        int index = getIndex(key);
        if (table[index] == null) {
            if (this.capacityUsed >= this.capacity * this.loadFactor) {
                extendCapacityAndRebuild();
            }
            table[index] = new NodeKV(key, value);
            capacityUsed++;
            modCount++;
            result = true;
        }
        return result;
    }

    V get(K key) {
        return table[getIndex(key)].getValue();
    }

    public boolean delete(K key) {
        boolean result = false;
        Integer index = getIndex(key);

        if (table[index].getKey() == key) {
            table[index] = null;
            capacityUsed--;
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<NodeKV> iterator() {

        int fixedModCount = this.modCount;
        int fixedCapacity = this.capacity;
        return new Iterator<NodeKV>() {
            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                if (fixedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (iteratorIndex < fixedCapacity
                        && table[iteratorIndex] == null) {
                    iteratorIndex++;
                }
                return iteratorIndex < fixedCapacity;
            }

            @Override
            public NodeKV next() {
                if (fixedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[iteratorIndex++];
            }
        };
    }
}
