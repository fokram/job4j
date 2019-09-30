package ru.job4j.map;

public class NodeKV<K, V> {
    private K key;
    private V value;

    NodeKV(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
