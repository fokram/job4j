package ru.job4j.generic;


public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean remove(String id);

    T findById(String id);
}